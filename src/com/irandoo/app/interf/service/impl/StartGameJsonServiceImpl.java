package com.irandoo.app.interf.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conn123.wawadmin.bean.judge.JGameStartNotif;
import com.conn123.wawadmin.webclient.Engine;
import com.irandoo.app.interf.json.DeviceJson;
import com.irandoo.app.interf.json.RoomGrabJson;
import com.irandoo.app.interf.json.RoomJson;
import com.irandoo.app.interf.json.UserAccountJson;
import com.irandoo.app.interf.json.UserJson;
import com.irandoo.app.interf.mapper.DeviceJsonMapper;
import com.irandoo.app.interf.mapper.RoomGrabJsonMapper;
import com.irandoo.app.interf.mapper.UserAccountJsonMapper;
import com.irandoo.app.interf.mapper.UserJsonMapper;
import com.irandoo.app.interf.service.StartGameJsonService;
import com.irandoo.app.interf.util.GameEvent;
import com.irandoo.app.interf.util.PropertiesUtil;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午5:38:33
  */
@Service("startGameJsonService")
public class StartGameJsonServiceImpl implements StartGameJsonService {
	
	private Log log = LogFactory.getLog(StartGameJsonServiceImpl.class);
	
	@Autowired
	private DeviceJsonMapper deviceJsonMapper;
	
	@Autowired
	private UserAccountJsonMapper userAccountJsonMapper;
	
	@Autowired
	private UserJsonMapper userJsonMapper;
	
	@Autowired
	private RoomGrabJsonMapper roomGrabJsonMapper;
	
    /**
	 * 1、判断房间状态，房间忙则直接返回房间忙，如果空闲，则执行下面逻辑；
	 * 2、根据房间id，找到这个房间玩一次游戏所需娃娃币，以及这房间对应的设备信息；
	 * 3、根据用户id，找到该用户的娃娃币余额；
	 * 4、判断余额是否够支付一次游戏，不够后台直接返回余额不足，开始游戏失败；
	 * 5、余额充足，则开启事务，扣除用户娃娃币账户一次游戏费用；
	 * 6、连接娃娃机调度服务器，失败抛出异常，回滚事务并返回设备异常；
	 * 8、连接成功，调度服务器返回设备游戏码（这次游戏的唯一标识）并启动设备；
	 * 9、提交事务；
	 * @return
	 */
	@SuppressWarnings("unused")
	@Transactional
	@Override
	public Map<String,Object> startGame(Map<String, Object> map){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String roomId = map.get("roomId")+"";
		String roomCode = map.get("roomCode")+"";
		String userId = map.get("userId")+"";
		String type = map.get("type")+"";//1-普通游戏，2-练习
	    if(null == roomId){
			resultMap.put("errmsg", "roomId参数为空");
			return resultMap;
		}
	    if(null == roomCode){
	    	resultMap.put("errmsg", "roomCode参数为空");
	    	return resultMap;
	    }
	    if(null == userId){
	    	resultMap.put("errmsg", "userId参数为空");
	    	return resultMap;
	    }
	    if(!"1".equals(type) &&!"2".equals(type) && !"3".equals(type)){
	    	resultMap.put("errmsg", "type参数传输错误：" + type);
	    	return resultMap;
	    }
		String ip = PropertiesUtil.getDevProValByKey("IP") + "";
		String port = PropertiesUtil.getDevProValByKey("PORT") + "";
		
		RoomJson room = RoomJson.getRoomById(roomId);//根据房间id获取房间
		
		if(!"0".equals(room.getStatus())){//判断房间是否使用中
			if(null != room.getUserId() && !userId.equals(room.getUserId()))//判断房间使用人是否一致
			{
				resultMap.put("errmsg", "房间正在使用！");
				return resultMap;
			}else if(null != room.getSnapId()){//判断房间游戏码是否为空，不为空表示设备正在游戏中
				resultMap.put("errmsg", "房间正在使用！");
				return resultMap;
			}
		}
		RoomJson paramJson = null;
		synchronized (room) {//同步锁，同一时间，只允许一个人操作同一个房间
			if(!"0".equals(room.getStatus())){//判断房间是否使用中
				if(null != room.getUserId() && !userId.equals(room.getUserId()))//判断房间使用人是否一致
				{
					resultMap.put("errmsg", "房间正在使用！");
					return resultMap;
				}else if(null != room.getSnapId()){//判断房间游戏码是否为空，不为空表示设备正在游戏中
					resultMap.put("errmsg", "房间正在使用！");
					return resultMap;
				}
			}
			UserJson userJson = userJsonMapper.getInfoById(Long.valueOf(userId));
		
			map.put("type", 1);
			List<DeviceJson> deviceList = deviceJsonMapper.getDeviceByRoom(map);//获取房间的娃娃机设备信息
			DeviceJson deviceJson = deviceList.get(0);
			int coinOnce = 0;
			int balance = 0;
			List<UserAccountJson> accountList =  null;
			UserAccountJson userAccount = null;
			if("1".equals(type)){//普通游戏，操作娃娃币账户
				accountList =  userAccountJsonMapper.getAllList(map);//获取用户娃娃币账户信息
				if(accountList.size() > 0 && deviceList.size() > 0){
					userAccount = accountList.get(0);
					balance = Integer.parseInt(userAccount.getBalance());
					coinOnce = Integer.parseInt(deviceJson.getCoinOnce());
					if(balance < coinOnce){
						resultMap.put("errmsg", "娃娃币账户余额不足！");
						return resultMap;
					}
				}
			}else if("2".equals(type)){//练习，操作练习账户，扣除一个练习币
				map.put("type", "2");
				accountList =  userAccountJsonMapper.getAllList(map);//获取用户练习币账户信息
				if(accountList.size() > 0 && deviceList.size() > 0){
					userAccount = accountList.get(0);
					if(null != userAccount.getBalance()){
						balance = Integer.parseInt(userAccount.getBalance());
						if(balance <= coinOnce){
							resultMap.put("errmsg", "练习币账户余额不足！");
							return resultMap;
						}
					}else{
						resultMap.put("errmsg", "练习币账户余额不足！");
						return resultMap;
					}
				}
			}
			/************调用控制服务器开始游戏接口************/
			JGameStartNotif gameStart = new JGameStartNotif();
			gameStart.setDeviceHost(deviceJson.getIp());
			gameStart.setDevicePort(Integer.parseInt(deviceJson.getPort()));
			gameStart.setCoinUnit(coinOnce);
			gameStart.setDeviceId(Long.parseLong(deviceJson.getId()));
			try {
				Engine.getWebClient().gameStartNotif(gameStart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/************判断控制服务器开始游戏接口返回游戏码，为空表示异常************/
			if(null == gameStart.getSnapId()||"".equals(gameStart.getSnapId())){
				String result = null;
			
				if("E999".equals(gameStart.getResult())||"E999"==gameStart.getResult()){
					result = "房间正在游戏中";
				}else{
					log.info("返回的错误码："+gameStart.getResult());
					result = gameStart.getResult();
				}
				resultMap.put("errmsg", result);
			}else{
				resultMap.put("ip", ip);
				resultMap.put("port", port);
				resultMap.put("snapId", gameStart.getSnapId());
				
				/************设置房间为使用中************/
				paramJson = new RoomJson();
				paramJson.setId(roomId);
				paramJson.setRoomCode(roomCode);
				paramJson.setStatus("1");
				paramJson.setSnapId(gameStart.getSnapId());
				RoomJson.setRoomById(paramJson, userJson);
				
				/**************扣除一次游戏娃娃币或者练习币*****************/
				balance = balance - coinOnce;
				userAccount.setBalance(balance+"");
				userAccountJsonMapper.update(userAccount);
				
				/************插入一条抓取记录************/
				RoomGrabJson roomGrabJson = new RoomGrabJson();
				roomGrabJson.setRoomId(roomId);
				roomGrabJson.setUserId(map.get("userId")+"");
				roomGrabJson.setSnapid(gameStart.getSnapId());
				roomGrabJson.setStatus("2");
				if("1".equals(type)){
					roomGrabJson.setGameType("0");
				}else{
					roomGrabJson.setGameType("1");
				}
				roomGrabJson.setGrabTime(new Date());
				roomGrabJsonMapper.insert(roomGrabJson);
				/************根据配置文件倒计时，开始定时监测，用于处理控制服务器结果没有回调web异常情况以及再玩一局情况************/
				int during = Integer.parseInt(PropertiesUtil.getDevProValByKey("COUNTDOWN") + "") * 1000;
				GameEvent.checkGame(during + "", gameStart.getSnapId(), userId);
			}
			return resultMap;
		}
	}
}

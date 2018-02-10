package com.irandoo.app.interf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conn123.wawadmin.bean.judge.JGameStartNotif;
import com.conn123.wawadmin.webclient.Engine;
import com.irandoo.app.interf.json.DeviceJson;
import com.irandoo.app.interf.json.RoomJson;

import com.irandoo.app.interf.json.VersionJson;
import com.irandoo.app.interf.mapper.DeviceJsonMapper;

import com.irandoo.app.interf.mapper.VersionJsonMapper;
import com.irandoo.app.interf.service.VersionJsonService;
import com.irandoo.app.interf.util.GameEvent;
import com.irandoo.app.interf.util.PropertiesUtil;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;



@Service("versionJsonServiceImp")
public class VersionJsonServiceImp extends BaseServiceImpl<VersionJson> implements VersionJsonService{
	
	 private  Log log =LogFactory.getLog(VersionJsonServiceImp.class);
	@Autowired
	private DeviceJsonMapper deviceJsonMapper;
	
	@SuppressWarnings("unused")
	@Autowired
	private VersionJsonMapper versionJsonMapper;
	
    @Resource
    public void setSuperBaseMapper(VersionJsonMapper versionJsonMapper) {
		super.setBaseMapper(versionJsonMapper);
		this.versionJsonMapper = versionJsonMapper;
	}
    
    @Transactional
	@Override
	public Map<String, Object> testGame(Map<String, Object> map) {
		
    	Map<String,Object> resultMap = new HashMap<String,Object>();
			String roomId = map.get("roomId")+"";		
			String userId = map.get("userId")+"";			
		    String ip = PropertiesUtil.getDevProValByKey("IP") + "";
			String port = PropertiesUtil.getDevProValByKey("PORT") + "";
			log.info("ip:"+ip +"port:"+port);
			//RoomJson room = RoomJson.getRoomById(roomId);//根据房间id获取房间
				map.put("type", 1);
				List<DeviceJson> deviceList = deviceJsonMapper.getDeviceByRoom(map);//获取房间的娃娃机设备信息
				DeviceJson deviceJson = deviceList.get(0);	
				log.info("设备ip:"+deviceJson.getIp()+" 设备端口："+deviceJson.getPort()+" 设备id:"+deviceJson.getId());
				/************调用控制服务器开始游戏接口************/
				JGameStartNotif gameStart = new JGameStartNotif();
				gameStart.setDeviceHost(deviceJson.getIp());
				gameStart.setDevicePort(Integer.parseInt(deviceJson.getPort()));
				gameStart.setCoinUnit(10);
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
		       	}
		return resultMap;
	  }
}

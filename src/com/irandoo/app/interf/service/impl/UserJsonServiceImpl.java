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

import com.irandoo.app.interf.json.MerchJson;
import com.irandoo.app.interf.json.RechargeRecordJson;
import com.irandoo.app.interf.json.UserAccountJson;
import com.irandoo.app.interf.json.UserJson;
import com.irandoo.app.interf.json.UserMerchJson;
import com.irandoo.app.interf.json.UserOrderJson;
import com.irandoo.app.interf.mapper.MerchJsonMapper;
import com.irandoo.app.interf.mapper.RechargeRecordJsonMapper;
import com.irandoo.app.interf.mapper.UserAccountJsonMapper;
import com.irandoo.app.interf.mapper.UserJsonMapper;
import com.irandoo.app.interf.mapper.UserMerchJsonMapper;
import com.irandoo.app.interf.mapper.UserOrderJsonMapper;
import com.irandoo.app.interf.service.UserJsonService;
import com.irandoo.support.wxpay.util.OrderUtil;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-9下午8:31:51
  */
@Service("userJsonService")
public class UserJsonServiceImpl extends BaseServiceImpl<UserJson> implements UserJsonService {
	private Log log = LogFactory.getLog(UserJsonServiceImpl.class);
	@Autowired
	private UserJsonMapper userJsonMapper;
	
	@Autowired
	private UserAccountJsonMapper userAccountJsonMapper;
	
	@Autowired
	private MerchJsonMapper merchJsonMapper;
	
	@Autowired
	private UserMerchJsonMapper userMerchJsonMapper;
    
	@Autowired
	private UserOrderJsonMapper userOrderJsonMapper;
	
	@Autowired
	private RechargeRecordJsonMapper rechargeRecordJsonMapper;
	
    @Resource
    public void setSuperBaseMapper(UserJsonMapper userJsonMapper) {
		super.setBaseMapper(userJsonMapper);
		this.userJsonMapper = userJsonMapper;
	}

	@Override
	public List<UserJson> appLogin(Map<String, Object> map) {
		return userJsonMapper.appLogin(map);
	}
	
	@Override
	public List<UserJson> getByInvitateCode(Map<String, Object> map) {
		return userJsonMapper.getByInvitateCode(map);
	}

	@Transactional
	@Override
	public String bindPhone(Map<String, Object> map, long bind_phone) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", map.get("userId"));
		paramMap.put("type", "1");
		List<UserAccountJson> userAccountList = userAccountJsonMapper.getAllList(map);
		if(userAccountList.size() > 0){
			UserAccountJson ua = userAccountList.get(0);
			long balance = Long.parseLong(ua.getBalance());
			balance = balance + bind_phone;
			ua.setBalance(balance+"");
			userAccountJsonMapper.update(ua);
		}
		userJsonMapper.bindPhone(map);
		return "";
	}
	@Transactional
	@Override
	public Map<String,Object> changeDollToCoin(Map<String, Object> map){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(null == map.get("wawaId")){
			resultMap.put("errmsg", "wawaId不存在");
			return resultMap;
		}
		
		String wawaId = map.get("wawaId")+"";
		/****根据id获取会员娃娃表详情******/
		UserMerchJson userMerch = userMerchJsonMapper.getInfoById(Long.valueOf(wawaId));
		
		/****判断会员娃娃的状态******/
		if (!"1".equals(userMerch.getStatus())) {
			resultMap.put("errmsg", "该娃娃不属于寄存状态");
			return resultMap;
		}
		
		/****根据商户id获取娃娃兑换价以及价格******/
		Map<String, Object> merchMap = new HashMap<String,Object>();
		merchMap.put("merchId", userMerch.getMerchId());
		MerchJson merchJson = merchJsonMapper.getExchangeCoin(merchMap);
		long exchangeCoin = merchJson.getExchangeCoin();
		long price = merchJson.getPrice();
		
		/****更新用户娃娃币账户******/
		Map<String,Object> umap = new HashMap<String,Object>();
		umap.put("userId", Long.parseLong(map.get("userId")+""));
		umap.put("type", "1");
		List<UserAccountJson> useracList = userAccountJsonMapper.getAllList(umap);
		if(useracList.size() > 0 && exchangeCoin != 0){
			UserAccountJson uuu = useracList.get(0);
			long bal = Long.parseLong(uuu.getBalance());
			bal = bal + exchangeCoin;
			uuu.setBalance(bal+"");
			userAccountJsonMapper.update(uuu);
			resultMap.put("exchangeCoin", exchangeCoin);
			resultMap.put("allCoin", bal);
		}else{
			resultMap.put("errmsg", "用户娃娃币账户不存在或者该商品没有兑换币！");
			return resultMap;
		}
		
		/****插入用户订单******/
		UserOrderJson userOrder = new UserOrderJson();
		userOrder.setUserId(userMerch.getUserId());
		userOrder.setOrderType("2");
		userOrder.setOrderCode(OrderUtil.createOrderId());
		userOrder.setMerchId(userMerch.getMerchId());
		userOrder.setStatus("2");
		userOrderJsonMapper.insert(userOrder);
		
		/****插入充值流水******/
		RechargeRecordJson rechargeRecord = new RechargeRecordJson();
		rechargeRecord.setRoomId(userMerch.getRoomId());
		rechargeRecord.setUserId(userMerch.getUserId());
		rechargeRecord.setRechargeOrderId(userOrder.getId());
		rechargeRecord.setRechargeUserId(userMerch.getUserId());
		rechargeRecord.setOrderMoney(price+"");
		rechargeRecord.setExchangeCoin(exchangeCoin+"");
		rechargeRecord.setType("3");
		rechargeRecordJsonMapper.insert(rechargeRecord);
		
		/****更新会员娃娃表状态以及兑换id、订单id******/
		userMerch.setStatus("2");
		userMerch.setRechargeId(rechargeRecord.getId());
		userMerch.setOrderId(userOrder.getId());
		userMerchJsonMapper.update(userMerch);
		
		return resultMap;
	}
	
	@Transactional
	@Override
	public String commitInvitateCode(Map<String, Object> map, long invitation, long invited) {
		UserJson userJson = userJsonMapper.getInfoById(Long.parseLong(map.get("userId")+""));
		String errmsg = "";
		if(null == userJson.getInvitatedCode()||"".equals(userJson.getInvitatedCode())){
			/*****获取邀请人的娃娃币账户信息，并加上奖励娃娃币*****/
			List<UserJson> userList = userJsonMapper.getByInvitateCode(map);
			if(userList.size()>0){
				Map<String,Object> umap = new HashMap<String,Object>();
				umap.put("userId", userList.get(0).getUserId());
				umap.put("type", "1");
				List<UserAccountJson> useracList = userAccountJsonMapper.getAllList(umap);
				if(useracList.size() > 0){
					UserAccountJson ua = useracList.get(0);
					long balance = Long.parseLong(ua.getBalance());
					balance = balance + invitation;
					ua.setBalance(balance+"");
					userAccountJsonMapper.update(ua);
					/*****获取提交人(被邀请人)的娃娃币账户信息，并加上奖励娃娃币*****/
					Map<String,Object> paramMap = new HashMap<String,Object>();
					paramMap.put("userId", map.get("userId"));
					paramMap.put("type", "1");
					List<UserAccountJson> userAccountList = userAccountJsonMapper.getAllList(paramMap);
					if(userAccountList.size() > 0){
						UserAccountJson uuu = userAccountList.get(0);
						long bal = Long.parseLong(uuu.getBalance());
						bal = bal + invited;
						uuu.setBalance(bal+"");
						userAccountJsonMapper.update(uuu);
					}
					/*****end*****/
					userJsonMapper.commitInvitateCode(map);//提交邀请码
				}
			}else{
				errmsg = "该邀请码所对应的用户不存在娃娃币账户";
			}
			/*****end*****/
		}else{
			errmsg = "该用户已提交邀请码，不能重复提交";
		}
		return errmsg;
	}
	
	@Override
	public Map<String,Object> userAccount(Map<String,Object> map){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		map.put("type", "1");
		List<UserAccountJson> wawaList = userAccountJsonMapper.getAllList(map);
		if(wawaList.size() > 0){
			resultMap.put("coinNum", wawaList.get(0).getBalance());
		}else{
			resultMap.put("coinNum",0);
			resultMap.put("errmsg","没找到该用户对应的娃娃币账户userId:"+map.get("userId"));
			log.info("没找到该用户对应的娃娃币账户userId:"+map.get("userId"));
		}
		map.put("type", "2");
		List<UserAccountJson> priticeList = userAccountJsonMapper.getAllList(map);
		if(priticeList.size() > 0){
			resultMap.put("exerciseNum", priticeList.get(0).getBalance());
		}else{
			resultMap.put("exerciseNum",0);
			resultMap.put("errmsg","没找到该用户对应的练习币账户userId:"+map.get("userId"));
			log.info("没找到该用户对应的练习币账户userId:"+map.get("userId"));
		}
		return resultMap;
	}
}

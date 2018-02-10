package com.irandoo.xhep.base.service;

import java.util.Map;

import com.irandoo.xhep.base.model.Login;

public interface LoginService extends BaseService<Login>{

	/**
	 * 根据id修改登出时间
	 * @param map
	 */
	void updateTime(Map<String, Object> map);
	/**
	 * 根据userId获取为登出时间null的那条流水记录
	 * @param userId
	 * @return
	 */
	String getIdByUserId(String userId);
}

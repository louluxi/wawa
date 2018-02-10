package com.irandoo.xhep.anth.service;

import java.util.Map;

public interface JwtLoginService {
	/**
	 * description: 根据认证码调取微信平台获取信息
	 * @param code 认证码
	 * @return 返回出加密的
	 */
	Map<String, Object> getAccessToken(String code,Map<String, Object> m);
      
      
      
      
}

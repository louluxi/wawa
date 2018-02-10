package com.irandoo.xhep.anth.action;



import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.xhep.anth.service.JwtLoginService;
import com.irandoo.xhep.anth.util.JwtTokenUtil;
import com.irandoo.xhep.anth.util.LoadingAuthUtil;
import com.irandoo.xhep.base.action.BaseAction;
import com.irandoo.xhep.base.model.User;
import com.irandoo.xhep.base.service.UserService;


/**
 * 
 * @author sun
 * @version 1.0
 * @date 2018年1月2日19:58:07
 */

@Controller("loginJwtAuthAction")
@Scope("prototype")
public class LoginJwtAuthAction extends BaseAction{

	
	private static final long serialVersionUID = -8273080676543377151L;

	  @Autowired
	  private JwtLoginService jwtLoginService;
	  
	  @Autowired
	  private UserService userService;
	 
	public String appLogin(){
		//从header头部里面取出设备类型，设备编号，以及登录方式
		String loginMode =	request.getHeader("channel");
		String modeType =	request.getHeader("app-idfa");
		String modeCode =	request.getHeader("device");
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("loginMode", loginMode);
		headerMap.put("modeType", modeType);
		headerMap.put("modeCode", modeCode);
		//加载配置文件
	    Map<String, Object> maps = LoadingAuthUtil.loading();
	    String secret = (String) maps.get("secret");
		//获取传过来的code
	    String o = request.getParameter("object");
	    Map<String, Object> oMap = (Map<String, Object>) JSON.parse(o);
	    String code = (String) oMap.get("code");

		//调取微信的认证授权后的token
	    Map<String, Object> returnMap =  jwtLoginService.getAccessToken(code,headerMap);	 
	    String accessToken = (String) returnMap.get("accessToken");
	    String isFirstLogin = (String) returnMap.get("isFirstLogin");
	    
	    //将openid取出来
	    String openid = JwtTokenUtil.getOpenidStringFromToken(accessToken, secret);
	    //根据open_id，然后调取数据库获取信息
	    User user = userService.getInfoByOpenId(openid);
	    //将加密字符串与用户信息一起传给APP端    
	    //放进map，转成JSON	
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("authorization", accessToken);
	    map.put("userCode", user.getUser_code());
	    map.put("nickName",user.getNick_name());
	    map.put("gender", user.getGender());
	    map.put("userIcon", user.getUser_image());
	    map.put("user_nationality", user.getUser_nationality());
	    map.put("province", user.getProvince());
	    map.put("city", user.getCity());;
	    map.put("isFirstLogin",isFirstLogin);
	    map.put("invitateCode", user.getInvitate_code());
	    map.put("shareIcon", user.getShareIcon());
	    map.put("invitatedCode", user.getInvitated_code());
	    map.put("tel", user.getUser_tel());
	    return  returnJson(map, "0", "");
	}
	
}

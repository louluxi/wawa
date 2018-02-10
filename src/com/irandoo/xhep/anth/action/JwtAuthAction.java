package com.irandoo.xhep.anth.action;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.anth.model.JwtToken;
import com.irandoo.xhep.anth.service.JwtTokenService;
import com.irandoo.xhep.anth.util.JwtTokenUtil;
import com.irandoo.xhep.anth.util.LoadingAuthUtil;

import com.irandoo.xhep.anth.util.TimeUtils;
import com.irandoo.xhep.base.action.BaseAction;
/**
 * @description：检验token
 * @author sun
 * version 1.0
 * date 2018年1月2日20:12:32
 */

@Controller("jwtAuthAction")
@Scope("prototype")
public class JwtAuthAction extends BaseAction{ 
	
	  /**
	 * 
	 */
	  private static final long serialVersionUID = 3332077648878095776L;
	  @Autowired
      private JwtTokenService jwtTokenService;

	  public String refresh(){
	 //--------------------加载配置参数----------------------
	  Map<String, Object> maps =LoadingAuthUtil.loading();
	  String secret =  (String) maps.get("secret");
	  
	   Map<String,Object> map = new HashMap<String,Object>();
	  //抓取请求头里面的token
      String authToken = request.getHeader("token");
      String result="0";;
      String msg="";
       try {
    	//解析获取refreshToken 
        String refreshToken =  JwtTokenUtil.getRefresh_tokenStringFromToken(authToken, secret);
         //获取解密后的时间
   		Date dateExpires_time = JwtTokenUtil.getExpires_inFromToken(authToken, secret);	
   	  //获取系统当前时间
   		Date date = new Date(System.currentTimeMillis());   	
   	  //获取时间差
   		double time = TimeUtils.getTimeDifference(dateExpires_time, date);	
   	  //判断过期时间
   		String accessToken;
   		if (time-1>0) {//不需刷新(时间差大于一小时)
   	  //超过过期时间重新拉取token 调用refreshToken刷新token
   		    accessToken=authToken;
   		} else {       //需要刷新(时间差小于一小时)
   			 JwtToken jwtToken = jwtTokenService.JwtToken(refreshToken);
   		    //再次加密
   			accessToken = JwtTokenUtil.generateAccessToken(jwtToken);
   		}
        map.put("token", accessToken);
       } catch (Exception e) {
    	result="-1";
    	msg="";
		e.printStackTrace();
		}  
      //将值放回给APP
	 	return returnJson(map, result, msg);
	  }
	  
}

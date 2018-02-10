package com.irandoo.app.interf.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.github.qcloudsms.SmsSingleSender;
import com.irandoo.app.interf.service.UserJsonService;
import com.irandoo.app.interf.util.PropertiesUtil;
import com.irandoo.xhep.base.action.BaseAction;
import com.irandoo.xhep.base.service.SysConfigService;
import com.irandoo.xhep.base.util.MD5;

/**
  * <p>Title: 用户相关接口</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:43:55
  */
@Controller("userJsonAction")
@Scope("prototype")
public class UserJsonAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
    private UserJsonService userJsonService;
    
	@Autowired
	private SysConfigService sysConfigService;
	
	public static Map<String,Object> phoneCodeMap = new HashMap<String,Object>();
	
	public String login() {
		Map<String,Object> paramMap = getInterfMap();
		paramMap.put("password", MD5.MD5Encode((String)paramMap.get("username") + (String)paramMap.get("password")));
		return returnJson(userJsonService.appLogin(paramMap), "0", "");
	}
    
	public String getUserDetail() {
		Map<String,Object> paramMap = getInterfMap();
		return returnJson(userJsonService.getInfoById(Long.valueOf(paramMap.get("userId")+"")), "0", "");
	}
	
	public String sendMessage(){
		Map<String,Object> paramMap = getInterfMap();
		int code = (int)((Math.random()*9+1)*1000); //随机生成4位数验证码
		SmsSingleSender sender = new SmsSingleSender(Integer.parseInt(PropertiesUtil.getMsgProValByKey("appid")+""),PropertiesUtil.getMsgProValByKey("appkey")+"");
		ArrayList<String> params = new ArrayList<String>();
		params.add(code+"");
		String result = "0";
		String errmsg = "";
		try {
			sender.sendWithParam("86", paramMap.get("phone")+"", Integer.parseInt(PropertiesUtil.getMsgProValByKey("modelid")+""), params, "", "", "");
		} catch (Exception e) {
			result = "-1";
			errmsg = e.getLocalizedMessage();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("phone", paramMap.get("phone")+"");
		phoneCodeMap.put(paramMap.get("phone")+"", code);
		return returnJson(map, result, errmsg);
	}
	
	public String bindPhone(){
		Map<String,Object> paramMap = getInterfMap();
		String code = paramMap.get("code")+"";
		String phone = paramMap.get("phone")+"";
		String json = "";
		String result = "0";
		String errmsg = "";
		if(code.equals(phoneCodeMap.get(phone)+"")){
			try {
				String bind_phone = sysConfigService.getValue("SYSTEM", "REWARD", "BIND_PHONE");
				userJsonService.bindPhone(paramMap, Long.parseLong(bind_phone));
			}
			catch (Exception e) {
				result = "-1";
				errmsg = e.getLocalizedMessage();
			}
			phoneCodeMap.remove(code);
		}else{
			result = "-1";
			errmsg = "验证码错误";
		}
		return returnJson(json, result, errmsg);
	}
	
	public String commitInvitateCode(){
		Map<String,Object> paramMap = getInterfMap();
		String invitation = sysConfigService.getValue("SYSTEM", "REWARD", "INVITATION");
		String invited = sysConfigService.getValue("SYSTEM", "REWARD", "INVITED");
		String errmsg = userJsonService.commitInvitateCode(paramMap, Long.parseLong(invitation), Long.parseLong(invited));
		if("".equals(errmsg)){
			return returnJson("", "0", "");
		}else{
			return returnJson("", "-1", errmsg);
		}
	}
	public String changeDollToCoin(){
		Map<String,Object> paramMap = getInterfMap();
		Map<String,Object> resultMap = userJsonService.changeDollToCoin(paramMap);
		if(null == resultMap.get("errmsg")){
			return returnJson(resultMap, "0", "");
		}else{
			return returnJson("", "-1", resultMap.get("errmsg")+"");
		}
	}
	
	public String userAccount(){
		Map<String,Object> resultMap =userJsonService.userAccount(getInterfMap());
		if(null == resultMap.get("errmsg")){
			return returnJson(resultMap, "0", "");
		}else{
			return returnJson("", "-1", resultMap.get("errmsg")+"");
		}
	}
}

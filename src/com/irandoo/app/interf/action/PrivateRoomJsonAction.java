package com.irandoo.app.interf.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.irandoo.app.interf.json.MoneyJson;
import com.irandoo.app.interf.json.PrivateRoomJson;
import com.irandoo.app.interf.json.PrivateRoomOnlineJson;
import com.irandoo.app.interf.service.PrivateRoomJsonService;
import com.irandoo.app.interf.service.PrivateRoomOnlineJsonService;
import com.irandoo.xhep.base.action.BaseAction;
import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.model.User;
import com.irandoo.xhep.base.service.UserService;
import com.irandoo.xhep.sys.service.DictionaryService;

/**
 * <p>Title: 包房接口</p>
 * <p>Description: </p>
 * <p>Company: irandoo</p> 
 * @author sun
 * @date 2018年1月13日15:13:32
 */
@Controller("privateRoomJsonAction")
@Scope("prototype")
public class PrivateRoomJsonAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private PrivateRoomJsonService privateRoomJsonService;
	@Autowired
	private PrivateRoomOnlineJsonService PrivateRoomOnlineJsonService;
	@Autowired
	private UserService UserService;
	
	

	@Autowired
	private DictionaryService dictionaryService;
	private List<Dictionary> moneyDescript;
	
	
	/**
	 * @description:获取包房列表(可模糊查询)
	 * @return
	 */
	public String getPrivateRoom() {
		Map<String,Object> paramMap = getInterfMap();
		return returnJson(privateRoomJsonService.getPrivateRoom(paramMap), "0", "");
	}
	/**
	 * @description:获取我的包房列表
	 * @return
	 */
	
	public String getMyPrivateRoom(){
		Map<String,Object> paramMap = getInterfMap();
		return returnJson(privateRoomJsonService.getMyPrivateRoom(paramMap), "0", "");
	}
	
	/**
	 * @description：创建包房
	 * @return
	 */
	public String createPrivateRoom(){
		String o = request.getParameter("object");
		PrivateRoomJson privateRoomJson = JSON.parseObject(o, PrivateRoomJson.class);
	    //获取是否可以包房的标识
		String isPrivate = privateRoomJsonService.getIsPrivateByRoomId(privateRoomJson.getRoomId());
		String result = "0";
		String errmsg = "";
	    if(isPrivate.endsWith("1")){ //判断是可包
			//设置创建人
	    	String userId = (String) request.getAttribute("userId");
			privateRoomJson.setCreator(userId);
			//总费用(根据时间长去匹配)
			moneyDescript =dictionaryService.getByDescript("包房费用");
			List<MoneyJson> moneyJsons=JSONArray.parseArray(moneyDescript.get(0).getDictName(),MoneyJson.class);
		    String sumMoney=null;
			for (int i = 0; i < moneyJsons.size(); i++) {
				if(moneyJsons.get(i).getTimeValue().equals("10")){
					sumMoney=moneyJsons.get(i).getMoney();
				}
				if(moneyJsons.get(i).getTimeValue().equals("15")){
					sumMoney=moneyJsons.get(i).getMoney();
				}
				if(moneyJsons.get(i).getTimeValue().equals("30")){
					sumMoney=moneyJsons.get(i).getMoney();
				}
				if(moneyJsons.get(i).getTimeValue().equals("60")){
					sumMoney=moneyJsons.get(i).getMoney();
				}
			}

			//设置总费用
			privateRoomJson.setSumMoney(sumMoney);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        //设置启用时间			
			try {
				privateRoomJson.setStartTime(new Date());
				//设置停用时间
				Integer minute=new Integer(privateRoomJson.getDuration());
				privateRoomJson.setEndTime(df.parse(df.format(System.currentTimeMillis()+minute*60*100)));
				
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
	        try {	
	        	 privateRoomJsonService.insert(privateRoomJson);
	        	
	        	 /**
	        	  *创建包房成功,将创建人添加进入在线人员表
	        	  */
	        	 PrivateRoomOnlineJson privateRoomOnlineJson=new PrivateRoomOnlineJson();
	        	 //根据userId获取个人信息
	        	User user = UserService.getInfoById(Long.parseLong(userId));
	        	 privateRoomOnlineJson.setRoomId(privateRoomJson.getRoomId());
	        	 privateRoomOnlineJson.setUserId(userId);
	        	 privateRoomOnlineJson.setUserName(user.getNick_name());
	        	 privateRoomOnlineJson.setUserIcon(user.getUser_icon());
	        	 privateRoomOnlineJson.setStatus("4"); //默认是房主
                 //将房主添加进房间人员表
	        	 PrivateRoomOnlineJsonService.insert(privateRoomOnlineJson);	 
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
	        	result = "-1";
	        	errmsg = e.getLocalizedMessage();
	        }
		}else{
			     result = "-1";
        	     errmsg = "当前房间不可被包";
		}
	    Map<String, Object> map=new HashMap<String, Object>();
   	    map.put("id", privateRoomJson.getRoomId());  	  
		return returnJson(privateRoomJsonService.returnInfo(map), result, errmsg);
	}


}

package com.irandoo.xhep.base.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.irandoo.app.interf.service.RoomGrabJsonService;
import com.irandoo.app.interf.util.ImageUtil;
import com.irandoo.xhep.anth.util.LoadingShareUtil;
import com.irandoo.xhep.base.mapper.UserMapper;
import com.irandoo.xhep.base.model.User;
import com.irandoo.xhep.base.service.UserService;
import com.irandoo.xhep.base.util.MD5;
import com.irandoo.xhep.base.util.TxFileUpload;

/**
 * @author ager

 * @date:2015-8-12 下午2:16:52
 * @version : 1.0
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Resource
	public void setSuperBaseMapper(UserMapper userMapper){
	     super.setBaseMapper(userMapper);
	     this.userMapper = userMapper;
	}
	
	/**
	 * 
	 * @author ager
	 * @version 1.0
	 */
	public User login(String username, String password,boolean checkMd5) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", username);
		if(checkMd5){
		    password = MD5.MD5Encode(username + password);
		}
		map.put("user_pwd", password);
		User user = userMapper.login(map);
		return user;

	}
	
	public List<User> getInfoByCode(String user_code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_code", user_code);
		return userMapper.getInfoByCode(map);

	}
	
	public List<User> getAllList(Map<String,Object> map){
		return userMapper.getAllList(map);
	}
	@Override
	@Transactional
    public void deleteOne(long id) {
    	User user = userMapper.getInfoById(id);
    	user.setIs_deleted("Y");
        userMapper.delete(id);
    	userMapper.update(user);
    }
	@Transactional
    public void deleteMore(String ids) {
        List<Long> listid = JSON.parseArray(ids, Long.class);
        for (long id : listid) {
        	User user = userMapper.getInfoById(id);
        	user.setIs_deleted("Y");
        	userMapper.update(user);
        }
    }

	@Override
	public User getInfoByOpenId(String openid) {
		User user=userMapper.getInfoByOpenId(openid);
		return user;
	}

	@Override
	public int judgeUserByOpenId(String openid) {
	    int count =	userMapper.judgeUserByOpenId(openid);
		return count;
	}

	@Override
	public int judgeCodeByCode(String invitateCode) {
		
		return userMapper.judgeCodeByCode(invitateCode);
	}
	/**
	 * 替换所有的二维码图片
	 */
	@Transactional
	public  void repalce () {
	  List<User> userList =	getAllInvitateCode();
	  Map<String, Object> shareMap =	LoadingShareUtil.replaceloading();
	  String backgroundUrl = (String) shareMap.get("backgroundUrl");
   	  String aboveUrl = (String) shareMap.get("aboveUrl");
   	  String compoundUrl = (String) shareMap.get("compoundUrl");
   	  String compoundName = (String) shareMap.get("compoundName");
   	  String finalUrl = (String) shareMap.get("finalUrl");
   	  String str[]={ "386", "984" };
	  for (User user:userList) {
		  String text = user.getInvitate_code();
		  String finalName = "share_"+text+"_"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".png";
		  ImageUtil.crearePicture(backgroundUrl, aboveUrl, compoundUrl, compoundName, text, finalUrl, finalName,str);	
          String cosIconPath  =  TxFileUpload.upload(finalUrl+finalName, finalName, "share");
          user.setShareIcon(cosIconPath);
          userMapper.update(user);
	  }
	  
	}
	
	public static void main(String[] args) {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		UserService userService = (UserService) wac.getBean("userService");
	    
		for (User user:userService.getAllInvitateCode()){
			System.out.println(user.getInvitate_code());
		}
	}

	@Override
	public List<User> getAllInvitateCode() {
		// TODO Auto-generated method stub
		return userMapper.getAllInvitateCode();
	}
}

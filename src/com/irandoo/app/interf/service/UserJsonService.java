package com.irandoo.app.interf.service;

import java.util.List;
import java.util.Map;

import com.irandoo.app.interf.json.UserJson;
import com.irandoo.xhep.base.service.BaseService;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午4:53:24
  */
public interface UserJsonService extends BaseService<UserJson> {
	List<UserJson> appLogin(Map<String, Object> map);
	List<UserJson> getByInvitateCode(Map<String, Object> map);
	String commitInvitateCode(Map<String, Object> map, long invitation,	long invited);
	String bindPhone(Map<String, Object> map, long bind_phone);
	Map<String,Object> changeDollToCoin(Map<String, Object> map);
	Map<String, Object> userAccount(Map<String, Object> map);
}

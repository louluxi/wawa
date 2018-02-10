package com.irandoo.app.interf.mapper;

import java.util.List;
import java.util.Map;

import com.irandoo.app.interf.json.UserJson;
import com.irandoo.xhep.base.mapper.BaseMapper;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午11:12:43
  */
public interface UserJsonMapper extends BaseMapper {
	 List<UserJson> appLogin(Map<String,Object> map);
	 List<UserJson> getByInvitateCode(Map<String,Object> map);
	 void bindPhone(Map<String,Object> map);
	 void commitInvitateCode(Map<String,Object> map);
}

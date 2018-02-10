package com.irandoo.xhep.base.mapper;

import java.util.List;
import java.util.Map;

import com.irandoo.xhep.base.model.User;


/**
 * @author ager

 * @date:2015-8-11 下午6:34:18
 * @version : 1.0
 *
 */
public interface UserMapper extends BaseMapper {
	
	User login(Map<String,Object> map);
	
	/**
	 * @description 根据openid获取用户信息
	 * @param openid
	 * @return  用户实体
	 */
	User getInfoByOpenId(String openid);
	/**
	 * @description 根据openid判断用户是否已经注册
	 * @return 数据条数
	 */
	int judgeUserByOpenId(String openid);
	
	/**
	 * @description 根据invitateCode判断用户是否存在
	 * @param invitateCode 邀请码
	 * @return
	 */
	int judgeCodeByCode(String invitateCode);
	
	/**
	 * 查询所有用户信息，用于查询用户的邀请码
	 * @return
	 */
	List<User> getAllInvitateCode ();
}

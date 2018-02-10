package com.irandoo.xhep.base.service;

import java.util.List;
import java.util.Map;

import com.irandoo.xhep.base.model.User;

/**
 * @author ager

 * @date:2015-8-12 下午1:53:07
 * @version : 1.0
 *
 */
public interface UserService extends BaseService<User> {

	User login(String username, String password, boolean checkMd5);

	List<User> getAllList(Map<String, Object> map);
	
	List<User> getInfoByCode(String user_code);

	void deleteOne(long id);

	void deleteMore(String ids);
	
	/**
	 *  @description 根据openId获取用户信息
	 * @param openid
	 * @return 用户实体
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
	
	/**
	 * 替换所有的二维码
	 */
	void repalce ();
}

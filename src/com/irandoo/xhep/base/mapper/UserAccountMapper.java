package com.irandoo.xhep.base.mapper;

import java.util.List;
import java.util.Map;

import com.irandoo.xhep.base.model.User;
import com.irandoo.xhep.base.model.UserAccount;

public interface UserAccountMapper extends BaseMapper{

	/**
	 *  根据用户id以及账户类型充值
	 * @param map
	 * @return
	 */
	int addBalance(Map<String, Object> map);
	 /**
	  * 获取账户练习币为0的人的用户
	  * @return
	  */
	 List<UserAccount> getUserList();
	 
	 /**
	  * 获取上次抓取记录距离现在超过四个小时的练习币账户
	  * @return
	  */
	 List<UserAccount> detectionAccount();
}

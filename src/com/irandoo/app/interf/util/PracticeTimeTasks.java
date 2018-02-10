package com.irandoo.app.interf.util;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;


import com.irandoo.xhep.base.model.UserAccount;
import com.irandoo.xhep.base.service.UserAccountService;
import com.irandoo.xhep.base.util.SpringContextHolder;
/**
 * @description：检测练习币定时任务类
 * 每隔两小时执行一次，检测所有人员上一次使用练习币的时间是否当前时间相差4个小时，
 * 并且检测练习币账户是否为0，或者null.满足以上两种情况的送练习币一个。
 * @author sun
 *
 */

public class PracticeTimeTasks extends QuartzJobBean{

	@SuppressWarnings("unused")
	private int timeout;  	
	
	//调度工厂实例化后，经过timeout时间开始执行调度 
	public void setTimeout(int timeout) { 
	this.timeout = timeout; 
	} 
	@Transactional
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
	  
		UserAccountService userAccountService =	SpringContextHolder.getBean(UserAccountService.class);
		//获取超过四小时的练习币账户
		List<UserAccount>	userAccounts= 	userAccountService.detectionAccount();
	    //需要送币的id集合
		UserAccount userAccount = new UserAccount();
	    for (int i = 0; i < userAccounts.size(); i++) {
	    	if(userAccounts.get(i).getBalance()==null||userAccounts.get(i).getBalance()==0){
	    		userAccount.setId(userAccounts.get(i).getId());
	    		userAccount.setBalance(Long.parseLong("1"));
	    		userAccountService.update(userAccount);
	    	}
		}
	}

}

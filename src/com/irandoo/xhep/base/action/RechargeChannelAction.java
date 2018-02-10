package com.irandoo.xhep.base.action;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.RechargeChannel;
import com.irandoo.xhep.base.service.RechargeChannelService;

@Controller("rechargeChannelAction")
@Scope("prototype")
public class RechargeChannelAction extends BaseAction {

	
	private static final long serialVersionUID = 5513846571657711411L;
	private Log logger = LogFactory.getLog(RechargeChannelAction.class);
    @Autowired
    private RechargeChannelService rechargeChannelService;
    
    private RechargeChannel rechargeChannel;
    
    /**
	 * 加载参数
	 * 
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = rechargeChannelService.getInfoListStr(getConditionMap());
		return toJsonData(jsonData);
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete() {
		logger.debug("enter delete");
		boolean result = true;
		String id = request.getParameter("ids");
	    try {
	    	rechargeChannelService.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
	    logger.debug("exit delete");

		return result(result);
	}
	/**
	 * 
	 * @return
	 */
	public String getInfoById() {
		logger.debug("enter getInfoById");
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		if (StringUtils.isEmpty(opt)) {
			return ERROR;
		}
		//支付方式添加
		if (ADD.equals(opt)) {
			rechargeChannel = new RechargeChannel();
			request.setAttribute("title", "支付方式添加");
		}
		// 支付方式更新
		else if (UPDATE.equals(opt)) {
			rechargeChannel = rechargeChannelService.getInfoById(Long.parseLong(id));	
			request.setAttribute("title", "支付方式更新");
		}
		// ����ҳ��
		else if (VIEW.equals(opt)) {
			/*user = userService.getInfoById(Long.parseLong(id));
			request.setAttribute("title", "视图");*/
		}
		else {
			request.setAttribute("title", "视图");
		}
		return SUCCESS;
	}
	/**
	 * 更新和保存
	 * @return
	 */
	public String saveOrUpdate() {
		logger.debug("enter saveOrUpdate");
		if (rechargeChannel == null) {
			rechargeChannel = new RechargeChannel();
		}
		if (rechargeChannel.getId() == null) {
			try {	
				rechargeChannelService.insert(rechargeChannel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}else {
			try {
				rechargeChannelService.update(rechargeChannel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}
	}
	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String toLoadList() {
		request.setAttribute("title", "֧支付方式管理");
		return SUCCESS;
	}
	public RechargeChannel getRechargeChannel() {
		return rechargeChannel;
	}

	public void setRechargeChannel(RechargeChannel rechargeChannel) {
		this.rechargeChannel = rechargeChannel;
	}
    
}

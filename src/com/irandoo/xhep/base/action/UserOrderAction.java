package com.irandoo.xhep.base.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.Device;
import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.model.User;
import com.irandoo.xhep.base.model.UserOrder;
import com.irandoo.xhep.base.service.UserOrderService;
import com.irandoo.xhep.sys.service.DictionaryService;
@Controller("userOrderAction")
@Scope("prototype")
public class UserOrderAction extends BaseAction{


	private static final long serialVersionUID = -1342801866160866958L;
	private Log logger = LogFactory.getLog(UserOrderAction.class);
	@Autowired
	private UserOrderService userOrderService;
	private UserOrder userOrder;
	@Autowired
	private DictionaryService dictionaryService;
	private List<Dictionary> orderStrutsList;
	/**
	 * 加载数据
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = userOrderService.getInfoListStr(getConditionMap());
	    return toJsonData(jsonData);
	}
	/**
	 * 查看数据
	 * @return
	 */
	public String getInfoById() {
		logger.debug("enter getInfoById");
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		if (StringUtils.isEmpty(opt)) {
			return ERROR;
		}
		// 新增页面
		if (ADD.equals(opt)) {
			userOrder = new UserOrder();
			request.setAttribute("title", "用户新增");
		}
		// 修改页面
		else if (UPDATE.equals(opt)) {
			userOrder = userOrderService.getInfoById(Long.parseLong(id));	
			request.setAttribute("title", "用户修改");
		}
		// 分配页面
		else if (VIEW.equals(opt)) {
		}
		else {
			request.setAttribute("title", "用户新增");
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String toLoadList() {
		orderStrutsList =  dictionaryService.getByDescript("订单状态");
		request.setAttribute("title", "会员订单");
		return SUCCESS;
	}
	/**
	 * 保存数据
	 * @return
	 */
	public String saveOrUpdate() {
		logger.debug("enter saveOrUpdate");
		if (userOrder == null) {
			userOrder = new UserOrder();
		}
		if (userOrder.getId() == null) {
			try {
				userOrderService.insert(userOrder);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}else {
			try {
			    User user	= getCurrUserInfo();
			    if (user != null){
			    	userOrder.setSend_user_id(String.valueOf(user.getId()));
			    }
				userOrderService.update(userOrder);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}
	}

	/**
	 * 删除数据
	 * 
	 * @return
	 */
	public String delete() {
		logger.debug("enter delete");
		boolean result = true;
		String id = request.getParameter("ids");

		try {
			userOrderService.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		logger.debug("exit delete");

		return result(result);
	}
	public UserOrder getUserOrder() {
		return userOrder;
	}
	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}
	public List<Dictionary> getOrderStrutsList() {
		return orderStrutsList;
	}
	public void setOrderStrutsList(List<Dictionary> orderStrutsList) {
		this.orderStrutsList = orderStrutsList;
	}
	
	
	
}

package com.irandoo.xhep.base.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.Device;
import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.model.Meal;
import com.irandoo.xhep.base.model.RechargeRecord;
import com.irandoo.xhep.base.service.DeviceService;
import com.irandoo.xhep.base.service.RechargeRecordService;
import com.irandoo.xhep.sys.service.DictionaryService;

@Controller("rechargeRecordAction")
@Scope("prototype")
public class RechargeRecordAction extends BaseAction{

	private static final long serialVersionUID = -1342801866160866958L;
	private Log logger = LogFactory.getLog(RechargeRecordAction.class);
	@Autowired
	private RechargeRecordService rechargeRecordService;
	
	private RechargeRecord rechargeRecord;

	@Autowired
	private DictionaryService dictionaryService;
	
	private List<Dictionary> payStyleList;
	
	private List<Dictionary> payTypeList;
	
	private List<Meal> mealList;
	/**
	 * 加载数据
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = rechargeRecordService.getInfoListStr(getConditionMap());
	    return toJsonData(jsonData);
	}

	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String toLoadList() {
		payStyleList = dictionaryService.getByDescript("充值流水类型");
		payTypeList = dictionaryService.getByDescript("支付方式");
		mealList = rechargeRecordService.selMeal();
		request.setAttribute("title", "设备");
		return SUCCESS;
	}
	public RechargeRecord getRechargeRecord() {
		return rechargeRecord;
	}

	public void setRechargeRecord(RechargeRecord rechargeRecord) {
		this.rechargeRecord = rechargeRecord;
	}

	public List<Dictionary> getPayStyleList() {
		return payStyleList;
	}

	public void setPayStyleList(List<Dictionary> payStyleList) {
		this.payStyleList = payStyleList;
	}

	public List<Dictionary> getPayTypeList() {
		return payTypeList;
	}

	public void setPayTypeList(List<Dictionary> payTypeList) {
		this.payTypeList = payTypeList;
	}

	public List<Meal> getMealList() {
		return mealList;
	}

	public void setMealList(List<Meal> mealList) {
		this.mealList = mealList;
	}



}

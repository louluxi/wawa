package com.irandoo.xhep.base.service;

import java.util.List;

import com.irandoo.xhep.base.model.Meal;
import com.irandoo.xhep.base.model.RechargeRecord;

public interface RechargeRecordService extends BaseService<RechargeRecord>{

	/**
	 * 查询套餐
	 * @return
	 */
	List<Meal> selMeal ();
}

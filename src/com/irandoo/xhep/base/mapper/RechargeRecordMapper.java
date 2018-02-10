package com.irandoo.xhep.base.mapper;

import java.util.List;

import com.irandoo.xhep.base.model.Meal;

public interface RechargeRecordMapper extends BaseMapper{

	/**
	 * 查询套餐
	 * @return
	 */
	List<Meal> selMeal ();
}

package com.irandoo.xhep.base.service;

import java.util.List;

import com.irandoo.xhep.base.model.Meal;


public interface MealService extends BaseService<Meal>{

	/**
	    * 根据套餐id查询出套餐的详细信息
	    * @param id
	    * @return
	    */
		Meal getInfoByMealId (Long id);
		
}

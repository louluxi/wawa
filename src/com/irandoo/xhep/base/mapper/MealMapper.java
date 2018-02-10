package com.irandoo.xhep.base.mapper;




import com.irandoo.xhep.base.model.Meal;

public interface MealMapper  extends BaseMapper{
   /**
    * 根据套餐id查询出套餐的详细信息
    * @param id
    * @return
    */
	Meal getInfoByMealId (Long id);
	
}

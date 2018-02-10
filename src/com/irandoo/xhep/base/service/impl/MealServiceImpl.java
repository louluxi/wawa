package com.irandoo.xhep.base.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.upm.comm.entity.User;
import com.irandoo.xhep.base.mapper.MealMapper;
import com.irandoo.xhep.base.model.Meal;
import com.irandoo.xhep.base.service.MealService;

@Service("mealService")
public class MealServiceImpl extends BaseServiceImpl<Meal> implements MealService{
	
	@Autowired
	private MealMapper mealMapper;
	
	@Resource
	public void setSuperBaseMapper(MealMapper mealMapper) {
		// TODO Auto-generated method stub
		super.setBaseMapper(mealMapper);
		this.mealMapper = mealMapper;
	}

	@Override
	public Meal getInfoByMealId(Long id) {
		// TODO Auto-generated method stub
		return mealMapper.getInfoByMealId(id);
	}

	

}

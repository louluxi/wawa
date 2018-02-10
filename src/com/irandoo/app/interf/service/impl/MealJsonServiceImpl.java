package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.MealJson;
import com.irandoo.app.interf.mapper.MealJsonMapper;
import com.irandoo.app.interf.service.MealJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午5:38:33
  */
@Service("mealJsonService")
public class MealJsonServiceImpl extends BaseServiceImpl<MealJson> implements MealJsonService {
	
    @SuppressWarnings("unused")
	@Autowired
	private MealJsonMapper mealJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(MealJsonMapper mealJsonMapper) {
		super.setBaseMapper(mealJsonMapper);
		this.mealJsonMapper = mealJsonMapper;
	}
}

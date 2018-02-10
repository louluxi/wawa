package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.CarouselJson;
import com.irandoo.app.interf.mapper.CarouselJsonMapper;
import com.irandoo.app.interf.service.CarouselJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;



/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午11:13:13
  */
@Service("carouselJsonService")
public class CarouselJsonServiceImpl extends BaseServiceImpl<CarouselJson> implements CarouselJsonService {
	
    @SuppressWarnings("unused")
	@Autowired
	private CarouselJsonMapper carouselJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(CarouselJsonMapper carouselJsonMapper) {
		super.setBaseMapper(carouselJsonMapper);
		this.carouselJsonMapper = carouselJsonMapper;
	}
}

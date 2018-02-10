package com.irandoo.xhep.base.service.impl;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.CarouselMapper;
import com.irandoo.xhep.base.model.Carousel;
import com.irandoo.xhep.base.service.CarouselService;

@Service("carouselService")
public class CarouselServiceImpl extends BaseServiceImpl<Carousel> implements CarouselService {
    @Autowired
	private CarouselMapper carouselMapper;
    
    @Resource
    public void setSuperBaseMapper(CarouselMapper carouselMapper) {
		super.setBaseMapper(carouselMapper);
		this.carouselMapper = carouselMapper;
	}
}

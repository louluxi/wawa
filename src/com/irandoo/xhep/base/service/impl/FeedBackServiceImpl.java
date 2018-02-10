package com.irandoo.xhep.base.service.impl;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.irandoo.xhep.base.mapper.FeedBackMapper;
import com.irandoo.xhep.base.model.FeedBack;
import com.irandoo.xhep.base.service.FeedBackService;

@Service("feedBackService")
public class FeedBackServiceImpl extends BaseServiceImpl<FeedBack> implements FeedBackService {
    @Autowired
	private FeedBackMapper feedBackMapper; 
    
    @Resource
    public void setSuperBaseMapper(FeedBackMapper feedBackMapper) {
		super.setBaseMapper(feedBackMapper);
		this.feedBackMapper = feedBackMapper;
	}
}

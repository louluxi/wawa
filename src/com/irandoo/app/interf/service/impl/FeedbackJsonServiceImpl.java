package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.FeedbackJson;
import com.irandoo.app.interf.mapper.FeedbackJsonMapper;
import com.irandoo.app.interf.service.FeedbackJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午5:38:33
  */
@Service("feedbackJsonService")
public class FeedbackJsonServiceImpl extends BaseServiceImpl<FeedbackJson> implements FeedbackJsonService {
	
    @SuppressWarnings("unused")
	@Autowired
	private FeedbackJsonMapper feedbackJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(FeedbackJsonMapper feedbackJsonMapper) {
		super.setBaseMapper(feedbackJsonMapper);
		this.feedbackJsonMapper = feedbackJsonMapper;
	}
}

package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.MerchJson;
import com.irandoo.app.interf.mapper.MerchJsonMapper;
import com.irandoo.app.interf.service.MerchJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午5:38:33
  */
@Service("merchJsonService")
public class MerchJsonServiceImpl extends BaseServiceImpl<MerchJson> implements MerchJsonService {
	
    @SuppressWarnings("unused")
	@Autowired
	private MerchJsonMapper merchJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(MerchJsonMapper merchJsonMapper) {
		super.setBaseMapper(merchJsonMapper);
		this.merchJsonMapper = merchJsonMapper;
	}
}

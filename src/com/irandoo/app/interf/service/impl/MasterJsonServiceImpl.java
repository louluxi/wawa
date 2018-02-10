package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.MasterJson;
import com.irandoo.app.interf.mapper.MasterJsonMapper;
import com.irandoo.app.interf.service.MasterJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午5:38:33
  */
@Service("masterJsonService")
public class MasterJsonServiceImpl extends BaseServiceImpl<MasterJson> implements MasterJsonService {
	
    @SuppressWarnings("unused")
	@Autowired
	private MasterJsonMapper masterJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(MasterJsonMapper masterJsonMapper) {
		super.setBaseMapper(masterJsonMapper);
		this.masterJsonMapper = masterJsonMapper;
	}
}

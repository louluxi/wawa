package com.irandoo.app.interf.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.app.interf.json.RechargeRecordJson;
import com.irandoo.app.interf.mapper.RechargeRecordJsonMapper;
import com.irandoo.app.interf.service.RechargeRecordJsonService;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8下午5:38:33
  */
@Service("rechargeRecordJsonService")
public class RechargeRecordJsonServiceImpl extends BaseServiceImpl<RechargeRecordJson> implements RechargeRecordJsonService {
	
    @SuppressWarnings("unused")
	@Autowired
	private RechargeRecordJsonMapper rechargeRecordJsonMapper;
    
    @Resource
    public void setSuperBaseMapper(RechargeRecordJsonMapper rechargeRecordJsonMapper) {
		super.setBaseMapper(rechargeRecordJsonMapper);
		this.rechargeRecordJsonMapper = rechargeRecordJsonMapper;
	}
}

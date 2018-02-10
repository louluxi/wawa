package com.irandoo.xhep.base.service.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.irandoo.xhep.base.mapper.RechargeChannelMapper;
import com.irandoo.xhep.base.model.RechargeChannel;
import com.irandoo.xhep.base.service.RechargeChannelService;
@Service("rechargeChannelService")
public class RechargeChannelServiceImpl extends BaseServiceImpl<RechargeChannel> implements RechargeChannelService {
    
	@Autowired
	private RechargeChannelMapper rechargeChannelMapper;
   
	@Resource
	public void setSuperBaseMapper(RechargeChannelMapper rechargeChannelMapper) {
		// TODO Auto-generated method stub
		super.setBaseMapper(rechargeChannelMapper);
		this.rechargeChannelMapper = rechargeChannelMapper;
	}
	
}

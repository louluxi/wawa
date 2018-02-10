package com.irandoo.xhep.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.RechargeRecordMapper;
import com.irandoo.xhep.base.model.Meal;
import com.irandoo.xhep.base.model.RechargeRecord;
import com.irandoo.xhep.base.service.RechargeRecordService;
@Service("rechargeRecordService")
public class RechargeRecordServiceImp extends BaseServiceImpl<RechargeRecord> implements RechargeRecordService{

	@Autowired
	private RechargeRecordMapper rechargeRecordMapper;
	
	@Resource
	public void setSuperBaseMapper(RechargeRecordMapper rechargeRecordMapper) {
		// TODO Auto-generated method stub
		super.setBaseMapper(rechargeRecordMapper);
		this.rechargeRecordMapper = rechargeRecordMapper;
	}

	@Override
	public List<Meal> selMeal() {
		// TODO Auto-generated method stub
		return rechargeRecordMapper.selMeal();
	}
}

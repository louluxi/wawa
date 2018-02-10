package com.irandoo.xhep.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.HisUserMapper;
import com.irandoo.xhep.base.model.HisUser;
import com.irandoo.xhep.base.service.HisUserService;
@Service("hisUserService")
public class HisUserServiceImpl extends BaseServiceImpl<HisUser> implements HisUserService{

	
	@Autowired
	private HisUserMapper hisUserMapper;
	
	@Resource
	public void setSuperBaseMapper(HisUserMapper hisUserMapper) {
		super.setBaseMapper(hisUserMapper);
		this.hisUserMapper = hisUserMapper;
	}
	
	@Override
	public int insertHisList(List<HisUser> list) {
		
		return hisUserMapper.insertHisList(list);
	}

}

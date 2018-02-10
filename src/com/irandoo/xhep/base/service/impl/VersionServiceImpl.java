package com.irandoo.xhep.base.service.impl;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.irandoo.xhep.base.mapper.VersionMapper;
import com.irandoo.xhep.base.model.Version;
import com.irandoo.xhep.base.service.VersionService;
@Service("versionService")
public class VersionServiceImpl extends BaseServiceImpl<Version> implements VersionService {

	@Autowired
	private VersionMapper versionMapper;
	

	@Resource
	public void setSuperBaseMapper(VersionMapper versionMapper){
	     super.setBaseMapper(versionMapper);
	     this.versionMapper = versionMapper;
	}

}

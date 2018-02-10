package com.irandoo.xhep.base.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.ResourceTypeMapper;
import com.irandoo.xhep.base.model.ResourceType;
import com.irandoo.xhep.base.service.ResourceTypeService;

/**
 * @author ager

 * @version : 1.0
 *
 */
@Service("resourceTypeService")
public class ResourceTypeServiceImpl extends BaseServiceImpl<ResourceType> implements  ResourceTypeService {
	
	@SuppressWarnings("unused")
	@Autowired
	private ResourceTypeMapper resourceTypeMapper;
	
	@Resource
	public void setSuperBaseMapper(ResourceTypeMapper resourceTypeMapper){
	     super.setBaseMapper(resourceTypeMapper);
	     this.resourceTypeMapper = resourceTypeMapper;
	}
}

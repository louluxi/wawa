package com.irandoo.xhep.sys.mapper;

import java.util.List;
import java.util.Map;

import com.irandoo.xhep.base.mapper.BaseMapper;
import com.irandoo.xhep.base.model.ZNodesEntity;

public interface MenuMapper extends BaseMapper {
	List<ZNodesEntity> getZNodesData(Map<String,Object> map);
}

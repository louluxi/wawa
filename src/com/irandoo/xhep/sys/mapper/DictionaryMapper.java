package com.irandoo.xhep.sys.mapper;

import java.util.List;
import java.util.Map;

import com.irandoo.xhep.base.mapper.BaseMapper;
import com.irandoo.xhep.base.model.Dictionary;

public interface DictionaryMapper extends BaseMapper {
	List<Dictionary> getInfoByDescript(Map<String,Object> map);
	
	List<Dictionary> getInfoByDescriptAndDictName(Map<String,Object> map);

}

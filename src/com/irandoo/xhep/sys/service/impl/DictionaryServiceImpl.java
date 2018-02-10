package com.irandoo.xhep.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.service.impl.BaseServiceImpl;
import com.irandoo.xhep.sys.mapper.DictionaryMapper;
import com.irandoo.xhep.sys.service.DictionaryService;

@Service("dictionaryService")
public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary> implements DictionaryService {
	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	@Resource
	public void setSuperBaseMapper(DictionaryMapper dictionaryMapper){
	     super.setBaseMapper(dictionaryMapper);
	     this.dictionaryMapper = dictionaryMapper;
	}
	

	@Override
	@Transactional
    public void deleteOne(long id) {
    	Dictionary dictionary = dictionaryMapper.getInfoById(id);
        dictionaryMapper.delete(id);
    	dictionaryMapper.update(dictionary);
    }
	
	@Override
    public List<Dictionary> getByDescript(String descript) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("descript", descript);
    	return dictionaryMapper.getInfoByDescript(map);
    }
	
	@Override
    public List<Dictionary> getByDescriptAndDictName(String descript,String dictName) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("descript", descript);
		map.put("dictName", dictName);
    	return dictionaryMapper.getInfoByDescriptAndDictName(map);
    }
}

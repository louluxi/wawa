package com.irandoo.xhep.sys.service;

import java.util.List;

import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.service.BaseService;


public interface DictionaryService extends BaseService<Dictionary> {

	void deleteOne(long id);

	List<Dictionary> getByDescript(String descript);

	List<Dictionary> getByDescriptAndDictName(String descript, String dictName);

}

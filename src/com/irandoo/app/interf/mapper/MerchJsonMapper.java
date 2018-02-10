package com.irandoo.app.interf.mapper;

import java.util.Map;

import com.irandoo.app.interf.json.MerchJson;
import com.irandoo.xhep.base.mapper.BaseMapper;

/**
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午11:12:43
  */
public interface MerchJsonMapper extends BaseMapper {
	MerchJson getExchangeCoin(Map<String,Object> map);

}

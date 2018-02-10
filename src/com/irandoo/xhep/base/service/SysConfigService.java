package com.irandoo.xhep.base.service;

import com.irandoo.xhep.base.model.SysConfig;

/**
 * @author ager

 * @date:2015-8-12 下午1:53:07
 * @version : 1.0
 *
 */
public interface SysConfigService extends BaseService<SysConfig> {

	String getValueByTypeName(String param_type, String param_name);

	void setValueByTypeName(String param_value, String param_type,
			String param_name);

	String getValue(String param_cat, String param_type, String param_name);

}

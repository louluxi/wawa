package com.irandoo.xhep.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.base.mapper.SysConfigMapper;
import com.irandoo.xhep.base.model.SysConfig;
import com.irandoo.xhep.base.service.SysConfigService;

/**
 * @author ager

 * @date:2015-8-12 下午2:16:52
 * @version : 1.0
 *
 */
@Service("sysConfigService")
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfig> implements SysConfigService {
	
	@Autowired
	private SysConfigMapper sysConfigMapper;
	
	@Resource
	public void setSuperBaseMapper(SysConfigMapper sysConfigMapper){
	     super.setBaseMapper(sysConfigMapper);
	     this.sysConfigMapper = sysConfigMapper;
	}
	
	@Override
	public String getValueByTypeName(String param_type, String param_name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("param_type", param_type);
		map.put("param_name", param_name);
		List<SysConfig> configList = sysConfigMapper.getAllList(map);
		if(configList.size()>0){
			return configList.get(0).getParam_value();
		}else{
			return null;
		}
	}
	
	@Override
	public String getValue(String param_cat, String param_type, String param_name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("param_cat", param_cat);
		map.put("param_type", param_type);
		map.put("param_name", param_name);
		List<SysConfig> configList = sysConfigMapper.getAllList(map);
		if(configList.size()>0){
			return configList.get(0).getParam_value();
		}else{
			return null;
		}
	}
	
	@Override
	public void setValueByTypeName(String param_value, String param_type, String param_name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("param_type", param_type);
		map.put("param_name", param_name);
		List<SysConfig> configList = sysConfigMapper.getAllList(map);
		if(configList.size()>0){
			SysConfig sysConfig = configList.get(0);
			sysConfig.setParam_value(param_value);
			sysConfigMapper.update(sysConfig);
		}else{
			SysConfig sysConfig = new SysConfig();
			sysConfig.setParam_type(param_type);
			sysConfig.setParam_name(param_name);
			sysConfig.setParam_value(param_value);
			sysConfig.setParam_desc("系统自动新增");
			sysConfigMapper.insert(sysConfig);
		}
	}
}

package com.irandoo.xhep.base.service;

import java.util.List;

import com.irandoo.xhep.base.model.HisUser;

public interface HisUserService extends BaseService<HisUser>{
	/**
     * 批量添加历史在线人员
     * @param hisUsers 需要添加的集合
     * @return
     */
	int insertHisList(List<HisUser> list);
}

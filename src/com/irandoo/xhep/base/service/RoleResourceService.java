package com.irandoo.xhep.base.service;

import com.irandoo.xhep.base.model.RoleResource;

/**
 * @author ager

 * @date:2015-8-12 下午1:53:07
 * @version : 1.0
 *
 */
public interface RoleResourceService extends BaseService<RoleResource> {
     void deleteByRoleId(long id);
}

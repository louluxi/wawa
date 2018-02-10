package com.irandoo.xhep.sys.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.xhep.base.action.BaseAction;
import com.irandoo.xhep.base.model.Role;
import com.irandoo.xhep.base.model.RoleResource;
import com.irandoo.xhep.base.model.ZNodesEntity;
import com.irandoo.xhep.base.service.RoleResourceService;
import com.irandoo.xhep.sys.service.MenuService;
import com.irandoo.xhep.sys.service.RoleService;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction {
	
	private static final long serialVersionUID = -1350801866160866958L;
	private Log logger = LogFactory.getLog(RoleAction.class);
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleResourceService roleResourceService;
	private Role role;
	
	/**
     * 跳转
     * @return
     */
    public String toLoadList() {
        request.setAttribute("title", "角色");
        return SUCCESS;
    }
    

    /**
     * 加载数据
     * @return
     */
    public String getAjaxData() {
    	String jsonData = roleService.getInfoListStr(getConditionMap());
    	return toJsonData(jsonData);
    }
    
    /**
     * 保存数据
     * @return
     */
    public String saveOrUpdate() {
        logger.debug("enter saveOrUpdate");
      
        if(role == null) {
        	role = new Role();
        }
        if(role.getId() == null) {
        	try {
        		roleService.insert(role);
        	}
        	catch(Exception e) {
            	e.printStackTrace();
        	}
        }else {
        	try {
        		roleService.update(role);
        	}
        	catch(Exception e) {
            	e.printStackTrace();
        	}
        }
        String resourceIds = role.getResourceIds();
		if(null != resourceIds && !"".equals(resourceIds)&& !"null".equals(resourceIds)){
			roleResourceService.deleteByRoleId(role.getId());
			String[] roleResourceArr = resourceIds.split(",");
			for(String resourceId:roleResourceArr){
				if("".equals(resourceId)){
					continue;
				}
				RoleResource roleResource = new RoleResource();
				roleResource.setResource_id(Long.valueOf(resourceId.trim()));
				roleResource.setRole_id(role.getId());
				roleResourceService.insert(roleResource);
			}
		}
        logger.debug("exit saveOrUpdate");
        return SUCCESS;
        
    }
    

    /**
     * 查看数据
     * @return
     */
    public String getInfoById() {
        logger.debug("enter getInfoById");
        String id = request.getParameter("id");
        String opt = request.getParameter("opt");
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isEmpty(opt)){
            return ERROR;
        }
        //新增页面
        if(ADD.equals(opt)){
        	role = new Role();
        	request.setAttribute("title", "角色新增");
        }
        //修改页面
        else if(UPDATE.equals(opt)){
        	map.put("roleId", id);
        	role = roleService.getInfoById(Long.parseLong(id));
        	request.setAttribute("title", "角色修改");
        }else{
        	request.setAttribute("title", "角色新增");
        }
        List<ZNodesEntity> znodesList = menuService.getZNodesData(map);
        String json = "";
		try {
			json = JSON.toJSONString(znodesList);
			request.setAttribute("json", json);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return SUCCESS;
    }
    
    /**
     * 删除数据
     * @return
     */
    public String delete() {
        logger.debug("enter delete");
        boolean result = true;
        String id = request.getParameter("ids");

        try {
        	roleResourceService.deleteByRoleId(Long.valueOf(id));
        	roleService.deleteOne(Long.valueOf(id));
        }
        catch (Exception e) {
        	e.printStackTrace();
            result = false;
        }

        logger.debug("exit delete");

        return result(result);
    }


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
    
    
}

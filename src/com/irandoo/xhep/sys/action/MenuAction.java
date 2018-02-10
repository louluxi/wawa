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

import com.irandoo.xhep.base.action.BaseAction;
import com.irandoo.xhep.base.model.Menu;
import com.irandoo.xhep.base.model.ResourceType;
import com.irandoo.xhep.base.service.ResourceTypeService;
import com.irandoo.xhep.sys.service.MenuService;

@Controller("menuAction")
@Scope("prototype")
public class MenuAction extends BaseAction {
	
	private static final long serialVersionUID = -1350801866160866958L;
	private Log logger = LogFactory.getLog(MenuAction.class);
	@Autowired
	private MenuService menuService;
	@Autowired
	private ResourceTypeService resourceTypeService;
	private Menu menu;
	private List<ResourceType> resourceTypeList;
	/**
     * 跳转
     * @return
     */
    public String toLoadList() {
        request.setAttribute("title", "菜单");
        return SUCCESS;
    }
    

    public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	/**
     * 加载数据
     * @return
     */
    public String getAjaxData() {
		 String jsonData = menuService.getInfoListStr(getConditionMap());
		 return toJsonData(jsonData);
    }
    
    /**
     * 保存数据
     * @return
     */
    public String saveOrUpdate() {
        logger.debug("enter saveOrUpdate");
      
        if(menu == null) {
        	menu = new Menu();
        }
        if(menu.getId() == null) {
        	try {
        		menuService.insert(menu);
        	}
        	catch(Exception e) {
            	e.printStackTrace();
        	}
        }else {
        	try {
        		menuService.update(menu);
        	}
        	catch(Exception e) {
            	e.printStackTrace();
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
        if(StringUtils.isEmpty(opt)){
            return ERROR;
        }
        Map<String,Object> map = new HashMap<String,Object>();
        resourceTypeList = resourceTypeService.getAllList(map);
        //新增页面
        if(ADD.equals(opt)){
        	menu = new Menu();
        	request.setAttribute("title", "菜单新增");
        }
        //修改页面
        else if(UPDATE.equals(opt)){
        	menu = menuService.getInfoById(Long.parseLong(id));
        	request.setAttribute("title", "菜单修改");
        }
        //添加下级
        else if(VIEW.equals(opt)){
        	menu = new Menu();
        	String level = request.getParameter("level");
        	menu.setParent_id(Long.parseLong(id));
        	menu.setLevel(Integer.valueOf(level)+1);
        	request.setAttribute("title", "菜单新增");
        }
        else{
        	request.setAttribute("title", "菜单新增");
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
        	menuService.deleteByOne(Long.valueOf(id));
        }
        catch (Exception e) {
        	e.printStackTrace();
            result = false;
        }

        logger.debug("exit delete");

        return result(result);
    }


	public List<ResourceType> getResourceTypeList() {
		return resourceTypeList;
	}


	public void setResourceTypeList(List<ResourceType> resourceTypeList) {
		this.resourceTypeList = resourceTypeList;
	}
}

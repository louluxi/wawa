package com.irandoo.xhep.base.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.xhep.base.model.Menu;
import com.irandoo.xhep.base.model.User;
import com.irandoo.xhep.base.service.SysConfigService;
import com.irandoo.xhep.base.service.UserService;
import com.irandoo.xhep.base.util.CookieUtils;
import com.irandoo.xhep.base.util.Lunar;
import com.irandoo.xhep.sys.service.MenuService;

/**
 * 整体框架控制类
 * @author ager
 * @version 1.0 
 */
@Controller("index")
@Scope("prototype")
public class IndexAction extends BaseAction
{
    private static final long serialVersionUID = 937985788654525018L;
    
    private Log logger = LogFactory.getLog(IndexAction.class);
    @Autowired
	private UserService userService;
    @Autowired
  	private SysConfigService sysConfigService;
    @Autowired
   	private MenuService menuService;
    public void login()
    {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String res = "1";
        User user = new User();
        HttpSession session = request.getSession(false);
        if(session!=null){
           session.invalidate();
        }
        try
        {
            user = userService.login(username, password,true);
            if(user == null){
            	 res = "2";
            }
        }
        catch (Exception e)
        {
            res = "3";
            e.printStackTrace();
        }
        try
        {
            //登录成功
            if("1".equals(res)){
                request.getSession().setAttribute("user", user);
                Cookie cookie = CookieUtils.addCookie(user,true);
                response.addCookie(cookie);
            }
            response.getWriter().println("{\"res\":" + res + "}");
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);
            
        }
    }
    
    public String checkPass()
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean flag = true;
        try
        {
           userService.login(username, password,true);
            
        }
        catch (Exception e)
        {
            flag = false;
        }
            
        try
        {

            response.getWriter().println(flag); 
        }
        catch (Exception e)
        {
            logger.error("getResponse().getWriter().println error.", e);
        }
        
        return null;
            
    }
    
    public String loginOut()
    {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("aclMap");
        request.getSession().invalidate();
        Cookie cookie = CookieUtils.delCookie(request);  
        if (cookie != null) {
            response.addCookie(cookie);  
        }
            
        return success();
    }
    
    public String setTotalCount(){
    	String count = sysConfigService.getValueByTypeName("TOTALCOUNT", "TOTALCOUNT");
    	int c = Integer.valueOf(count)+1;
    	sysConfigService.setValueByTypeName(c+"", "TOTALCOUNT", "TOTALCOUNT");
    	String json = "";
		try {
			json = JSON.toJSONString(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toJsonData(json);
    }
    
    public String toLogin()
    {
        if(null != request.getSession().getAttribute("user")){
            return "index";
        }
//        if(CookieUtils.getCookie(request,userService)){
//            return "autologin";
//        }
        return SUCCESS;
    }
    public String index()
    {
//        User user = getCurrUserInfo();
//        if (user != null)
//        {
//        	Map<String, Object> map = new HashMap<String, Object>();
//        	map.put("userId", user.getId());
//        	map.put("resource_type_id", "1,2");
//        	map.put("level", 1);
//        	menuList = menuService.getAllList(map);
//        	for(Menu menu: menuList){
//        		map.put("level", 2);
//        		map.put("parent_id", menu.getId());
//        		List<Menu> childrenList = menuService.getAllList(map);
//        		menu.setChildrenList(childrenList);
//        	}
//        }
        return SUCCESS;
    }
    private List<Menu> menuList;
    public String getMenus(){
    	User user = getCurrUserInfo();
        if (user != null)
        {
        	Map<String, Object> map = new HashMap<String, Object>();
        	map.put("userId", user.getId());
        	map.put("resource_type_id", "1,2");
        	map.put("level", 1);
        	menuList = menuService.getAllList(map);
        	for(Menu menu: menuList){
        		map.put("level", 2);
        		map.put("parent_id", menu.getId());
        		List<Menu> childrenList = menuService.getAllList(map);
        		menu.setChildrenList(childrenList);
        	}
        }
        return SUCCESS;

    }
    public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String welcome()
    {
        //response.setHeader("Cache-Control", "no-cache");
        //Map<Integer, RoleResource> map = (Map<Integer, RoleResource>)request.getSession().getAttribute("aclMap");
        // 农历日期
        Lunar l = new Lunar(System.currentTimeMillis());
        request.setAttribute("day", "星期" + Lunar.ss[l.getDayOfWeek() - 1]);
        request.setAttribute("nl", l.getLunarDateString());
        return SUCCESS;
    }
}

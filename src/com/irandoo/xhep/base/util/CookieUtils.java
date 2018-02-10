package com.irandoo.xhep.base.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.huawei.bme.commons.encryption.EncryptTool;
import com.irandoo.xhep.base.model.User;
import com.irandoo.xhep.base.service.UserService;

/**
 * 
 * @author tdy
 *
 */
public class CookieUtils {
    public static final String USER_COOKIE = "freeman.cookie.data";

    private static EncryptTool eTool = new EncryptTool();
    // 添加一个cookie
    public static Cookie addCookie(User user,boolean rem) {
        //再加密
        String uname=null,pass=null;
        try {
            uname = "admin";
            pass = "admin123";
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Cookie cookie = new Cookie(USER_COOKIE, uname + "," + pass+","+rem);
        //设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24 * 14);// cookie 14天
        return cookie;
    }


    // 得到cookie
    public static boolean  getCookie(HttpServletRequest request,UserService userService) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (CookieUtils.USER_COOKIE.equals(cookie.getName())) {
                    String value = cookie.getValue();
                    if (StringUtils.isNotBlank(value)) {
                        String [] arr = value.split("\\,");
                        if(null!=arr && arr.length==3){
                            String uname = null,pass = null;
                            try {
                                uname = eTool.parseEncrypt(arr[0]);
                                pass = eTool.parseEncrypt(arr[1]);
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                            User user = null;
                            try {
                                user = userService.login(uname, pass,false);
                            }
                            catch (Exception e) {
                                return false;
                            }
                            if(null != user){
                                request.getSession().setAttribute("user", user);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
 
    public static User getCookieUname(HttpServletRequest request,UserService userService) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (CookieUtils.USER_COOKIE.equals(cookie.getName())) {
                    String value = cookie.getValue();
                    if (StringUtils.isNotBlank(value)) {
                        String [] arr = value.split("\\,");
                        if(null!=arr && arr.length==3){
                            String uname = null,pass = null;
                            try {
                                uname = eTool.parseEncrypt(arr[0]);
                                pass = eTool.parseEncrypt(arr[1]);
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                            User user = userService.login(uname, pass,false);
                            return user;
                        }
                    }
                }
            }
        }
        return null;
    }


    // 删除cookie
    public static Cookie delCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (USER_COOKIE.equals(cookie.getName())) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    return cookie;
                }
            }
        }
        return null;
    }
}

package com.irandoo.xhep.base.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.irandoo.xhep.base.model.User;

/**
 * @author ager
 * @version 1.0 
 */
public class SecurityFilter implements Filter {

    /**
     * 
     */
    private String[] excludeActions;

    /**
     * 
     */
    private String[] excludePath;

    /**
     * 
     */
    private String[] filterType;


    @Override
    public void destroy() {

    }


    private int getCharCount(String str) {

        int count = 0;

        if (StringUtils.isBlank(str)) {
            return count;
        }
        else {
            int len = str.length();
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == '/') {
                    count++;
                }

            }
        }
        return count;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String contextPath = httpRequest.getContextPath();
        String requestURI = httpRequest.getRequestURI().substring(contextPath.length());
        //String sss =  httpRequest.getRequestURL().toString();
        boolean isFilter = false;
        for (String filterTypeStr : filterType) {
            if (requestURI.endsWith(filterTypeStr)) {
                isFilter = true;
                break;
            }

        }

        if (!isFilter) {
            filterChain.doFilter(request, response);
            return;
        }

        for (String excludePathStr : excludePath) {
            if (requestURI.startsWith(excludePathStr)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        //单层 路径"/"的action放行，前台使用的
        if (requestURI.endsWith(".action")||"/index.jsp".equals(requestURI)||"/page/base/register.jsp".equals(requestURI)) {
            if (1 == getCharCount(requestURI)||"/registerInfo/saveData.action".equals(requestURI)||"/sysadmin/login.action".equals(requestURI)||"/page/base/register.jsp".equals(requestURI)||"/index.jsp".equals(requestURI)||"/sysadmin/timeOut.action".equals(requestURI)) {
                filterChain.doFilter(request, response);
                return;
            }
        }
        for (String excludeAction : excludeActions) {
            if (requestURI.startsWith(excludeAction)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        User user = (User) httpRequest.getSession().getAttribute("user");

        if (null == user) {
            httpResponse.sendRedirect(contextPath + "/index.jsp");
    	    filterChain.doFilter(request, response);
            return;
        }
        filterChain.doFilter(request, response);

    }


    @Override
    public void init(FilterConfig config) throws ServletException {
    	//初始化启动时开启定时任务
    	//  new TimeTask();
        Enumeration<?> en = config.getInitParameterNames();
        String value = null;
        while (en.hasMoreElements()) {
            String property = (String) en.nextElement();
            value = (String) config.getInitParameter(property);
            if (property.equals("excludeActions")) {
                excludeActions = value.split("\\,");
                for (int i = 0; i < excludeActions.length; i++) {
                    excludeActions[i] =
                            excludeActions[i].substring(StringUtils.indexOf(excludeActions[i], '/'));
                }
            }
            if (property.equals("excludePath")) {
                excludePath = value.split("\\,");
                for (int i = 0, len = excludePath.length; i < len; i++) {
                    excludePath[i] = excludePath[i].substring(StringUtils.indexOf(excludePath[i], '/'));
                }

            }
            if (property.equals("filterType")) {
                filterType = value.split("\\,");
                for (int i = 0, len = filterType.length; i < len; i++) {
                    filterType[i] = filterType[i].substring(StringUtils.indexOf(filterType[i], '.') + 1);
                }
            }

        }

    }

}

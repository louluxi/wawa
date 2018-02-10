package com.irandoo.xhep.base.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.alibaba.fastjson.JSON;
import com.irandoo.xhep.anth.filter.JwtConstants;
import com.irandoo.xhep.base.model.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ager
 * @version 1.0
 * @date 2017-07-19
 */
public abstract class BaseAction extends ActionSupport implements
		ServletContextAware, ServletResponseAware, ServletRequestAware,
		SessionAware {

	private static final long serialVersionUID = 1L;

	protected static final String ADD = "1";

	protected static final String UPDATE = "2";

	protected static final String VIEW = "3";

	protected ServletContext servletContext;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession httpSession;

	protected Map<String, Object> session;

	private Log logger = LogFactory.getLog(BaseAction.class);

	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}

	/**
	 * 简单查询分页条件封装
	 * 
	 * @return
	 */
	protected Map<String, Object> getConditionMap() {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		String key = null;
		String value = null;
		int page = 1;
		int rows = 10;
		@SuppressWarnings("unchecked")
		Map<String, String[]> condition = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : condition.entrySet()) {
			key = entry.getKey();
			value = entry.getValue()[0];
			if ("page".equals(key)) {
				page = NumberUtils.toInt(value, page);
			} else if ("rows".equals(key)) {
				rows = NumberUtils.toInt(value, rows);
			} else {
				conditionMap.put(key, value);
			}
		}
		int offset = (page - 1) * rows;
		conditionMap.put("page", page);
		conditionMap.put("rows", rows);
		conditionMap.put("startset", offset);
		conditionMap.put("endset", rows);
		return conditionMap;
	}

	/**
	 * 简单查询分页条件封装
	 * 
	 * @return
	 */
	protected Map<String, Object> getInterfMap() {
		String userId = request.getAttribute(JwtConstants.REQUEST_KEY_USERNAME)+"";

		String o = request.getParameter("object");
		@SuppressWarnings("unchecked")
		Map<String,Object> paramMap = (Map<String,Object>)JSON.parse(o);
	
		if(null == paramMap.get("rows")||"".equals(paramMap.get("rows"))){
			paramMap.put("endset", 20);
		}else{
			paramMap.put("endset", Integer.parseInt(paramMap.get("rows")+""));
		}
		if(null == paramMap.get("page")||"".equals(paramMap.get("page"))){
			paramMap.put("startset", 0);
		}else{
			paramMap.put("startset",(Integer.parseInt(paramMap.get("page")+"") - 1)*Integer.parseInt(paramMap.get("rows")+""));
		}
		paramMap.put("userId", userId);
		return paramMap;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.httpSession = request.getSession();
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

//	protected User currentUser(HttpServletRequest request) {
//		return (User) request.getSession().getAttribute("user");
//	}

	/**
	 * 后台当前登录用户
	 * 
	 * @return
	 */
	protected User getCurrUserInfo() {
		User user = (User) request.getSession().getAttribute("user");
		return user;
	}

	protected String toJsonData(String jsonData) {
		try {
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(jsonData);
		} catch (IOException e) {
			logger.error("getResponse().getWriter().println error.", e);
		}

		return null;
	}

	protected String success() {
		try {
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("{\"success\":true}");
		} catch (IOException e) {
			logger.error("getResponse().getWriter().println error.", e);
		}

		return null;
	}

	protected String faild() {
		try {
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("{\"success\":false}");
		} catch (IOException e) {
			logger.error("getResponse().getWriter().println error.", e);
		}

		return null;
	}

	protected String result(boolean res) {
		return result(res, "success");
	}

	protected String result(boolean res, String mess) {
		try {
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(
					"{result:" + String.valueOf(res) + ",mess:'" + mess + "'}");
		} catch (IOException e) {
			logger.error("getResponse().getWriter().println error.", e);
		}

		return null;
	}

	protected String returnJson(Object list, String result, String errmsg) {
		String json = "";
        try {
            json = JSON.toJSONString(list);
        }
        catch (Exception e) {
        	result = "-3";
        	errmsg = e.getLocalizedMessage();
        }
		try {
			String resultJson = "{\"result\":\"" + result + "\", \"errmsg\":\"" + errmsg +"\", \"data\": " + json + "}";
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(resultJson);
		} catch (IOException e) {
			logger.error("getResponse().getWriter().println error.", e);
		}
		return null;
	}
	
	protected String result2(boolean res, String mess) {
		try {
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(
					"{\"result\":" + String.valueOf(res) + ",\"mess\":\""
							+ mess + "\"}");
		} catch (IOException e) {
			logger.error("getResponse().getWriter().println error.", e);
		}

		return null;
	}
	
	protected String resultString(String mess) {
		try {
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(mess);
		} catch (IOException e) {
			logger.error("getResponse().getWriter().println error.", e);
		}

		return null;
	}

	protected String getPath() {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		return basePath;
	}

	protected String getSavePath(String filepath) {
		String path = ServletActionContext.getServletContext().getRealPath(
				filepath);
		return path;
	}

	/**
	 * 生成随机数字和字母
	 * 
	 * @param length
	 * @return
	 */
	public String getStringRandom(int length) {
		String val = "";
		Random random = new Random();

		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	/**
	 * 返回图片
	 * @param list
	 * @param result
	 * @param errmsg
	 * @return
	 */
	protected String returnJson1(Object map, String errmsg) {
		String json = "";
        try {
            json = JSON.toJSONString(map);
        }
        catch (Exception e) {
        	
        	errmsg = e.getLocalizedMessage();
        }
		try {
			String resultJson = "{\"result\":\"" + json + "\", \"statusCode\":\"" + errmsg +"}";
			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(resultJson);
		} catch (IOException e) {
			logger.error("getResponse().getWriter().println error.", e);
		}
		return null;
	}
}

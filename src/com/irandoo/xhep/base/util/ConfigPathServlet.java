package com.irandoo.xhep.base.util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ConfigPathServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6953249181717506945L;
	private static String configPath; 
	@Override
	public void init(ServletConfig config) throws ServletException {
	super.init(config);
	setConfigPath(config.getInitParameter("configPath"));
	}
	public static String getConfigPath(){
	return ConfigPathServlet.configPath;
	}
	private static void setConfigPath(String configPath) {
	ConfigPathServlet.configPath = configPath;
	}
}

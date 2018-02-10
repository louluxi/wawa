package com.irandoo.xhep.base.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.conn123.wawadmin.webclient.Engine;
import com.irandoo.app.interf.util.GameCheckTimer;
import com.irandoo.app.interf.util.GameResultProcess;
import com.irandoo.app.interf.util.PropertiesUtil;
/**
  * 随tomcat启动运行，用于初始化游戏引擎以及启动定时监测游戏数据线程
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-30下午3:02:22
 */
public class StartOnLoadServlet extends HttpServlet {

	private static final long serialVersionUID = -8938747073897742383L;

	public void init() throws ServletException {
		// Put your code here
		String ip = PropertiesUtil.getDevProValByKey("IP") + "";
		String port = PropertiesUtil.getDevProValByKey("PORT") + "";
		new Engine(ip, Integer.parseInt(port));
		Engine.getWebClient().registerEvent(3, new GameResultProcess());
		Thread thread = new GameCheckTimer();
		thread.start();
	}

}

package com.irandoo.xhep.anth.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.irandoo.xhep.anth.service.JwtTokenService;
import com.irandoo.xhep.anth.util.JwtTokenUtil;
import com.irandoo.xhep.anth.util.LoadingAuthUtil;


import io.jsonwebtoken.ExpiredJwtException;
/**
 * 客户端token验证过滤器
 * @author sun
 *
 */
public class JwtTokenFilter extends OncePerRequestFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static final String ALLOW_ORIGIN = "*";
	public static final String ALLOW_HEADERS = "Authorization,Access-Control-Allow-Origin,app-v,interface-v,channel,os-v,device,app-idfa,userId,requestTime";
     
	@Autowired
	JwtTokenService jwtTokenService;

	/** token标示 */
    private static String Authorization = "authorization";
	/** 全局秘钥 */
	private String secret;

	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

		//加载配置文件
		Map<String, Object> maps =  LoadingAuthUtil.loading();
	    secret =	(String) maps.get("secret");
	    //获取token
		String token =  request.getHeader(Authorization);
		String result = null;
		try {
	          if(token != null && token.length()>0){
		   //开始解密token
				   String userId = JwtTokenUtil.getUseridStringFromToken(token, secret);
				   if(userId != null){
					   //设置userId
					   request.setAttribute(JwtConstants.REQUEST_KEY_USERNAME, userId);
					   //放行
					   chain.doFilter(request, response);
					   return;
				   }
	          }
			  request.setAttribute(JwtConstants.REQUEST_KEY_USERNAME, 160);
			 chain.doFilter(request, response);
			   return;
		} catch (ExpiredJwtException e) {
			    e.printStackTrace();
			    logger.info("token过期");
	          	//result = resultJsonUtil.resultObject("100", "token过期", "");
		} catch (Exception e) {
				e.printStackTrace();
				logger.info("token解析异常");
				//result = resultJsonUtil.resultObject("100","用户未登录", "");
		} 
		  response.setCharacterEncoding("UTF-8");
		  response.setContentType("text/json; charset=UTF-8");
		  response.getWriter().print(result);
		  response.getWriter().close();
   
    }

	/**
     * 非法请求处理
     * @param request
     * @param response
     * @throws IOException 
     */
	protected void invalidRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}

	
	
}
package com.irandoo.xhep.anth.filter;

public class JwtConstants {

	/** 请求头中获取用户名的Key */
	public static final String REQUEST_KEY_USERNAME = "userId";
	
	/** token类型为通过cas自动生成 */
	public static final String TOKEN_TYPE_CAS = "1";
	
	/** redis jwt 黑名单存储目录 */
	public static final String REDIS_JWT_BLACK_PRIFIX = "jwt_black:";
    public static final String REDIS_SHIRO_SESSION_KEY_PREFIX = "shiro_redis_session:";
    public static final String REDIS_SHIRO_CACHE_KEY_PREFIX = "shiro_redis_cache:";
	/** jwt存放的redis库 */
	public static final int REDIS_DB_INDEX = 13;
	
	/** 客户端id */
	public static String CLIENT_ID;
	/** 客户端秘钥 */
	public static String CLIENT_SECRET;
	/** 全局秘钥 */
	public static String SECRET;
	/** 有效时间，单位（秒） */
	public static Long EXPIRATION;
	/** Token请求头或cookie的名称 */
	public static String TOKEN_HEADER = "Authorization";
	
	public static final String ALLOW_ORIGIN = "*";
	public static final String ALLOW_HEADERS = "Authorization,Access-Control-Allow-Origin,app-v,interface-v,channel,os-v,device,app-idfa,userId,requestTime,mode,Content-Type";
	public static final String ALLOW_CREDENTIALS = "true";
	public static final String ALLOW_METHODS = "GET,POST,PUT,DELETE,PATCH,OPTIONS,HEAD,TRACE";

}

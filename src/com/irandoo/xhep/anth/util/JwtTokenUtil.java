package com.irandoo.xhep.anth.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;


import com.irandoo.xhep.anth.model.JwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**
 * jwt token帮助类
 * @author 尹日成
 *
 */
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;

    static final String CLAIM_KEY_USERID = "userid";
    static final String CLAIM_KEY_OPENID = "openid";
    static final String CLAIM_KEY_EXPIRES_IN = "expires_in";
    static final String CLAIM_KEY_ACCESS_TOKEN = "access_token";
    static final String CLAIM_KEY_REFRESH_TOKEN = "refresh_token";
    static final String CLAIM_KEY_SCOPE= "scope";

    /**
     * 从Token里面获取用户id
     * @param token 数据源Token
     * @param secret 密钥
     * @return userid
     */
    public static String getUseridStringFromToken(String token, String secret) {
        String userid;
        try {
            final Claims claims = getClaimsFromToken(token, secret);
            userid =  (String) claims.get(CLAIM_KEY_USERID);
        } catch (Exception e) {
        	userid = null;
        }
        return userid;
    }
    
    /**
     *  从Token里面获取openid
     * @param token 数据源Token
     * @param secret 密钥
     * @return openid
     */
    public static String getOpenidStringFromToken(String token, String secret) {
        String openid;
        try {
            final Claims claims = getClaimsFromToken(token, secret);
            openid =  (String) claims.get(CLAIM_KEY_OPENID);
        } catch (Exception e) {
        	openid = null;
        }
        return openid;
    }
	 /**
	  * 从Token里面获取过期时间 EXPIRES_IN
	  * @param token
	  * @param secret
	  * @return expires_in
	  */
    public static Date getExpires_inFromToken(String token, String secret) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token, secret);
            created = new Date((Long) claims.get(CLAIM_KEY_EXPIRES_IN));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }
    
    /**
     *  从Token里面获取access_token
     * @param token 数据源Token
     * @param secret 密钥
     * @return access_token
     */
    public static String getAccess_tokenStringFromToken(String token, String secret) {
        String access_token;
        try {
            final Claims claims = getClaimsFromToken(token, secret);
            access_token =  (String) claims.get(CLAIM_KEY_ACCESS_TOKEN);
        } catch (Exception e) {
        	access_token = null;
        }
        return access_token;
    }
    
    
    /**
     *  从Token里面获取scope
     * @param token 数据源Token
     * @param secret 密钥
     * @return scope
     */
    public String getScopeStringFromToken(String token, String secret) {
        String scope;
        try {
            final Claims claims = getClaimsFromToken(token, secret);
            scope =  (String) claims.get(CLAIM_KEY_SCOPE);
        } catch (Exception e) {
        	scope = null;
        }
        return scope;
    }

    /**
     *  从Token里面获取refresh_token
     * @param token 数据源Token
     * @param secret 密钥
     * @return
     */
    public static String getRefresh_tokenStringFromToken(String token, String secret) {
        String refresh_token;
        try {
            final Claims claims = getClaimsFromToken(token, secret);
            refresh_token =  (String) claims.get(CLAIM_KEY_REFRESH_TOKEN);
        } catch (Exception e) {
        	refresh_token = null;
        }
        return refresh_token;
    }
    
    
    /**
     * @description 生成AccessToken
     * @param jwtToken
     * @param expiresIn
     * @return
     */
    public static String generateAccessToken(JwtToken jwtToken) {
        Map<String, Object> claims = new HashMap<>(6);       
        claims.put(CLAIM_KEY_USERID, jwtToken.getUserid());
        claims.put(CLAIM_KEY_OPENID, jwtToken.getOpenid());
        claims.put(CLAIM_KEY_EXPIRES_IN, jwtToken.getExpires_time());
        claims.put(CLAIM_KEY_ACCESS_TOKEN, jwtToken.getAccess_token());
        claims.put(CLAIM_KEY_REFRESH_TOKEN, jwtToken.getRefresh_token());
        claims.put(CLAIM_KEY_SCOPE, jwtToken.getScope());
        
        return generateToken(claims);
    }   
    /**
     * @description 加密
     * @param claims
     * @param clientSecret
     * @return 返回加密字符串
     */ 
    public static String generateToken(Map<String, Object> claims) {
    	 //--------------------加载配置参数----------------------
  	  Map<String, Object> maps =LoadingAuthUtil.loading();
  	  String secret =  (String) maps.get("secret");
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, new String(Base64Utils.encode((secret).getBytes())))
                .compact();
    }
    
    /**
     * @description 解密
     * @param token
     * @param secret 密钥
     * @return claims map
     */
    private static Claims getClaimsFromToken(String token, String secret) {
        Claims claims = Jwts.parser()
                    .setSigningKey(new String(Base64Utils.encode((secret).getBytes())))
                    .parseClaimsJws(token)
                    .getBody();
        return claims;
    }




}
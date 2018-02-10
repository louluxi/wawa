package com.irandoo.xhep.anth.service.impl;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irandoo.app.interf.util.ImageUtil;
import com.irandoo.xhep.anth.model.JwtToken;
import com.irandoo.xhep.base.model.Login;
import  com.irandoo.xhep.base.model.User;
import com.irandoo.xhep.anth.service.JwtLoginService;
import com.irandoo.xhep.anth.util.InvitateCodeUtil;
import com.irandoo.xhep.anth.util.JwtTokenUtil;
import com.irandoo.xhep.anth.util.LoadingAuthUtil;
import com.irandoo.xhep.anth.util.LoadingShareUtil;
import com.irandoo.xhep.anth.util.RewardSplitUtil;
import com.irandoo.xhep.anth.util.UserCodeUtil;
import com.irandoo.xhep.base.service.LoginService;
import com.irandoo.xhep.base.service.SysConfigService;
import com.irandoo.xhep.base.service.UserAccountService;
import com.irandoo.xhep.base.service.UserService;
import com.irandoo.xhep.base.util.TxFileUpload;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
@Service("jwtLoginService")
public class JwtLoginServiceImpl implements JwtLoginService {

	private Log logger = LogFactory.getLog(JwtLoginServiceImpl.class);
	@Autowired
	private UserService userService;
	@Autowired
	private SysConfigService sysConfigService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private LoginService loginService;
	
	
	/**
	 * description: 根据认证码调取微信平台获取信息
	 * @param code 认证码
	 * @return 返回json数据
	 */
	@Transactional
	public Map<String, Object> getAccessToken(String code,Map<String, Object> m) {
		//----------------------- 加载配置文件 ----------------------
		Map<String, Object> maps =LoadingAuthUtil.loading();
		String tokenUrl =  (String) maps.get("tokenUrl");
		String appid =  (String) maps.get("appid");
		String secret =  (String) maps.get("secret");
		//--------------------------调用微信后台服务器----------------------------
        String url= tokenUrl+"appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
        URI uri = URI.create(url);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(uri);
        HttpResponse response;
        try {
            response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                StringBuilder sb = new StringBuilder();

                for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
                    sb.append(temp);
                } 
             JSONObject object = new JSONObject().fromObject(sb.toString().trim());
              logger.info("wechat info："+object);
             //获取所需要的信息
              String  accessToken = object.getString("access_token");
              String  openID = object.getString("openid");
              String  refreshToken = object.getString("refresh_token");
                long expires_in = object.getLong("expires_in");   //获取腾讯过期时间
              //token过期时间
              Date expires_time=new Date(System.currentTimeMillis()+expires_in*1000);              
              String  unionid = object.getString("unionid");
              String   scope = object.getString("scope");
       
              //根据open_id(执行数据的新增和修改)
	          String isFirstLogin =  getUserInfo(accessToken,openID);
	          JwtToken jwtToken=new JwtToken(openID,unionid, expires_time, accessToken, refreshToken, scope);                      
	            
	            //根据open_id，然后调取数据库获取信息
      	        User user = userService.getInfoByOpenId(openID);
      	      //将用户id取出来
	    	    Long userId = user.getId();
	    	  //将用户id设置进JwtToken对象里面
	    	    jwtToken.setUserid(userId+"");
      	      //将token加密
      	        String authorization = JwtTokenUtil.generateAccessToken(jwtToken); 
      	       //添加登录流水
                String login_mode = (String) m.get("loginMode");
                String mode_type = (String) m.get("modeType");
                String mode_code = (String) m.get("modeCode");
                   Login lt = new Login();
                   lt.setUser_id(userId+"");
                   lt.setAuthorization(authorization);
                   lt.setLogin_mode(login_mode);
                   lt.setAccess_token(accessToken);
                   lt.setRefresh_token(refreshToken);
                   lt.setMode_type(mode_type);
                   lt.setMode_code(mode_code);
                   loginService.insert(lt);
               	Map<String, Object> returnMap =new HashMap<String, Object>();
      	        returnMap.put("isFirstLogin", isFirstLogin);
      	        returnMap.put("accessToken", authorization);
      	        return returnMap;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	/**
	 *  @description: 根据accessToken和open_id 获取用户信息
	 */
	private String getUserInfo(String accessToken,String openID){
		//----------------------- 加载配置文件 ----------------------
				Map<String, Object> maps =LoadingAuthUtil.loading();
		        String userInfoUrl = (String) maps.get("userInfoUrl");
	            String uri = userInfoUrl+"access_token=" + accessToken + "&openid=" + openID;
	            HttpClient client = new DefaultHttpClient();
	            HttpGet get = new HttpGet(URI.create(uri));
	            String isFirstLogin = "0"; //默认不是第一次登录
	            try {
	                HttpResponse response = client.execute(get);
	                if (response.getStatusLine().getStatusCode() == 200) {
	                    BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
	                    StringBuilder builder = new StringBuilder();
	                    for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
	                        builder.append(temp);
	                    }
	                    JSONObject object = new JSONObject().fromObject(builder.toString().trim());                       	                  	                    
	                    //获取微信返回的用户基本信息
                       /* String name = object.getString("nickname");
                        Pattern patter = Pattern.compile("[a-zA-Z0-9\u4e00-\u9fa5]");
                        Matcher match = patter.matcher(name);
                        StringBuilder buffer = new StringBuilder();
                        while (match.find()) {
                            buffer.append(match.group());
                        }
                        String nickName = buffer.toString();*/
	                    String nickName =object.getString("nickname");
	                    String sex=object.getString("sex");
	                    String province=object.getString("province");
	                    String city=object.getString("city");
	                    String country=object.getString("country");
	                    String headimgurl=object.getString("headimgurl");
	                    String unionid=object.getString("unionid");	  
	                    logger.info("wechat info:   "+nickName+"---"+sex+"---"+province+"---"+city+"---"+country+"---"+headimgurl+"---"+unionid+"---");
	                    //实例化一个用户
	                    User user=new User();             
	                    user.setNick_name(nickName);
	                    user.setOpenid(openID);
	                    user.setUnionid(unionid);
	                    user.setUser_icon(headimgurl);
	                    user.setGender(sex);
	                    user.setUser_nationality(country);
	                    user.setProvince(province);
	                    user.setCity(city);
	                    //判断是否是第一次登录
	                    int count = userService.judgeUserByOpenId(openID);
	                    logger.info("count:"+count);
	                 if (count == 0) {//查询数据库是否有open_id
	                    logger.info("first login");
	                    //第一次登录，则生成一个唯一的邀请码
	                    String invitateCode = InvitateCodeUtil.createCode();   	
	                    int v =  userService.judgeCodeByCode(invitateCode);
	                    boolean flag= true;
		                    while(flag){
		                    	if(v>0){//说明数据库中已经存在此邀请码，则需要重新生成再继续判断
		                    		invitateCode = InvitateCodeUtil.createCode();
		                    	 v =  userService.judgeCodeByCode(invitateCode);
			                     }else{
			                    	 flag = false;
			                     }
		                    } 
		                //首次登录,根据邀请码自动生成一张图片
		                if(invitateCode != null){
		                //加载配置文件	
		                Map<String, Object> shareMap =	LoadingShareUtil.loading();
		                  String backgroundUrl = (String) shareMap.get("backgroundUrl");
		               	  String aboveUrl = (String) shareMap.get("aboveUrl");
		               	  String compoundUrl = (String) shareMap.get("compoundUrl");
		               	  String compoundName = (String) shareMap.get("compoundName");
		               	  String text = invitateCode;
		               	  String finalUrl = (String) shareMap.get("finalUrl");
		               	  String finalName = "share_"+invitateCode+".png";
		               	  String str[]={ "386", "984" };
		               	  ImageUtil.crearePicture(backgroundUrl, aboveUrl, compoundUrl, compoundName, text, finalUrl, finalName,str);	
		                  String cosIconPath  =  TxFileUpload.upload(finalUrl+finalName, finalName, "share");
                          user.setShareIcon(cosIconPath); //设置地址
		                }
		                //设置用户类型（默认是普通会员）
		                   user.setUser_type("4"); 		                    
	                    //设置邀请码
	                      user.setInvitate_code(invitateCode);
	                    //如果是第一次登录则添加进数据库
	                    	userService.insert(user);
	                    	//根据openid 找到刚刚添加的user
	                        User t = userService.getInfoByOpenId(openID);
	                        //生成userCode 
	                        String userCode = UserCodeUtil.createUserCode(t.getId()+"");
	                    	//修改userCode编码
	                        t.setUser_code(userCode);
	                      	//修改信息                   
	                        userService.update(t);
	                    	//首次登陆要送奖励
	                    String coin = sysConfigService.getValue("SYSTEM", "REWARD", "LOGIN_FRIST");
		                Map<String, Object> rewardMap = RewardSplitUtil.SplitReward(coin);
	                      String rewardCoin =  (String) rewardMap.get("rewardCoin");
	                      String exerciseCoin =  (String) rewardMap.get("exerciseCoin");
			              try {
			                //执行添加娃娃币的服务
					         Map<String, Object> accountMap =new HashMap<String, Object>();
					         accountMap.put("userId", t.getId());
					          //默认充值娃娃币账户
					         accountMap.put("accountType", 1);
					         accountMap.put("balance", rewardCoin);
					         userAccountService.addBalance(accountMap);      
				             //执行添加练习币的服务 
				             Map<String, Object> accountMap1 =new HashMap<String, Object>();
				             accountMap1.put("userId", t.getId());
					          //默认充值娃娃币账户
					         accountMap1.put("accountType", 2);
					         accountMap1.put("balance", exerciseCoin);
					         userAccountService.addBalance(accountMap1);  
							} catch (Exception e) {
								e.printStackTrace();
							}
			              isFirstLogin="1";
	                 }else{//如果不是第一次登录,则执行修改的操作,更新数据库
	                    	//根据openId获取userId
	                    	 User t = userService.getInfoByOpenId(openID);
                             user.setId(t.getId());
                             logger.info(t.getId()+"no first login");
	                    	 userService.update(user);
	                    }
	                }
	            } catch (ClientProtocolException e) {
	             
	                e.printStackTrace();
	            } catch (IOException e) {
	               
	                e.printStackTrace();
	            } catch (JSONException e) {
	               
	                e.printStackTrace();
	            }	
	            return isFirstLogin;
	        }	

}

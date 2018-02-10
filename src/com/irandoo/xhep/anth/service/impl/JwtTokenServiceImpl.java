package com.irandoo.xhep.anth.service.impl;

import com.irandoo.xhep.anth.service.JwtTokenService;
import com.irandoo.xhep.anth.util.LoadingAuthUtil;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Date;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import com.irandoo.xhep.anth.model.JwtToken;

@Service("jwtTokenService")
public class JwtTokenServiceImpl implements JwtTokenService{
	

	@Override
	public JwtToken JwtToken(String refreshToken) {
		return refreshAccessToken(refreshToken);
	}


	public JwtToken refreshAccessToken(String refreshToken) {
		//----------------------- 加载配置文件 ----------------------
				Map<String, Object> maps =LoadingAuthUtil.loading();
				String refreshTokenUrl =  (String) maps.get("refreshTokenUrl");
				String appid =  (String) maps.get("appid");
		//----------------------调用刷新token的方法------------------
        String uri= refreshTokenUrl+"appid="+appid+"&grant_type=refresh_token&refresh_token="+refreshToken;
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(URI.create(uri));
        try {
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                StringBuilder builder = new StringBuilder();
                for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
                    builder.append(temp);
                }
              JSONObject object = new JSONObject().fromObject(builder.toString().trim());
               
              //获取所需要的信息
              String   accessToken = object.getString("access_token");
              String  openID = object.getString("openid");
              String   refreshTokenStr = object.getString("refresh_token");
              long  expires_in = object.getLong("expires_in");   //获取腾讯过期时间
              //token过期时间
              Date expires_time = new Date(System.currentTimeMillis()+expires_in*1000);              
              String unionid = object.getString("unionid");
              String  scope = object.getString("scope");    
              JwtToken jwtToken=new JwtToken(openID,unionid, expires_time, accessToken, refreshTokenStr, scope);                      
             
              return jwtToken;  
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
		return null;
    }

}

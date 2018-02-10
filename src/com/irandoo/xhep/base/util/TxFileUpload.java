package com.irandoo.xhep.base.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;

public class TxFileUpload {


    private static String secretId;
 

    private static String secretKey;
   

    private static String region;
 

    private static String bucketName;
  
    
    private static String keyRoot;
    
    private static String imgpath;
    
	 public static String upload(String localFilePath,String fileName,String type){
		   
		  Properties properties=new Properties();  
          try {  
        	  InputStream fis = ImageUploadUtil.class.getClassLoader().getResourceAsStream("txobject.properties");  
              properties.load(fis);  
              secretId  =properties.getProperty("secretId");  
              secretKey  =properties.getProperty("secretKey");  
              region  =properties.getProperty("region");  
              bucketName  =properties.getProperty("bucketName");  
              keyRoot  =properties.getProperty("keyRoot");  
              imgpath  =properties.getProperty("imgpath").trim();
          } catch (FileNotFoundException e) {  

              e.printStackTrace();  
          } catch (IOException e) {  

              e.printStackTrace();  
          }  
		 // 1 初始化用户身份信息(secretId, secretKey)

		    COSCredentials cred = new BasicCOSCredentials(secretId,secretKey);
			// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
		    ClientConfig clientConfig = new ClientConfig(new Region(region));
			// 3 生成cos客户端
		    COSClient cosclient = new COSClient(cred, clientConfig);
			// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
			String key = type+keyRoot+fileName;
		    File localFile = new File(localFilePath);
			// 指定要上传到 COS 上的路径
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
			PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
		    String etag = putObjectResult.getETag();
		 	return imgpath+key;
	 }  
}

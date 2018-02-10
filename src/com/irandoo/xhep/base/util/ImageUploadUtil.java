package com.irandoo.xhep.base.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.irandoo.app.interf.util.PropertiesUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
public class ImageUploadUtil {
	
	private static String secretId;
	 

    private static String secretKey;
   

    private static String region;
 

    private static String bucketName;
  
    
    private static String keyRoot;
    
   
    private static String imgpath;

    /**
     * 获取配置文件参数
     * @return
     */
   public static  Map<String,String> getPropertis() {
	   Properties properties=new Properties();  
       try { 
          // FileInputStream fis=new FileInputStream("F:\\软件相关\\Tomcat\\apache-tomcat-7.0.79\\wtpwebapps\\wawa\\WEB-INF\\classes/txobject.properties"); 
          // properties.load(fis);  
    	   InputStream in = ImageUploadUtil.class.getClassLoader().getResourceAsStream("txobject.properties");  
    	   properties.load(in);
           secretId  =properties.getProperty("secretId").trim();  
           secretKey  =properties.getProperty("secretKey").trim();  
           region  =properties.getProperty("region").trim();  
           bucketName  =properties.getProperty("bucketName").trim();  
           keyRoot  =properties.getProperty("keyRoot").trim(); 
           imgpath  =properties.getProperty("imgpath").trim();
           in.close();// 关闭流 
       } catch (FileNotFoundException e) {  
           // TODO Auto-generated catch block  
           e.printStackTrace();  
       } catch (IOException e) {  
           // TODO Auto-generated catch block  
           e.printStackTrace();  
       } 
       Map<String, String> paramMap = new HashMap<String, String>();
       paramMap.put("secretId", secretId);
       paramMap.put("secretKey", secretKey);
       paramMap.put("region", region);
       paramMap.put("bucketName", bucketName);
       paramMap.put("keyRoot", keyRoot);
       paramMap.put("imgpath", imgpath);
	return paramMap;
}

 /**
   * 上传到cos腾讯云
   * @param localFilePath
   * @param fileName
   */
	
    public static void uploadcos(String localFilePath,String fileName,String secretId,String secretKey,String region,String bucketName,String keyRoot){   
    	// 1 初始化用户身份信息(secretId, secretKey)
    	COSCredentials cred = new BasicCOSCredentials(secretId,secretKey);
    	// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
    	ClientConfig clientConfig = new ClientConfig(new Region(region));
    	// 3 生成cos客户端
    	COSClient cosclient = new COSClient(cred, clientConfig);
    	// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    	String key = keyRoot+fileName;
    	File localFile = new File(localFilePath);
    	// 指定要上传到 COS 上的路径
    	PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
    	PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
    	String etag = putObjectResult.getETag();
    }  
    /**
     * 更新到本地
     * @param uploadfile
     * @param fileName
     * @param imageType
     * @return
     */
	 public  static String  upload(File uploadfile,String fileName,String imageType) {
		String savePath = "F:\\软件相关\\Tomcat\\tempfiles";
		//如果文件夹不存在，递归创建文件夹
		File fileA =new File(savePath);
		if(!fileA.exists()){
			fileA.mkdirs();
		}
		//根据原文件名称获取后缀
		String hz=fileName.substring(fileName.lastIndexOf("."));
		//为了防止文件名字重复，重新命名文件保存名称
	    String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*10000);
	    //复制文件
	    copyFile(savePath+"/"+newFileName+hz,uploadfile);
	    String cospath=savePath+"/"+newFileName+hz; 
	    Map<String,String> paramMap =getPropertis();
	    String cosName=imageType+"/"+newFileName+hz; 
	    uploadcos(cospath,cosName,paramMap.get("secretId"),paramMap.get("secretKey"),paramMap.get("region"),paramMap.get("bucketName"),paramMap.get("keyRoot"));
		return paramMap.get("imgpath")+cosName;
	}
	/**
	 * 复制文件
	 * @param savePath
	 * @param file
	 */
	public static void copyFile(String savePath,File file){
		try {
			//打开输出流
			OutputStream outputStream =  new FileOutputStream(savePath);
			//套接输出缓冲流
			BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(outputStream);
			//打开输入流
			InputStream inputStream = new FileInputStream(file);
			//套接输入缓冲流
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			//声明缓冲数组
			byte[] by =new byte[1024];
			//定义读取数目
			int len=0;
			//当文件不到文件末尾时读写文件
			while((len=bufferedInputStream.read(by))!=-1){
				bufferedOutputStream.write(by, 0, len);
			}
			//关闭资源操作
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			bufferedInputStream.close();
			outputStream.close();
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

package com.irandoo.app.interf.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageUtil {
	// 水印透明度  
	 private static float alpha = 0.95f;  
  	 
	 /**
	  * 
	  * @param backgroundUrl  背景图地址--主图(例：C:\\Users\\sun\\Desktop\\image\\xxx.png)
	  * @param aboveUrl       覆盖图地址--上面图(例：C:\\Users\\sun\\Desktop\\image\\2.png)
	  * @param compoundUrl    合成图根目录--(例：C:\\Users\\sun\\Desktop\\image\\finish\\)
	  * @param compoundName   合成图名字--(例：t3.png)
	  * @param text           文本内容 --(例：我的验证码：123456)
	  * @param finalUrl       生成存放根目录--(例：C:\\Users\\sun\\Desktop\\image\\finish\\)
	  * @param finalName      生成文件名--(例：tx.jpg)
	  * @param str            文字位置{ "260", "990" }
	  */
	 public static void crearePicture(String backgroundUrl,String aboveUrl,String compoundUrl,String compoundName,String text,String finalUrl,String finalName,String[] str){
		 Picture tt = new Picture(); 
	  BufferedImage d = tt.loadImageLocal(backgroundUrl); 
	  BufferedImage b = tt .loadImageLocal(aboveUrl);                  
	  //往图片上写文件
	  tt.writeImageLocal(compoundUrl+compoundName, tt.modifyImagetogeter(b, d)); 
	  //底层图片   
		String srcImgPath = compoundUrl+compoundName;
	  //保存位置  
	   String targerTextPath = finalUrl+finalName;  
	  //设置文字坐标key与 testValue()的key对应  
	  Map<String, String[]> position = new HashMap<String, String[]>();  
	  //                 x     y      
	  String sstr[] = str;  
	  position.put("name", sstr);  
       
	  Map<String, String> value = new HashMap<String, String>();  
	     value.put("name", text);  
      ImageUtil.markImageByTexts(value, position, srcImgPath, targerTextPath);  
	 }
	 
  
	 /** 
	  * 给图片添加水印文字、可设置水印文字的旋转角度 
	  *  
	  * @param logoText 
	  * @param srcImgPath 
	  * @param targerPath 
	  * @param degree 
	  */  
	 public static void markImageByTexts(Map<String, String> value, Map<String, String[]> position, String srcImgPath,  
	   String targerPath) {  
	  
	  InputStream is = null;  
	  OutputStream os = null;  

	  try {  
	   // 1、源图片  
	   Image srcImg = ImageIO.read(new File(srcImgPath));  
	   BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),  
	   BufferedImage.TYPE_INT_RGB);  
	     
	     
	   // 2、得到画笔对象  
	  
	   Iterator<String> positionIter = position.keySet().iterator();  
	   String key = "";  
	   String logotext = "";  
	   String[] xy;  
	  
	     
	   Graphics2D g = buffImg.createGraphics();  
	   g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,  
	     null);  
	   g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);      
	   // 水印文字字体  
	   Font font = new Font("微软雅黑", Font.PLAIN, 29);  
	   // 水印文字颜色  
	      Color color = new Color(255, 0, 0);  
	      while (positionIter.hasNext()) {  
	    key = positionIter.next();  
	    xy = position.get(key);  
	    logotext = value.get(key);  
	    if (xy != null && xy.length == 2)  

	     // 5、设置水印文字颜色  
	     g.setColor(color);  
	  
	        // 6、设置水印文字Font  
	        g.setFont(font);  
	  
	        // 7、设置水印文字透明度  
	     g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));  
	       
	     // 8、第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)  
	     g.drawString(logotext, Integer.valueOf(xy[0]), Integer.valueOf(xy[1]));  
	   }  
	   // 9、释放资源  
	      g.dispose();  
	   // 10、生成图片  
	   os = new FileOutputStream(targerPath);  
	   ImageIO.write(buffImg, "PNG", os);  
	  
	  } catch (Exception e) {  
	   e.printStackTrace();  
	  } finally {  
	   try {  
	    if (null != is)  
	     is.close();  
	   } catch (Exception e) {  
	    e.printStackTrace();  
	   }  
	   try {  
	    if (null != os)  
	     os.close();  
	   } catch (Exception e) {  
	    e.printStackTrace();  
	   }  
	  }  
	 }  
}

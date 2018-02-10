package com.irandoo.app.interf.json;

import java.io.Serializable;

/**
  * <p>Title:轮播图片json </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午10:46:41
  */
public class CarouselJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String title;
	private String iconPath;
	private String jumpPath;
	public String getTitle() {
		return title;
	}
	public String getIconPath() {
		return iconPath;
	}
	public String getJumpPath() {
		return jumpPath;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	public void setJumpPath(String jumpPath) {
		this.jumpPath = jumpPath;
	}
}

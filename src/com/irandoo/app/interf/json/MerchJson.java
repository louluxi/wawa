package com.irandoo.app.interf.json;

import java.io.Serializable;

/**
  * <p>Title: 商品json</p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-8上午10:58:01
  */
public class MerchJson implements Serializable{
	private static final long serialVersionUID = -897990014861203748L;
	private String id;
	private String batchNum;
	private String merchNum;
	private String merchName;
	private String merchDesc;
	private String merchDescImg;
	private long price;
	private long exchangeCoin;
	public String getId() {
		return id;
	}
	public String getBatchNum() {
		return batchNum;
	}
	public String getMerchNum() {
		return merchNum;
	}
	public String getMerchName() {
		return merchName;
	}
	
	public String getMerchDescImg() {
		return merchDescImg;
	}
	public void setMerchDescImg(String merchDescImg) {
		this.merchDescImg = merchDescImg;
	}
	public String getMerchDesc() {
		return merchDesc;
	}
	public long getPrice() {
		return price;
	}
	public long getExchangeCoin() {
		return exchangeCoin;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	public void setMerchNum(String merchNum) {
		this.merchNum = merchNum;
	}
	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}
	public void setMerchDesc(String merchDesc) {
		this.merchDesc = merchDesc;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public void setExchangeCoin(long exchangeCoin) {
		this.exchangeCoin = exchangeCoin;
	}
}

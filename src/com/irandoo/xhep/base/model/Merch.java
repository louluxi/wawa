package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Merch implements Serializable{

	private static final long serialVersionUID = -7420429655161473178L;
	private Long id;
	private String batch_num;
	private Long merch_type_id;
	private String merch_name;
	private String icon_path;
	private String merch_desc;
	private Long price;
	private Long merch_num;
	private String exchange_coin;
	private String origin;
	private String status;
	private String purchaser;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date purchase_time;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date create_time;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp  update_timestamp;
	private String corp_code;
	private String statusShow;
	private String mechTypeName;
	private String merch_desc_img;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBatch_num() {
		return batch_num;
	}
	public void setBatch_num(String batch_num) {
		this.batch_num = batch_num;
	}
	public Long getMerch_type_id() {
		return merch_type_id;
	}
	public void setMerch_type_id(Long merch_type_id) {
		this.merch_type_id = merch_type_id;
	}
	public String getMerch_name() {
		return merch_name;
	}
	public void setMerch_name(String merch_name) {
		this.merch_name = merch_name;
	}
	public String getMerch_desc() {
		return merch_desc;
	}
	public void setMerch_desc(String merch_desc) {
		this.merch_desc = merch_desc;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getMerch_num() {
		return merch_num;
	}
	public void setMerch_num(Long merch_num) {
		this.merch_num = merch_num;
	}
	public String getExchange_coin() {
		return exchange_coin;
	}
	public void setExchange_coin(String exchange_coin) {
		this.exchange_coin = exchange_coin;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public Date getPurchase_time() {
		return purchase_time;
	}
	public void setPurchase_time(Date purchase_time) {
		this.purchase_time = purchase_time;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
	}
	public String getStatusShow() {
		return statusShow;
	}
	public void setStatusShow(String statusShow) {
		this.statusShow = statusShow;
	}
	public String getMechTypeName() {
		return mechTypeName;
	}
	public void setMechTypeName(String mechTypeName) {
		this.mechTypeName = mechTypeName;
	}
	public String getIcon_path() {
		return icon_path;
	}
	public void setIcon_path(String icon_path) {
		this.icon_path = icon_path;
	}
	public String getMerch_desc_img() {
		return merch_desc_img;
	}
	public void setMerch_desc_img(String merch_desc_img) {
		this.merch_desc_img = merch_desc_img;
	}
	
}

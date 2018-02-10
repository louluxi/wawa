package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 用户订单实体类
 * @author sun
 * 2018年1月12日09:12:33
 */

public class UserOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5845191216842476470L;
	private Long id;
	private Long user_id;
	private String order_type;
	private String order_code;
	private Long merch_id;
	private String sale_code;
    private Long address_id;
    private String status;
    private String express_no;
    private String express_company;
    private String send_user_id;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date send_time;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp update_timestamp;
    private String corp_code;
    private String nick_name;
    private String user_code;
    private String wechat;
    private String merch_name;
    private String detail;
    private String sender_name;
    private String orderTypeShow;
    private String statusShow;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public Long getMerch_id() {
		return merch_id;
	}
	public void setMerch_id(Long merch_id) {
		this.merch_id = merch_id;
	}
	public String getSale_code() {
		return sale_code;
	}
	public void setSale_code(String sale_code) {
		this.sale_code = sale_code;
	}
	public Long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getExpress_no() {
		return express_no;
	}
	public void setExpress_no(String express_no) {
		this.express_no = express_no;
	}
	public String getExpress_company() {
		return express_company;
	}
	public void setExpress_company(String express_company) {
		this.express_company = express_company;
	}
	public String getSend_user_id() {
		return send_user_id;
	}
	public void setSend_user_id(String send_user_id) {
		this.send_user_id = send_user_id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getMerch_name() {
		return merch_name;
	}
	public void setMerch_name(String merch_name) {
		this.merch_name = merch_name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getSender_name() {
		return sender_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public String getOrderTypeShow() {
		return orderTypeShow;
	}
	public void setOrderTypeShow(String orderTypeShow) {
		this.orderTypeShow = orderTypeShow;
	}
	public String getStatusShow() {
		return statusShow;
	}
	public void setStatusShow(String statusShow) {
		this.statusShow = statusShow;
	}

}

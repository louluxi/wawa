package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 收货地址实体类
 * @author sun
 * 2018年1月11日19:42:26
 */

public class UserAddress implements Serializable{
		 private Long id;
		 private Long user_id;
		 private String country;
		 private String province;
		 private String city;
		 private String area;
		 private String detail;
		 private String receiver;
		 private String tel;
		 private String is_default;
		 private Date create_time;
		 private Timestamp update_timestamp;
		 private String corp_code;
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
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
	
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public String getReceiver() {
			return receiver;
		}
		public void setReceiver(String receiver) {
			this.receiver = receiver;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getIs_default() {
			return is_default;
		}
		public void setIs_default(String is_default) {
			this.is_default = is_default;
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
		 
		 
		 
}

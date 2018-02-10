package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User implements Serializable{
	private static final long serialVersionUID = 2301872395734840294L;
	private Long id;                    
	private String user_code;
	private String alias;
	private String shareIcon;      //分享图
	private String invitate_code;  //邀请码
	private String invitated_code;  //邀请码
	private String user_pwd;
	private String user_name;
	private String business_name;
	private String business_email;
	private String department;
	private String post;
	private String user_name_pinyin;
	private String nick_name;
	private Date birthday;
	private String user_icon;
	private String user_email;
	private String address;
	private String zip;
	private String tel;
	private String qq;
	private String wechat;
	private String openid;
	private String unionid;
	private String user_age;
	private String gender;
	private String check_status;
	private String check_method;
	private String register_ip;
	private Date register_time;
	private String register_channel;
	private String user_tel;
	private String user_address;
	private int idtype;
	private String idcode;
	private String user_nationality;
	private String user_type;
	private Integer status;
	private Date expire_date;
	private Date create_time;
	private Long user_corp_id;
	private String corp_code;	
	private String province; //省
	private String city;     //市
	private String is_deleted;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp update_timestamp;
	private String role;
	private String typeShow;
	private String genderShow;
	private String statusShow;
	private String order_group;
	public String getOrder_group() {
		return order_group;
	}
	
	public String getInvitated_code() {
		return invitated_code;
	}

	public void setInvitated_code(String invitated_code) {
		this.invitated_code = invitated_code;
	}

	public void setOrder_group(String order_group) {
		this.order_group = order_group;
	}
	public String getStatusShow() {
		return statusShow;
	}
	public void setStatusShow(String statusShow) {
		this.statusShow = statusShow;
	}
	public String getTypeShow() {
		return typeShow;
	}
	public void setTypeShow(String typeShow) {
		this.typeShow = typeShow;
	}
	public String getGenderShow() {
		return genderShow;
	}
	public void setGenderShow(String genderShow) {
		this.genderShow = genderShow;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_name_pinyin() {
		return user_name_pinyin;
	}
	public void setUser_name_pinyin(String user_name_pinyin) {
		this.user_name_pinyin = user_name_pinyin;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getUser_image() {
		return user_icon;
	}
	public void setUser_icon(String user_icon) {
		this.user_icon = user_icon;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_age() {
		return user_age;
	}
	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public int getIdtype() {
		return idtype;
	}
	public void setIdtype(int idtype) {
		this.idtype = idtype;
	}
	public String getIdcode() {
		return idcode;
	}
	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}
	public String getUser_nationality() {
		return user_nationality;
	}
	public void setUser_nationality(String user_nationality) {
		this.user_nationality = user_nationality;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Long getUser_corp_id() {
		return user_corp_id;
	}
	public void setUser_corp_id(Long user_corp_id) {
		this.user_corp_id = user_corp_id;
	}
	public String getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getBusiness_email() {
		return business_email;
	}
	public void setBusiness_email(String business_email) {
		this.business_email = business_email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getInvitate_code() {
		return invitate_code;
	}
	public void setInvitate_code(String invitate_code) {
		this.invitate_code = invitate_code;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getCheck_status() {
		return check_status;
	}
	public void setCheck_status(String check_status) {
		this.check_status = check_status;
	}
	public String getCheck_method() {
		return check_method;
	}
	public void setCheck_method(String check_method) {
		this.check_method = check_method;
	}
	public String getRegister_ip() {
		return register_ip;
	}
	public void setRegister_ip(String register_ip) {
		this.register_ip = register_ip;
	}
	public Date getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	public String getRegister_channel() {
		return register_channel;
	}
	public void setRegister_channel(String register_channel) {
		this.register_channel = register_channel;
	}
	public String getCorp_code() {
		return corp_code;
	}
	public void setCorp_code(String corp_code) {
		this.corp_code = corp_code;
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
	public String getUser_icon() {
		return user_icon;
	}
	public String getShareIcon() {
		return shareIcon;
	}
	public void setShareIcon(String shareIcon) {
		this.shareIcon = shareIcon;
	}
	
	
	
	
}

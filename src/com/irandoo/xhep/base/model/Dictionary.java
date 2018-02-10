package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

public class Dictionary implements Serializable {
	private static final long serialVersionUID = -897990014861203748L;
	private Long id;
	private String dictId;
	private String dictName;
	private int dictType;
	private String descript;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp update_timestamp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDictId() {
		return dictId;
	}
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public int getDictType() {
		return dictType;
	}
	public void setDictType(int dictType) {
		this.dictType = dictType;
	}
	
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	public Timestamp getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(Timestamp update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
}

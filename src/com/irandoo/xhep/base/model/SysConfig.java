package com.irandoo.xhep.base.model;

import java.io.Serializable;

/**
 * @author ager
 * @version 1.0 
 */
public class SysConfig implements Serializable
{
	private static final long serialVersionUID = 7434408901205346360L;
	private int id;
	private String param_cat;
    private String param_type;
    private String param_name;
    private String param_value;
    private String param_desc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParam_cat() {
		return param_cat;
	}
	public void setParam_cat(String param_cat) {
		this.param_cat = param_cat;
	}
	public String getParam_type() {
		return param_type;
	}
	public void setParam_type(String param_type) {
		this.param_type = param_type;
	}
	public String getParam_name() {
		return param_name;
	}
	public void setParam_name(String param_name) {
		this.param_name = param_name;
	}
	public String getParam_value() {
		return param_value;
	}
	public void setParam_value(String param_value) {
		this.param_value = param_value;
	}
	public String getParam_desc() {
		return param_desc;
	}
	public void setParam_desc(String param_desc) {
		this.param_desc = param_desc;
	}
}

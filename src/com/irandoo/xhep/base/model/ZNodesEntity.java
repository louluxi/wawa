package com.irandoo.xhep.base.model;

import java.io.Serializable;

public class ZNodesEntity implements Serializable{
	private static final long serialVersionUID = -6849437729773311895L;
	private long id;
	private long pId;
	private String name;
	private boolean open;
	private boolean checked;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPId() {
		return pId;
	}
	public void setPId(long pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}

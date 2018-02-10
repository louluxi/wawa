package com.irandoo.xhep.base.model;

import java.io.Serializable;
import java.util.List;

public class NodeEntity implements Serializable{
	private static final long serialVersionUID = -6849437729773311895L;
	private String id;
	private String text;
	private String href;
	private String level;
	private String parentId;
	private List<NodeEntity> nodes;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<NodeEntity> getNodes() {
		return nodes;
	}
	public void setNodes(List<NodeEntity> nodes) {
		this.nodes = nodes;
	}
}

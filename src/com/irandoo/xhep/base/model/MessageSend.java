package com.irandoo.xhep.base.model;

import java.io.Serializable;

public class MessageSend implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4772159725419423758L;

    private String content;//内容

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
}

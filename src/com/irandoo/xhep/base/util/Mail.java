package com.irandoo.xhep.base.util;

import java.util.List;
/**
 * 
 * @author ager
 *
 */
public class Mail {
	private List<String> mailAddress;
	private String name;
	private String content;
	private String[] filesPath;

	public List<String> getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(List<String> mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String[] filesPath) {
		this.filesPath = filesPath;
	}

}

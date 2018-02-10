package com.irandoo.xhep.base.util;

import java.util.List;
/**
 * 
 * @author ager
 * @version 1.0
 */
public class PagerModel {
	private List datas;
	private int total;
	
	public List getDatas() {
		return datas;
	}
	public void setDatas(List datas) {
		this.datas = datas;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}

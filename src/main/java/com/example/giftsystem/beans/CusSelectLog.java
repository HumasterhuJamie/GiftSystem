package com.example.giftsystem.beans;

import java.util.Date;

import org.springframework.stereotype.Component;
/**
 * 上次訂單資訊的紀錄檔
 * */
@Component
public class CusSelectLog {
	
	private int id;
	private String cus_id;
	private Date exe_date;
	private String product_id;
	private String cus_option;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	public Date getExe_date() {
		return exe_date;
	}
	public void setExe_date(Date exe_date) {
		this.exe_date = exe_date;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getCus_option() {
		return cus_option;
	}
	public void setCus_option(String cus_option) {
		this.cus_option = cus_option;
	}

}

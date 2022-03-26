package com.example.giftsystem.beans;

import org.springframework.stereotype.Component;
/**
 * 用戶資訊
 * 
 * */
@Component
public class CusInfo {
	
	private int id;
	private String cus_id;
	private int cus_points;
	private int cus_balance;
	private String cus_company;	
	private String cus_address;
	private String cus_phone;
	private String cus_email;
	private String recipient;
	private String cus_mobile;
	private String cus_city;
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
	public int getCus_points() {
		return cus_points;
	}
	public void setCus_points(int cus_points) {
		this.cus_points = cus_points;
	}
	public String getCus_company() {
		return cus_company;
	}
	public void setCus_company(String cus_company) {
		this.cus_company = cus_company;
	}
	public int getCus_balance() {
		return cus_balance;
	}
	public void setCus_balance(int cus_balance) {
		this.cus_balance = cus_balance;
	}
	public String getCus_address() {
		return cus_address;
	}
	public void setCus_address(String cus_address) {
		this.cus_address = cus_address;
	}
	public String getCus_phone() {
		return cus_phone;
	}
	public void setCus_phone(String cus_phone) {
		this.cus_phone = cus_phone;
	}
	public String getCus_email() {
		return cus_email;
	}
	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getCus_mobile() {
		return cus_mobile;
	}
	public void setCus_mobile(String cus_mobile) {
		this.cus_mobile = cus_mobile;
	}
	public String getCus_city() {
		return cus_city;
	}
	public void setCus_city(String cus_city) {
		this.cus_city = cus_city;
	}
}

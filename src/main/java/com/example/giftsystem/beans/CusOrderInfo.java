package com.example.giftsystem.beans;

import java.util.Date;

import org.springframework.stereotype.Component;
/**
 * 訂單資訊
 * */
@Component
public class CusOrderInfo {
	
	private int id;
	private String product_id;
	private String product_name;
	private int product_stock;
	private int porduct_total;		
	private String product_type;
	private String product_status;
	private String img_url;
	private String supplier;	
	private int price;
	private int order_id;
	private String cus_id;
	private String cus_address;
	private String cus_phone;
	private String cus_email;	
	private Date cus_deliver_date;		
	private String recipient;
	private Date receive_time;	
	private String cus_mobile;
	private String cus_city;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	public int getPorduct_total() {
		return porduct_total;
	}
	public void setPorduct_total(int porduct_total) {
		this.porduct_total = porduct_total;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
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
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	public Date getCus_deliver_date() {
		return cus_deliver_date;
	}
	public void setCus_deliver_date(Date cus_deliver_date) {
		this.cus_deliver_date = cus_deliver_date;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public Date getReceive_time() {
		return receive_time;
	}
	public void setReceive_time(Date receive_time) {
		this.receive_time = receive_time;
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

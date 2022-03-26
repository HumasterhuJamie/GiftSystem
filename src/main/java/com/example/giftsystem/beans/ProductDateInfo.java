package com.example.giftsystem.beans;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 商品資訊:庫存、總數、日期等等
 * */
@Component
public class ProductDateInfo {

	private int id;
	private String product_id;
	private int product_date_stock;
	private int product_date_total;
	private Date product_date;
	private String product_display_date; 
	
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
	public int getProduct_date_stock() {
		return product_date_stock;
	}
	public void setProduct_date_stock(int product_date_stock) {
		this.product_date_stock = product_date_stock;
	}
	public int getProduct_date_total() {
		return product_date_total;
	}
	public void setProduct_date_total(int product_date_total) {
		this.product_date_total = product_date_total;
	}
	public Date getProduct_date() {
		return product_date;
	}
	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}
	public String getProduct_display_date() {
		return product_display_date;
	}
	public void setProduct_display_date(String product_display_date) {
		this.product_display_date = product_display_date;
	}
	
}

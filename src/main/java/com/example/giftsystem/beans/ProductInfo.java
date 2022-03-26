package com.example.giftsystem.beans;

import org.springframework.stereotype.Component;

/**
 * 商品資訊:名稱、圖片、價格、分類等等
 * */
@Component
public class ProductInfo {
	
	private int id;
	private String product_id;
	private String product_name;		
	private int product_stock;
	private int porduct_total;
	private String product_type;
	private String img_url;
	private String supplier;
	private int price;
	
	
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

}

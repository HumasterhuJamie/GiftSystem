package com.example.giftsystem.beans;

import java.util.List;

public class ProductInfoReturnData {	
	private List<ProductInfo> productInfos;
	private List<ProductDateInfo> productDateInfos;
	
	public List<ProductInfo> getProductInfos() {
		return productInfos;
	}
	public void setProductInfos(List<ProductInfo> productInfos) {
		this.productInfos = productInfos;
	}
	public List<ProductDateInfo> getProductDateInfos() {
		return productDateInfos;
	}
	public void setProductDateInfos(List<ProductDateInfo> productDateInfos) {
		this.productDateInfos = productDateInfos;
	}
	
}

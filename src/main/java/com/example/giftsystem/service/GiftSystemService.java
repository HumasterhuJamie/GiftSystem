package com.example.giftsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.giftsystem.Repository.GiftSystemDao;
import com.example.giftsystem.beans.CusInfo;
import com.example.giftsystem.beans.CusOrderInfo;
import com.example.giftsystem.beans.CusSelectLog;
import com.example.giftsystem.beans.ProductDateInfo;
import com.example.giftsystem.beans.ProductInfo;
import com.example.giftsystem.beans.ProductInfoReturnData;


@Service
public class GiftSystemService {
	
	@Autowired
	GiftSystemDao GiftSystemDao;
	
	
	/**
	 * 預定商品
	 * @param CusSelectData
	 */
	public boolean saveCusSelectData(CusOrderInfo CusSelectData) {

		ProductInfo productInfo = GiftSystemDao.getProductInfoById(CusSelectData.getProduct_id());
		int cus_balance = GiftSystemDao.getcusInfo(CusSelectData.getCus_id()).getCus_balance();
		
		if(productInfo.getProduct_stock() > 0 && cus_balance >= productInfo.getPrice()) {
			productInfo.setProduct_stock(productInfo.getProduct_stock() - 1);
			GiftSystemDao.updateProductInfoStock(productInfo);
			GiftSystemDao.saveCusSelectData(CusSelectData);
			return true;
		}
		return false;
	}
	

	
	public boolean updateDeliveryData(CusOrderInfo CusSelectData) {
		ProductDateInfo productDateInfo = GiftSystemDao.getProductDateInfoById(CusSelectData.getProduct_id(), CusSelectData.getCus_deliver_date());
		if(CusSelectData.getProduct_status().equals("order_success")) {			
			productDateInfo.setProduct_date_stock(productDateInfo.getProduct_date_stock() - 1);
			GiftSystemDao.updateProductDateInfoStock(productDateInfo);						
			GiftSystemDao.updateDeliveryData(CusSelectData);
			return true;
		} else if(productDateInfo.getProduct_date_stock() > 0) {
			productDateInfo.setProduct_date_stock(productDateInfo.getProduct_date_stock() - 1);
			GiftSystemDao.updateProductDateInfoStock(productDateInfo);			
			GiftSystemDao.saveDeliveryData(CusSelectData);
			return true;
		}
		return false;
	}	
	public void cancelAllCusSelectData(String cus_id) {
		GiftSystemDao.cancelAllCusSelectData(cus_id);
	}
	
	public void cancelCusSelectData(String cus_id, int order_id) {
		GiftSystemDao.cancelCusSelectData(cus_id, order_id);
	}
	
	/**
	 * 獲取產品列表
	 * 
	 */
	public ProductInfoReturnData getProductInfo() {		
		ProductInfoReturnData productInfoReturnData = new ProductInfoReturnData();		
		List<ProductInfo> productInfos = GiftSystemDao.getProductInfo();
		productInfoReturnData.setProductInfos(productInfos);
		List<ProductDateInfo> productDateInfos = GiftSystemDao.getProductDateInfo();
		productInfoReturnData.setProductDateInfos(productDateInfos);
		return productInfoReturnData;
	}	
	/**
	 * 獲取非預定商品
	 */
	public List<String> getProOrderProductIds(String cus_id) {
		return GiftSystemDao.getOrderProductIds(cus_id);
	}
	/**
	 * 獲取預定商品
	 */
	public List<String> getPreOrderProductIds(String cus_id) {
		return GiftSystemDao.getPreOrderProductIds(cus_id);
	}
	
	/**
	 * 依照產品ID獲取配送日期資訊	  
	 */
	public List<ProductDateInfo> getProductDateInfos(List<String> product_ids) {
		return GiftSystemDao.getProductDateInfos(product_ids);
	}
	/**
	 * 獲取商品圖片
	 */	
	public List<ProductInfo> getProductImages(String product_id) {
		return GiftSystemDao.getProductImages(product_id);
	}
	/**
	 * 依照產品ID獲取商品資訊
	 */
	public List<ProductInfo> getProductInfos(List<String> product_ids) {
		return GiftSystemDao.getProductInfos(product_ids);
	}
	/**
	 * 獲取用戶的訂單中狀態非cancel的訂單
	 */
	public List<CusOrderInfo> getCusOrderInfo(String cus_id) {
		return GiftSystemDao.getCusOrderInfo(cus_id);
	}

}

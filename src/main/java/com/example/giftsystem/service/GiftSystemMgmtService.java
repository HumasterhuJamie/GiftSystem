package com.example.giftsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.giftsystem.Repository.GiftSystemMgmtDao;
import com.example.giftsystem.beans.CusInfo;
import com.example.giftsystem.beans.CusOrderInfo;
import com.example.giftsystem.beans.CusSelectLog;
import com.example.giftsystem.beans.ProductDateInfo;
import com.example.giftsystem.beans.ProductInfo;
import com.example.giftsystem.beans.ProductInfoReturnData;


@Service
public class GiftSystemMgmtService {
	
	@Autowired
	GiftSystemMgmtDao GiftSystemMgmtDao;
	/**
	 * 獲取所有商品資訊 Mgmt
	 * */
	public ProductInfoReturnData getProductInfo() {		
		ProductInfoReturnData productInfoReturnData = new ProductInfoReturnData();		
		List<ProductInfo> productInfos = GiftSystemMgmtDao.getProductInfo();
		productInfoReturnData.setProductInfos(productInfos);
		List<ProductDateInfo> productDateInfos = GiftSystemMgmtDao.getProductDateInfo();
		productInfoReturnData.setProductDateInfos(productDateInfos);
		return productInfoReturnData;
	}	
	/**
	 * 新增商品
	 * */
	public void insertProductInfo(ProductInfo ProductInfo) {
		GiftSystemMgmtDao.insertProductInfo(ProductInfo);
	}
	public void insertProductDateInfo(ProductDateInfo ProductDateInfo) {
		GiftSystemMgmtDao.insertProductDateInfo(ProductDateInfo);
	}
	/**
	 * 更新商品
	 * */
	public void updateProductInfo(ProductInfo ProductInfo) {	
		GiftSystemMgmtDao.updateProductInfo(ProductInfo);
	}
	public void updateProductDateInfo(ProductDateInfo ProductDateInfo) {	
		GiftSystemMgmtDao.insertProductDateInfo(ProductDateInfo);
	}
	/**
	 * 刪除商品
	 * */
	public void deleteProductInfo(int id) {		
		GiftSystemMgmtDao.deleteProductInfo(id);
	}
	public void deleteProductDateInfo(int id) {		
		GiftSystemMgmtDao.deleteProductDateInfo(id);
	}
	
}

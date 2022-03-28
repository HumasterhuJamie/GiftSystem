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
	public boolean insertProductInfo(ProductInfo ProductInfo) {
		return GiftSystemMgmtDao.insertProductInfo(ProductInfo);
	}
	public boolean insertProductDateInfo(ProductDateInfo ProductDateInfo) {
		return GiftSystemMgmtDao.insertProductDateInfo(ProductDateInfo);
	}
	/**
	 * 更新商品
	 * */
	public boolean updateProductInfo(ProductInfo ProductInfo) {	
		return GiftSystemMgmtDao.updateProductInfo(ProductInfo);
	}
	public boolean updateProductDateInfo(ProductDateInfo ProductDateInfo) {	
		return GiftSystemMgmtDao.insertProductDateInfo(ProductDateInfo);
	}
	/**
	 * 刪除商品
	 * */
	public boolean deleteProductInfo(int id) {		
		return GiftSystemMgmtDao.deleteProductInfo(id);
	}
	public boolean deleteProductDateInfo(int id) {		
		return GiftSystemMgmtDao.deleteProductDateInfo(id);
	}
	
}

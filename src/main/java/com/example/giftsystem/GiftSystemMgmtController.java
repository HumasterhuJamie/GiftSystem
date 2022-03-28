package com.example.giftsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.giftsystem.beans.ProductDateInfo;
import com.example.giftsystem.beans.ProductInfo;
import com.example.giftsystem.beans.ProductInfoReturnData;
import com.example.giftsystem.beans.ResultBean;
import com.example.giftsystem.service.GiftSystemMgmtService;

/**
 * 後臺管理系統的api
 * */
@CrossOrigin
@RestController
public class GiftSystemMgmtController {
	

	@Autowired
	GiftSystemMgmtService giftsystemMgmtService;
	

	/**
	 * 獲取可選擇之商品 
	 */
	@CrossOrigin
	@GetMapping("/getProductInfoMgmt")
	public ResultBean getProductInfo() {
		ResultBean resultBean = new ResultBean();
		ProductInfoReturnData productInfoReturnData = new ProductInfoReturnData();
		//獲取商品列表
		productInfoReturnData = giftsystemMgmtService.getProductInfo();
		if(productInfoReturnData  == null) {
			resultBean.setResult_code(500);
			resultBean.setResult_message("Nothing in the List!");
			resultBean.setDatas(productInfoReturnData);		
			return resultBean;
		}else {
			resultBean.setResult_code(200);
			resultBean.setResult_message("Get Data success!");
			resultBean.setDatas(productInfoReturnData);			
			return resultBean;
		}		
	}
	 /**
	 *創建商品 
	 */
	 @CrossOrigin
	 @RequestMapping(value = "/createProductInfo",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResultBean createProductInfo(ProductInfo ProductInfo) {
		 ResultBean resultBean = new ResultBean();
		 boolean isSuccess = false;
		 isSuccess = giftsystemMgmtService.insertProductInfo(ProductInfo);
		 if(isSuccess) {
			resultBean.setResult_code(200);
			resultBean.setResult_message("Create Data success!");
			return resultBean;	 
		 }else {
			resultBean.setResult_code(500);
			resultBean.setResult_message("Handle errors for JDBC!");
			return resultBean;	 
		 }
	 }
	 /**
	 *創建商品 
	 */
	 @CrossOrigin
	 @RequestMapping(value = "/createProductDateInfo",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)	 
	 public ResultBean createProductDateInfo(ProductDateInfo ProductDateInfo) {
		 ResultBean resultBean = new ResultBean();
		 boolean isSuccess = false;
		 isSuccess = giftsystemMgmtService.insertProductDateInfo(ProductDateInfo);
		 if(isSuccess) {
			resultBean.setResult_code(200);
			resultBean.setResult_message("Create Data success!");
			return resultBean;	 
		 }else {
			resultBean.setResult_code(500);
			resultBean.setResult_message("Handle errors for JDBC!");
			return resultBean;	 
		 }
	}	
	 /**
	 *更新商品 
	 */
	 @CrossOrigin
	 @RequestMapping(value = "/updateProductInfo",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)	 
	 public ResultBean updateProductInfo(ProductInfo ProductInfo) {
		 ResultBean resultBean = new ResultBean();
		 boolean isSuccess = false;
		 isSuccess = giftsystemMgmtService.updateProductInfo(ProductInfo);
		 if(isSuccess) {
			resultBean.setResult_code(200);
			resultBean.setResult_message("Update Data success!");
			return resultBean;	 
		 }else {
			resultBean.setResult_code(500);
			resultBean.setResult_message("Handle errors for JDBC!");
			return resultBean;	 
		 }
	}
	 /**
	 *更新商品 
	 */
	 @CrossOrigin
	 @RequestMapping(value = "/updateProductDateInfo",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)	 
	 public ResultBean updateProductDateInfo(ProductDateInfo ProductDateInfo) {
		 ResultBean resultBean = new ResultBean();
		 boolean isSuccess = false;
		 isSuccess = giftsystemMgmtService.updateProductDateInfo(ProductDateInfo);
		 if(isSuccess) {
			resultBean.setResult_code(200);
			resultBean.setResult_message("Update Data success!");
			return resultBean;	 
		 }else {
			resultBean.setResult_code(500);
			resultBean.setResult_message("Handle errors for JDBC!");
			return resultBean;	 
		 }
	}
	 /**
	 *刪除商品 
	 */
	 @CrossOrigin
	 @RequestMapping(value = "/deleteProductInfo",method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)	 
	 public ResultBean deleteProductInfo(int id) {
		 ResultBean resultBean = new ResultBean();
		 boolean isSuccess = false;
		 isSuccess = giftsystemMgmtService.deleteProductInfo(id);
		 if(isSuccess) {
			resultBean.setResult_code(200);
			resultBean.setResult_message("Delete Data success!");
			return resultBean;	 
		 }else {
			resultBean.setResult_code(500);
			resultBean.setResult_message("Handle errors for JDBC!");
			return resultBean;	 
		 }
	}
	 /**
	 *更新商品 
	 */
	 @CrossOrigin
	 @RequestMapping(value = "/deleteProductDateInfo",method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)	 
	 public ResultBean deleteProductDateInfo(int id) {
		 ResultBean resultBean = new ResultBean();
		 boolean isSuccess = false;
		 isSuccess = giftsystemMgmtService.deleteProductDateInfo(id);
		 if(isSuccess) {
			resultBean.setResult_code(200);
			resultBean.setResult_message("Delete Data success!");
			return resultBean;	 
		 }else {
			resultBean.setResult_code(500);
			resultBean.setResult_message("Handle errors for JDBC!");
			return resultBean;	 
		 }
	}
	
	
	
	
	
	
	
	
	
}

package com.example.giftsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 後臺管理系統的api
 * */
@CrossOrigin
@RestController
@Tag(name = "管理者介面", description = "管理商品的上架、修改、刪除")
public class GiftSystemMgmtController {
	

	@Autowired
	GiftSystemMgmtService giftsystemMgmtService;
	

	/**
	 * 獲取可選擇之商品 
	 */
	@Operation(summary = "管理者獲取可選擇之商品 ")
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
	 @Operation(summary = "創建商品")
	 @CrossOrigin
	 @RequestMapping(value = "/createProductInfo",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResultBean createProductInfo(@RequestBody ProductInfo ProductInfo) {
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
	 @Operation(summary = "創建商品(Date)")
	 @CrossOrigin
	 @RequestMapping(value = "/createProductDateInfo",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)	 
	 public ResultBean createProductDateInfo(@RequestBody ProductDateInfo ProductDateInfo) {
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
	 @Operation(summary = "更新商品資訊")
	 @CrossOrigin
	 @RequestMapping(value = "/updateProductInfo",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)	 
	 public ResultBean updateProductInfo(@RequestBody ProductInfo ProductInfo) {
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
	 @Operation(summary = "更新商品資訊(Date)")
	 @CrossOrigin
	 @RequestMapping(value = "/updateProductDateInfo",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)	 
	 public ResultBean updateProductDateInfo(@RequestBody ProductDateInfo ProductDateInfo) {
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
	 @Operation(summary = "刪除商品所有資訊")
	 @CrossOrigin
	 @RequestMapping(value = "/deleteProductInfo/{id}",method = RequestMethod.DELETE)	 
	 public ResultBean deleteProductInfo(@PathVariable("id") int id) {
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
	 @Operation(summary = "刪除商品所有資訊(Date)")
	 @CrossOrigin
	 @RequestMapping(value = "/deleteProductDateInfo/{id}",method = RequestMethod.DELETE)	 
	 public ResultBean deleteProductDateInfo(@PathVariable("id") int id) {
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

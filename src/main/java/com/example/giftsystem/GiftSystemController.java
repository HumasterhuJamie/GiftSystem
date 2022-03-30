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
import org.springframework.web.servlet.ModelAndView;

import com.example.giftsystem.beans.CusInfo;
import com.example.giftsystem.beans.CusOrderInfo;
import com.example.giftsystem.beans.ProductDateInfo;
import com.example.giftsystem.beans.ProductInfo;
import com.example.giftsystem.beans.ProductInfoReturnData;
import com.example.giftsystem.beans.ResultBean;
import com.example.giftsystem.service.GiftSystemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@CrossOrigin
@RestController
@Tag(name = "使用者介面", description = "使用者觀看、新增、修改、刪除訂單")
public class GiftSystemController {
	

	@Autowired
	GiftSystemService giftsystemService;

	/**
	 * 獲取可選擇之商品	 
	 */
	@Operation(summary = "獲取可選擇之商品")
	@CrossOrigin
	@GetMapping("/getProductInfo")
	public ResultBean getProductInfo() {
		ResultBean resultBean = new ResultBean();
		ProductInfoReturnData productInfoReturnData = new ProductInfoReturnData();
		//獲取商品列表
		productInfoReturnData = giftsystemService.getProductInfo();
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
	 * 獲取用戶的訂單中狀態非cancel的訂單
	 * @param cus_id
	 * @return
	 */
	@Operation(summary = "獲取用戶的訂單中狀態非cancel的訂單")
	@CrossOrigin
	@GetMapping("/getcusOrderProductInfo")
	public ResultBean getcusOrderProductInfo(@RequestParam(value="cus_id", required=true) String cus_id) {		
		ResultBean resultBean = new ResultBean();
		List<CusOrderInfo> cusOrderInfos = null;
		if(!cus_id.isEmpty()) {
			cusOrderInfos = giftsystemService.getCusOrderInfo(cus_id);
			resultBean.setResult_code(200);
			resultBean.setResult_message("Get Data success!");
			resultBean.setDatas(cusOrderInfos);		
			return resultBean;
		}else {
			resultBean.setResult_code(500);
			resultBean.setResult_message("No Data in this Product!");
			resultBean.setDatas(cusOrderInfos);			
			return resultBean;
		}		
	}
	
	/**
	 * 依據用戶預定商品獲取配送訊息
	 * @param cus_id
	 * @return
	 */
	@Operation(summary = "依據用戶預定商品獲取配送訊息")
	@CrossOrigin
	@GetMapping("/getcusPreOrderProductDateInfo")
	public ResultBean getcusProductDateInfo(@RequestParam(value="cus_id", required=true) String cus_id) {
		ResultBean resultBean = new ResultBean();
		List<ProductDateInfo> productDateInfos = null;
		if(!cus_id.isEmpty()) {
			//獲取預定商品
			List<String> product_ids = giftsystemService.getPreOrderProductIds(cus_id);
			if(product_ids == null || product_ids.size() == 0) {
				resultBean.setResult_code(500);
				resultBean.setResult_message("The customer doesn't have pre_order data!");
				resultBean.setDatas(productDateInfos);		
				return resultBean;
			}else {
				//獲取產品配送資訊
				productDateInfos = giftsystemService.getProductDateInfos(product_ids);
				if(productDateInfos == null || productDateInfos.size() == 0) {
					resultBean.setResult_code(500);
					resultBean.setResult_message("No Data in product_date_info!");
					resultBean.setDatas(productDateInfos);	
					return resultBean;
				}else {
					resultBean.setResult_code(200);
					resultBean.setResult_message("Get Data success!");
					resultBean.setDatas(productDateInfos);	
					return resultBean;
				}
			}
		}else {
			resultBean.setResult_code(401);
			resultBean.setResult_message("cus_id error!");
			resultBean.setDatas(productDateInfos);			
			return resultBean;
		}	
		
	}	
	
	/**
	 * 上傳用戶預定商品資料
	 * @param CusSelectData
	 * @return
	 */
	@Operation(summary = "上傳用戶預定商品資料")
	@CrossOrigin
	@RequestMapping(value = "/postCusSelectData",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResultBean postCusSelectData(@RequestBody CusOrderInfo CusOrderInfo) {
		ResultBean resultBean = new ResultBean();
		boolean isSuccess = giftsystemService.saveCusSelectData(CusOrderInfo);
		if(isSuccess) {
			resultBean.setResult_code(200);
			resultBean.setResult_message("Set Data success!");
			return resultBean;
		} else {
			resultBean.setResult_code(500);
			resultBean.setResult_message("該商品已搶購完畢");
			return resultBean;
		}
	}
	/**
	 * 上傳用戶商品寄送資料
	 * @param CusSelectData
	 * @return
	 */	
	@Operation(summary = "上傳用戶商品寄送資料")
	@CrossOrigin
	@RequestMapping(value = "/putDeliveryData",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResultBean putDeliveryData(@RequestBody CusOrderInfo CusOrderInfo) {
		ResultBean resultBean = new ResultBean();
		boolean flag = giftsystemService.updateDeliveryData(CusOrderInfo);
		if(flag) {
			resultBean.setResult_code(200);
			resultBean.setResult_message("Update Data success!");
			return resultBean;
		} else {
			resultBean.setResult_code(500);
			resultBean.setResult_message("貨運配送數量不足");
			return resultBean;
		}				
	}
	/**
	 * 用戶取消所有商品訂單
	 * @param cus_id
	 * @return
	 */	
	@Operation(summary = "用戶取消所有商品訂單")
	@CrossOrigin
	@GetMapping("/cancelAllCusSelectData")
	public ResultBean cancelAllCusSelectData(@RequestParam(value="cus_id", required=true) String cus_id) {
		ResultBean resultBean = new ResultBean();
		if(!cus_id.isEmpty()) {
			giftsystemService.cancelAllCusSelectData(cus_id);
			resultBean.setResult_code(200);
			resultBean.setResult_message("Cancel all datas success!");	
			return resultBean;
		}else {
			resultBean.setResult_code(401);
			resultBean.setResult_message("cus_id error!");
			return resultBean;
		}					
	}
	/**
	 * 用戶取消商品訂單
	 * @param cus_id
	 * @return
	 */	
	@Operation(summary = "用戶取消商品訂單")
	@CrossOrigin
	@GetMapping("/cancelCusSelectDataByOrderId")
	public ResultBean cancelCusSelectDataByOrderId(@RequestParam(value="cus_id", required=true) String cus_id,
			@RequestParam(value="order_id", required=true) int order_id) {
		ResultBean resultBean = new ResultBean();
		if(!cus_id.isEmpty()) {
			giftsystemService.cancelCusSelectData(cus_id, order_id);
			resultBean.setResult_code(200);
			resultBean.setResult_message("cancel data success!");			
			return resultBean;
		}else {
			resultBean.setResult_code(401);
			resultBean.setResult_message("cus_id error!");
			return resultBean;
		}				
	}
	/**
	 * 獲取商品圖片
	 * @param product_id
	 * @return
	 */		
	@Operation(summary = "獲取商品圖片")
	@CrossOrigin
	@GetMapping("/getProductImages")
	public ResultBean getProductImages(@RequestParam(value="product_id", required=true) String product_id) {
		List<ProductInfo> productImages;
		ResultBean resultBean = new ResultBean();
		if(!product_id.isEmpty()) {			
			productImages = giftsystemService.getProductImages(product_id);
			if(productImages == null || productImages.size() == 0) {
				resultBean.setResult_code(500);
				resultBean.setResult_message("The product has not any image.");	
				return resultBean;
			}else {
				resultBean.setResult_code(200);
				resultBean.setResult_message("Get image success.");
				resultBean.setDatas(productImages);
				return resultBean;
			}			
		}else {
			resultBean.setResult_code(401);
			resultBean.setResult_message("product_id error!");
			return resultBean;
		}					
	}
}

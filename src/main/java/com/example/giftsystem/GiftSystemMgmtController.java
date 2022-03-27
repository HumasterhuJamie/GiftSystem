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

import com.example.giftsystem.beans.CusInfo;
import com.example.giftsystem.beans.CusOrderInfo;
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
	

}

package com.boxiang.weixin.sample.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.DateUtil;
import com.boxiang.weixin.utils.MD5Util;

@Controller
@RequestMapping("weixinPayment")
public class WeixinPaymentController {
	@Resource
	private String baseUrl;
	@RequestMapping("/getDataByScanOrMenu")
	public void getDataByScanOrMenu(
			@RequestParam(value="parkingId",required=false)  String parkingId,
			@RequestParam(value="customerId",required=false) String customerId,
			@RequestParam(value="type",required=false) String type,
			@RequestParam(value="carNumber",required=false) String carNumber,
			HttpServletRequest request,HttpServletResponse response){
		String Url="weixinPayment/getDataByScanOrMenu";
		String timestamp = DateUtil.date2str(new Date(), "yyyyMMddHHmmss");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("parkingId", parkingId);
		params.put("customerId", customerId);
		params.put("type", type);
		params.put("carNumber", carNumber);
		params.put("timestamp", timestamp);
		params.put("summary",MD5Util.originalSummary(params));
		/*String getMethodUrl = promoCode +"/"+ MD5Util.sign(promoCode, null, AppAPIUtil.DEF_CHATSET);*/
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");
		try {
			/*String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);*/
			String message=AppAPIUtil.net(baseUrl+Url, params, "POST",null);
			System.out.println(message);
			out=response.getWriter();
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	@RequestMapping("/getOrderData")
	public void getOrderData(
			@RequestParam(value="parkingId",required=true)  String parkingId,
			@RequestParam(value="customerId",required=false) String customerId,
			@RequestParam(value="orderType",required=false) String orderType,
			@RequestParam(value="carNumber",required=false) String carNumber,
			HttpServletRequest request,HttpServletResponse response){
		String Url="weixinPayment/getOrderData";
		String timestamp = DateUtil.date2str(new Date(), "yyyyMMddHHmmss");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("parkingId", parkingId);
		params.put("customerId", customerId);
		params.put("carNumber", carNumber);
		params.put("orderType", orderType);
		params.put("timestamp", timestamp);
		params.put("summary",MD5Util.originalSummary(params));
		/*String getMethodUrl = promoCode +"/"+ MD5Util.sign(promoCode, null, AppAPIUtil.DEF_CHATSET);*/
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");
		try {
			/*String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);*/
			String message=AppAPIUtil.net(baseUrl+Url, params, "POST",null);
			System.out.println(message);
			out=response.getWriter();
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	
}
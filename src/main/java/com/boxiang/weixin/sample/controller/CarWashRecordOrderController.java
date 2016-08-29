package com.boxiang.weixin.sample.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.MD5Util;

@Controller
@RequestMapping("Order")
public class CarWashRecordOrderController {
	@Resource
	private String baseUrl;
	@RequestMapping("/CarwashList/{customerId}/{orderStatus}/{pageIndex}")
	public void getCarwashList(@PathVariable String customerId,@PathVariable String orderStatus,@PathVariable String pageIndex,HttpServletRequest request,HttpServletResponse response){
		
		System.out.printf("getCarwashList" + customerId + orderStatus + pageIndex);
		String Url="order/carwashList";
		String getMethodUrl = customerId +"/"+ orderStatus +"/"+pageIndex +"/"+MD5Util.sign(customerId + orderStatus + pageIndex, null, AppAPIUtil.DEF_CHATSET);
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");
		try {
			String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);
			//String message=AppAPIUtil.net(baseUrl+Url, params, "POST",null);
			System.out.println(message);
			out=response.getWriter();
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	
	@RequestMapping("/Cancel/{orderId}/{orderType}")
	public void cancelCarwashList(@PathVariable String orderId,@PathVariable String orderType,HttpServletRequest request,HttpServletResponse response){
		
		System.out.printf("cancelCarwashList" + orderId + orderType);
		String Url="order/cancelOrder";
		String getMethodUrl = orderId +"/" +MD5Util.sign(orderId, null, AppAPIUtil.DEF_CHATSET);
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");
		try {
			String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);
			//String message=AppAPIUtil.net(baseUrl+Url, params, "POST",null);
			System.out.println(message);
			out=response.getWriter();
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}	
	
}

package com.boxiang.weixin.sample.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.MD5Util;

@Controller
@RequestMapping("/ReplaceOrder")
public class ReplaceOrderController {
	@Resource
	private String baseUrl;
	
	/**
	 * 查看订单列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("queryParkerById")
	public void queryParkerById(@RequestParam String customerId,@RequestParam(required=false) String carNumber,@RequestParam String version, HttpServletRequest request,HttpServletResponse response){
		String Url="parker/queryParkerById";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("customerId", customerId);
		params.put("carNumber",carNumber);
		params.put("version", version);
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
	
	/**
	 * 取消代泊
	 * @param orderId   订单的Id
	 * @param request
	 * @param response
	 */
	@RequestMapping("cancelOrder")
	public void cancelOrder(@RequestParam String orderId,HttpServletRequest request,HttpServletResponse response){
		String Url="order/cancelOrder";
		String getMethodUrl = orderId +"/"+ MD5Util.sign(orderId, null, AppAPIUtil.DEF_CHATSET);
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");		
		try {
			String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);	
			System.out.println(message);
			out=response.getWriter();
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 我要取车
	 * @param orderId    订单的Id
	 * @param version    版本号
	 * @param request
	 * @param response
	 */
	@RequestMapping("gettingCar")
	public void gettingCar(@RequestParam String orderId,@RequestParam String version,HttpServletRequest request,HttpServletResponse response){
		String Url="parker/gettingCar";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("orderId", orderId);
		params.put("version",version);
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

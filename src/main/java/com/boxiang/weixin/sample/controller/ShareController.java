package com.boxiang.weixin.sample.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.MD5Util;

@Controller
@RequestMapping("share")
public class ShareController {
	@Resource
	private String baseUrl;
	@RequestMapping("/getRedeem/{customerId}")
	public void getRedeem(@PathVariable String customerId,HttpServletRequest request,HttpServletResponse response){
		//String promoCode = request.getParameter("promoCode");
		//String encryptCode=request.getParameter("encryptCode");		
		String Url="customer/getRedeem";
		String getMethodUrl = customerId +"/"+ MD5Util.sign(customerId, null, AppAPIUtil.DEF_CHATSET);
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
	@RequestMapping("/receiveCouponByCount/{customerId}/{ruleId}")
	public void receiveCouponByCount(@PathVariable String customerId,@PathVariable String ruleId,HttpServletRequest request,HttpServletResponse response){
		String Url="customer/receiveCouponByCount"; 
		String getMethodUrl = customerId+"/"+ruleId +"/"+ MD5Util.sign(customerId+ruleId, null, AppAPIUtil.DEF_CHATSET);
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
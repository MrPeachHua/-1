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
@RequestMapping("Temporary")
public class TemporaryController {
	@Resource
	private String baseUrl;
	@RequestMapping("getCarList/{customerId}/{carNumber}")
	public void getCarList(@PathVariable String customerId,@PathVariable String carNumber,HttpServletRequest request,HttpServletResponse response){
		String Url="temporary/carlist/";
		String getMethodUrl = customerId+"/"+carNumber +"/"+ MD5Util.sign(customerId+carNumber, null, AppAPIUtil.DEF_CHATSET);
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
	
	/**
	 * 根据openId获取customeId
	 * @param openId
	 * @param code
	 * @param request
	 * @param response
	 */
	@RequestMapping("/postCustomerId/{openId}")
	public void postCustomerId(@PathVariable String openId,HttpServletRequest request,HttpServletResponse response){	
		String Url="customer/queryByOpenId";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("wxpayOpenid",openId);
		params.put("timestamp", "20160101");
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

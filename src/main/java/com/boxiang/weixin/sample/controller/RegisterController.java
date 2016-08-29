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
@RequestMapping("Register")
public class RegisterController {
	@Resource
	private String baseUrl;
	/**
	 * 注册接口
	 * @param phone
	 * @param paw
	 * @param code
	 * @param request
	 * @param response
	 */
	@RequestMapping("/postRegister/{phone}/{paw}/{code}/{openId}")
	public void postRegister(@PathVariable String phone,@PathVariable String paw,@PathVariable String code,@PathVariable String openId,HttpServletRequest request,HttpServletResponse response){
		//String promoCode = request.getParameter("promoCode");
		//String encryptCode=request.getParameter("encryptCode");		
		String Url="customer/register";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("customer_mobile",phone);
		params.put("customer_password", paw);
		params.put("wxpayOpenid", openId);
		params.put("smsCode",code);
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
	/**
	 * 获取验证码接口
	 */
	@RequestMapping("/sendSmsCode/{phone}")
	public void sendSmsCode(@PathVariable String phone,HttpServletRequest request,HttpServletResponse response){
		String Url="customer/sendSmsCode";
		String getMethodUrl = phone +"/"+ MD5Util.sign(phone, null, AppAPIUtil.DEF_CHATSET);
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
	 * 登录
	 */
	@RequestMapping("/postLogin/{phone}/{code}/{opendId}")
	public void postLogin(@PathVariable String phone,@PathVariable String code,@PathVariable String opendId,HttpServletRequest request,HttpServletResponse response){
		//String promoCode = request.getParameter("promoCode");
				//String encryptCode=request.getParameter("encryptCode");		
				String Url="customer/wxLogin";
				Map<String, Object> params=new HashMap<String, Object>();
				params.put("mobile",phone);
				params.put("code", code);
				params.put("wxpayOpenid",opendId);
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

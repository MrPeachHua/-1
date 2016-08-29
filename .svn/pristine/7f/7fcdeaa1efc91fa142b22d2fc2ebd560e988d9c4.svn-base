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
@RequestMapping("invitation")
public class InvitCredController {
	@Resource
	private String baseUrl;	
	
	
	/**
	 * 查看凭证
	 * @param id   凭证Id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/queryById/{id}")
	public void queryById(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
	
		String Url="invitation/queryById";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		params.put("version", "2.0.1");
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
	 * 添加车牌号
	 * @param id
	 * @param carNumber
	 * @param request
	 * @param response
	 */
	@RequestMapping("/update/{id}/{carNumber}")
	public void update(@PathVariable String id,@PathVariable String carNumber,HttpServletRequest request,HttpServletResponse response){
	
		String Url="invitation/update";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		params.put("carNumber",carNumber);
		params.put("version", "2.0.1");
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

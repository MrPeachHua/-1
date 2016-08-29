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
public class RentCarController {
	@Resource
	private String baseUrl;
	@RequestMapping("/rentCar")
	public void getMessage(HttpServletRequest request,HttpServletResponse response){
		String Url="carlife/carRent/list";
		String getMethodUrl = MD5Util.sign("", null, AppAPIUtil.DEF_CHATSET);
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


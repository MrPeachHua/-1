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
@RequestMapping("RedPacket")
public class RedPacketController {
	@Resource
	private String baseUrl;
	@RequestMapping("/getRedeemCode/{promoCode}")
	public void getRedeemCode(@PathVariable String promoCode,HttpServletRequest request,HttpServletResponse response){
		//String promoCode = request.getParameter("promoCode");
		//String encryptCode=request.getParameter("encryptCode");		
		String Url="customer/getRedeemCode";
		//Map<String, Object> params=new HashMap<String, Object>();
		//params.put("promoCode",promoCode);
		//params.put("encryptCode", encryptCode);
		//params.put("summary",MD5Util.sign(promoCode, null, AppAPIUtil.DEF_CHATSET));
		String getMethodUrl = promoCode +"/"+ MD5Util.sign(promoCode, null, AppAPIUtil.DEF_CHATSET);
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

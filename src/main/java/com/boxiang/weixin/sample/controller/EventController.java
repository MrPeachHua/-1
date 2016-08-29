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
public class EventController {
	@Resource
	private String baseUrl;
	@RequestMapping("/postQuestionnaire/{section_1}/{section_2}/{section_3}/{section_4}/{section_5}/{section_6}/{section_7}/{phone}/{neededService}/{channel}")
	public void getRedeem(@PathVariable String section_1,
			@PathVariable String section_2,
			@PathVariable String section_3,
			@PathVariable String section_4,
			@PathVariable String section_5,
			@PathVariable String section_6,
			@PathVariable String section_7,
			@PathVariable String phone,
			@PathVariable String neededService,
			@PathVariable String channel,
			HttpServletRequest request,HttpServletResponse response){
		//String promoCode = request.getParameter("promoCode");
		//String encryptCode=request.getParameter("encryptCode");		
		String Url="customer/postQuestionnaire";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("section_1", section_1);
		params.put("section_2", section_2);
		params.put("section_3", section_3);
		params.put("section_4", section_4);
		params.put("section_5", section_5);
		params.put("section_6", section_6);
		params.put("section_7", section_7);
		params.put("phone", phone);
		params.put("neededService", neededService);
		params.put("channel", channel);
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
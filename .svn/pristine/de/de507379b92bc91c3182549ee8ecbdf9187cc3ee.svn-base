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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.jsf.FacesContextUtils;

import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.MD5Util;

@Controller
@RequestMapping("daibo")
public class orderAssessController {
	@Resource
	private String baseUrl;
	@RequestMapping("/orderAssess")
	public void orderAssess(@RequestParam String customerId,@RequestParam String orderId,@RequestParam String commentType,@RequestParam String commentLevel,@RequestParam(required=false) String commentContent,HttpServletRequest request,HttpServletResponse response){
				
		System.out.println("customerId =" + customerId + "  orderId =" +  orderId + " commentType =" + commentType 
				+ " commentLevel=" + commentLevel + "  commentContent =" + commentContent);
		
				String Url="comment/commentc";
				Map<String, Object> params=new HashMap<String, Object>();
				params.put("customerId", customerId);
				params.put("orderId",orderId);
				params.put("commentType",commentType);
				params.put("commentLevel",commentLevel);
				if(commentContent == null)
				{
					commentContent = "";
				}
				params.put("commentContent",commentContent);
				params.put("timestamp", "20160101");
				params.put("summary",MD5Util.originalSummary(params));
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

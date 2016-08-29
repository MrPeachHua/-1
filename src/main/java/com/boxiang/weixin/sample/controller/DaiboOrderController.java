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
@RequestMapping("daibo")
public class DaiboOrderController {
	@Resource
	private String baseUrl;
	/**
	 * 代泊订单
	 * @param carNumber
	 * @param customerId
	 * @param version
	 * @param request
	 * @param response
	 */
	@RequestMapping("/queryParkerById/{customerId}/{version}")
	public void queryParkerById(@PathVariable String customerId,@PathVariable String version,HttpServletRequest request,HttpServletResponse response){
				
				String Url="parker/queryParkerById";
				Map<String, Object> params=new HashMap<String, Object>();
				params.put("customerId", customerId);
				params.put("version",version);
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

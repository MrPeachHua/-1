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

import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.MD5Util;

@Controller
@RequestMapping("Invit")
public class InvitController {
	@Resource
	private String baseUrl;	
	
	
	/**
	 * 查询业主信息
	 * @param customerId
	 * @param request
	 * @param response
	 */
	@RequestMapping("/queryVillageOwner/{customerId}")
	public void postRegister(@PathVariable String customerId,HttpServletRequest request,HttpServletResponse response){
	
		String Url="invitation/queryVillageOwner";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("customerId", customerId);
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
	 *  发起访客要请
	 * @param customerId
	 * @param inviteDate
	 * @param parkingId
	 * @param parkingName
	 * @param name
	 * @param mobile
	 * @param carNumber
	 * @param request
	 * @param response
	 */
	@RequestMapping("/add")
	public void orderAssess(@RequestParam String customerId,@RequestParam String inviteDate,@RequestParam String parkingId,
			@RequestParam String parkingName,@RequestParam(required =false) String name,
			@RequestParam String mobile,@RequestParam String carNumber,
			HttpServletRequest request,HttpServletResponse response){	
				String Url="invitation/add";
				Map<String, Object> params=new HashMap<String, Object>();
				params.put("customerId", customerId);
				params.put("inviteDate",inviteDate);
				params.put("parkingId",parkingId);
				params.put("parkingName",parkingName);		
				params.put("name",name);
				params.put("mobile",mobile);
				params.put("carNumber",carNumber);
				params.put("version","2.0.1");		
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
	
	/**
	 * 查询邀请历史
	 * @param customerId
	 * @param pageIndex
	 * @param pageSize
	 * @param request
	 * @param response
	 */
	@RequestMapping("/queryHistory/{customerId}/{pageIndex}/{pageSize}")
	public void queryHistory(@PathVariable String customerId,@PathVariable String pageIndex,@PathVariable String pageSize,HttpServletRequest request,HttpServletResponse response){
	
		String Url="invitation/queryHistory";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("customerId", customerId);
		params.put("pageIndex", pageIndex);
		params.put("pageSize", pageSize);
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

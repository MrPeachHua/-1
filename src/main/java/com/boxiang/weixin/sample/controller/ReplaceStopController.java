package com.boxiang.weixin.sample.controller;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.MD5Util;

@Controller
@RequestMapping("ReplaceStop")
public class ReplaceStopController {
	@Resource
	private String baseUrl;
	
	/**
	 * 获取可代泊的车场
	 * @param request
	 * @param response
	 */
	@RequestMapping("canParkList")
	public void canParkList(@RequestParam(required=false) String lng,@RequestParam(required=false) String  lat,HttpServletRequest request,HttpServletResponse response){
		String Url="parking/canParkList";
		String version=request.getParameter("version");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("lng", lng);
		params.put("lat", lat);
		params.put("version", version);
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
	 * 代泊获取预计费用
	 * @param parkingId   车场ID
 	 * @param startTime    开始时间
	 * @param endTime     结束时间
	 * @param version     版本号
	 * @param request
	 * @param response
	 * @throws ParseException 
	 */
	@RequestMapping(value="/calcParkPrice")
	public void calcParkPrice(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		String Url="parker/calcParkPrice";
		
		String parkingId=request.getParameter("parkingId");
		String startTime=request.getParameter("startTime");
		/*DateUtil.str2date(date, format)*/
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date=sdf.parse("2016-05-12 12:23");*/
		String endTime=request.getParameter("endTime");
		String version=request.getParameter("version");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("parkingId",parkingId);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("version",version);
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
	 * 创建代泊订单
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/orderc")
	public void getOrderC(HttpServletRequest request,HttpServletResponse response){
		String Url="order/orderc";
		String customerId=request.getParameter("customerId");
		String carNumber=request.getParameter("carNumber");
		String orderType=request.getParameter("orderType");
		String parkingId=request.getParameter("parkingId");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String isContinue=request.getParameter("isContinue");
		String version=request.getParameter("version");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("customerId", customerId);
		params.put("carNumber",carNumber);
		params.put("orderType", orderType);
		params.put("parkingId", parkingId);
		params.put("startTime",startTime);
		params.put("endTime", endTime);
		params.put("isContinue", isContinue);
		params.put("version", version);
	/*	params.put("timestamp", "20160101");*/
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

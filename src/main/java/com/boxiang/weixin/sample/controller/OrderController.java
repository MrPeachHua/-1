package com.boxiang.weixin.sample.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.DateUtil;
import com.boxiang.weixin.utils.MD5Util;

@Controller
@RequestMapping("order")
public class OrderController {
	@Resource
	private String baseUrl;
	@RequestMapping("/orderc")
	public void orderc(
			@RequestParam(value="parkingId",required=false)  String parkingId,
			@RequestParam(value="customerId",required=false) String customerId,
			@RequestParam(value="carNumber",required=false) String carNumber,
			@RequestParam(value="orderType",required=false) String orderType,
			@RequestParam(value="beginDate",required=false) String beginDate,
			@RequestParam(value="monthNum",required=false) String monthNum,
			@RequestParam(value="packageId",required=false) String packageId,
			@RequestParam(value="appointmentDate",required=false) String appointmentDate,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			/*String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);*/
			out=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		String Url="order/orderc";
		String timestamp = DateUtil.date2str(new Date(), "yyyyMMddHHmmss");
		Map<String, Object> params=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(beginDate)){
			Date bDate = DateUtil.str2date(beginDate.replace("/", "-"), "yyyy-MM-dd");
			Date nextMonth = DateUtil.getPreOrNextDate(bDate, 1);
			beginDate = DateUtil.date2str(nextMonth, "yyyy-MM-dd");
		}
		//临停
		if("11".equals(orderType)){
			params.put("parkingId", parkingId);
			params.put("customerId", customerId);
			params.put("carNumber", carNumber);
			params.put("orderType", orderType);
			params.put("timestamp", timestamp);
			params.put("summary",MD5Util.originalSummary(params));
		}else if("13".equals(orderType)){
			params.put("parkingId", parkingId);
			params.put("customerId", customerId);
			params.put("carNumber", carNumber);
			params.put("orderType", orderType);
			params.put("beginDate", beginDate);
			params.put("monthNum", monthNum);
			params.put("timestamp", timestamp);
			params.put("summary",MD5Util.originalSummary(params));
		}else if("14".equals(orderType)){
			params.put("parkingId", parkingId);
			params.put("customerId", customerId);
			params.put("carNumber", carNumber);
			params.put("orderType", orderType);
			params.put("beginDate", beginDate);
			params.put("monthNum", monthNum);
			params.put("timestamp", timestamp);
			params.put("summary",MD5Util.originalSummary(params));
		}else if("10".equals(orderType)){
			params.put("parkingId", parkingId);
			params.put("orderType", orderType);
			params.put("customerId", customerId);
			params.put("carNumber", carNumber);
			params.put("packageId", packageId);
			params.put("appointmentDate", appointmentDate);
			params.put("summary",MD5Util.originalSummary(params));
		}else{
			out.print("{\"errorInfo\":\"订单类型错误\",\"errorNum\":\"2\"}");
			return;
		}
		/*String getMethodUrl = promoCode +"/"+ MD5Util.sign(promoCode, null, AppAPIUtil.DEF_CHATSET);*/
		String message=AppAPIUtil.net(baseUrl+Url, params, "POST",null);
		System.out.println(message);
		out.print(message);
		
	}
	@RequestMapping("/myaccount/orderdetail")
	public void getDataByScanOrMenu(
			@RequestParam(value="orderId",required=false)  String orderId,
			@RequestParam(value="orderType",required=false) String orderType,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			/*String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);*/
			out=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		String Url="myaccount/orderdetail";
		String timestamp = DateUtil.date2str(new Date(), "yyyyMMddHHmmss");
		Map<String, Object> params=new HashMap<String, Object>();
	    //out.print("{\"errorInfo\":\"订单类型错误\",\"errorNum\":\"2\"}");
		String getMethodUrl = orderId +"/"+orderType+"/"+ MD5Util.sign(orderId+orderType, null, AppAPIUtil.DEF_CHATSET);
		String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);
		System.out.println(message);
		out.print(message);
		
	}
	@RequestMapping("/paidOrder")
	public void paidOrder(
			@RequestParam(value="orderId",required=false)  String orderId,
			@RequestParam(value="orderType",required=false) String orderType,
			@RequestParam(value="appointmentDate",required=false) String appointmentDate,
			@RequestParam(value="packageId",required=false) String packageId,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			/*String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);*/
			out=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		String Url="order/paidOrder";
		String timestamp = DateUtil.date2str(new Date(), "yyyyMMddHHmmss");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("orderId", orderId);
		params.put("orderType", orderType);
		params.put("appointmentDate", appointmentDate);
		params.put("packageId", packageId);
		params.put("timestamp", timestamp);
		params.put("summary",MD5Util.originalSummary(params));
		String message=AppAPIUtil.net(baseUrl+Url, params, "POST",null);
		System.out.println(message);
		out.print(message);
		
	}
	/**
	 * 查看凭证
	 * @param customerId
	 * @param voucherStatus
	 * @param pageIndex
	 * @param carNumber
	 * @param version
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/queryVoucherPage")
	public void queryVoucherPage(
			@RequestParam(value="customerId",required=false)  String customerId,
			@RequestParam(value="voucherStatus",required=false) String voucherStatus,
			@RequestParam(value="pageIndex",required=false) String pageIndex,
			@RequestParam(value="carNumber",required=false) String carNumber,
			@RequestParam(value="version",required=false) String version,
			@RequestParam(value="parkingId",required=false) String parkingId,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			/*String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);*/
			out=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		String Url="customer/queryVoucherPage";
		String timestamp = DateUtil.date2str(new Date(), "yyyyMMddHHmmss");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("customerId", customerId);
		params.put("voucherStatus", voucherStatus);
		params.put("pageIndex", pageIndex);
		params.put("carNumber", carNumber);
		params.put("version", version);
		params.put("parkingId", parkingId);
		params.put("timestamp", timestamp);
		params.put("summary",MD5Util.originalSummary(params));
		String message=AppAPIUtil.net(baseUrl+Url, params, "POST",null);
		System.out.println(message);
		out.print(message);
		
	}
	
	
}
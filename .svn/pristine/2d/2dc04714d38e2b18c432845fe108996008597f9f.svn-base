package com.boxiang.weixin.sample.controller;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.DateUtil;
import com.boxiang.weixin.utils.JacksonUtil;
import com.boxiang.weixin.utils.JsonMapper;
import com.boxiang.weixin.utils.MD5Util;

@Controller
@RequestMapping("parking")
public class ParkingController {
	@Resource
	private String baseUrl;
	/**
	 * 获取预约停车车场列表
	 * @param latitude
	 * @param longitude
	 * @param request
	 * @param response
	 */
	@RequestMapping("/carLov/getAppoPkList")
	public void getDataByScanOrMenu(
			@RequestParam(value="latitude",required=false)  String latitude,
			@RequestParam(value="longitude",required=false) String longitude,
			@RequestParam(value="pageSize",required=false) String pageSize,
			@RequestParam(value="pageIndex",required=false) String pageIndex,
			HttpServletRequest request,HttpServletResponse response){
		String Url="parking/carLov/getAppoPkList";
		String timestamp = DateUtil.date2str(new Date(), "yyyyMMddHHmmss");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("latitude", latitude);
		params.put("longitude", longitude);
		params.put("pageSize", pageSize);
		params.put("pageIndex", pageIndex);
		params.put("timestamp", timestamp);
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
	 * 获取预约停车时间段
	 * @param parkingId
	 * @param request
	 * @param response
	 */
	@RequestMapping("/reservedParking")
	public void reservedParking(
			@RequestParam  String version,
			@RequestParam String parkingId,
			HttpServletRequest request,HttpServletResponse response){
		String Url="parking/reservedParking";
		String timestamp = DateUtil.date2str(new Date(), "yyyyMMddHHmmss");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("version", version);
		params.put("parkingId", parkingId);
		params.put("timestamp", timestamp);
		params.put("summary",MD5Util.originalSummary(params));
		/*String getMethodUrl = promoCode +"/"+ MD5Util.sign(promoCode, null, AppAPIUtil.DEF_CHATSET);*/
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");
		try {
			/*String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);*/
			String message=AppAPIUtil.net(baseUrl+Url, params, "POST",null);
			try{
				Map<String,Object> map = (Map) JsonMapper.fromJson(message, Map.class);
				Map<String,Object> mapData = (Map<String, Object>) map.get("data");
				List<Map<String,Object>> dataList = (List<Map<String, Object>>) mapData.get("week");
				if(null!=dataList&&dataList.size()>0){
					for(Map<String,Object> m:dataList){
						String dayStr = "当日";
						 Date beginTimeDate = DateUtil.str2date(m.get("startTime").toString(), "HH:mm");
			             Date endTimeDate = DateUtil.str2date(m.get("endTime").toString(), "HH:mm");
			             if (beginTimeDate.getTime() > endTimeDate.getTime()) {//跨日
			            	 dayStr = "次日";
			             }
			             m.put("dayStr", dayStr);
					}
					
				}
				System.out.println(message);
				out=response.getWriter();
				out.print(JacksonUtil.toJson(map));
			}catch (Exception e) {
				out=response.getWriter();
				out.print(message);
				System.out.println(message);
			}		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	/**
	 * 获取预约停车时间段
	 * @param parkingId
	 * @param request
	 * @param response
	 */
	@RequestMapping("/choseWeek")
	public void choseWeek(
			@RequestParam  String version,
			@RequestParam String parkingId,
			@RequestParam String week,
			HttpServletRequest request,HttpServletResponse response){
		String Url="parking/choseWeek";
		String timestamp = DateUtil.date2str(new Date(), "yyyyMMddHHmmss");
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("version", version);
		params.put("parkingId", parkingId);
		params.put("week", week);
		params.put("timestamp", timestamp);
		params.put("summary",MD5Util.originalSummary(params));
		/*String getMethodUrl = promoCode +"/"+ MD5Util.sign(promoCode, null, AppAPIUtil.DEF_CHATSET);*/
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");
		try {
			/*String message=AppAPIUtil.net(baseUrl+Url, null, "GET",getMethodUrl);*/
			String message=AppAPIUtil.net(baseUrl+Url, params, "POST",null);
			Map<String,Object> map = (Map) JsonMapper.fromJson(message, Map.class);
			List<Map<String,Object>> dataList = (List<Map<String, Object>>) map.get("data");
			if(null!=dataList&&dataList.size()>0){
				for(Map<String,Object> m:dataList){
					if(null!=m.get("week")){
						String str = (String)m.get("week");
						String []strs = str.split("\\,");
						List<String>lis = Arrays.asList(strs);
						m.remove("week");
						m.put("week", lis);
					}
				}
			}
			System.out.println(JacksonUtil.toJson(map));
			out=response.getWriter();
			out.print(JacksonUtil.toJson(map));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	public static void main(String[] args) {
		
	}
	
	
}
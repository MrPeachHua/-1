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
@RequestMapping("CarButler")
public class CarButlerController {
	@Resource
	private String baseUrl;
	/**
	 * 获取车管家轮播图片
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getCarButlerImage")
	public void getRedeemCode(HttpServletRequest request,HttpServletResponse response){
		String Url="carlife/eventpage/list";
		String getMethodUrl =  MD5Util.sign("", null, AppAPIUtil.DEF_CHATSET);
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
	/**
	 * 获取车管家菜单列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getMenu")
	public void getMenu(HttpServletRequest request,HttpServletResponse response){
		String Url="carlife/srvinfo/list/";
		String getMethodUrl=MD5Util.sign("", null, AppAPIUtil.DEF_CHATSET);
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
	/**
	 * 根据经纬度获取附近的停车场
	 * @param lnt  精度
	 * @param lat  维度
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getNearPark/{lng:.+}/{lat:.+}")
	public void getNearPar(@PathVariable String lng,@PathVariable String lat,HttpServletRequest request,HttpServletResponse response) {
		String Url="parking/getIsParking";
		String getMethodUrl = lat+'/'+lng +"/"+ MD5Util.sign(lat+lng, null, AppAPIUtil.DEF_CHATSET);
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");
		try {
			String message=AppAPIUtil.net(baseUrl+Url,null, "GET", getMethodUrl);
			System.out.println(message);
			out=response.getWriter();
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 汽车内清洗、汽车打蜡、充电
	 * 获取服务简介  
	 * @param parking  停车场的Id
	 * @param srvId　　类别的Id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/serveInstruc/{parking}/{srvId}")
	public void serveInstruc(@PathVariable String parking,@PathVariable String srvId,HttpServletRequest request,HttpServletResponse response){
		String Url="carlife/srvinfo/intro";
		String getMethodUrl=parking+'/'+srvId+'/'+MD5Util.sign(parking+srvId, null, AppAPIUtil.DEF_CHATSET);
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");
		try {
			String message=AppAPIUtil.net(baseUrl+Url,null, "GET", getMethodUrl);
			System.out.println(message);
			out=response.getWriter();
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}

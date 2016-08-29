package com.boxiang.weixin.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.MD5Util;

@Controller
@RequestMapping("demo")
public class DemoController {
	@Resource
	private String baseUrl;
	
    @RequestMapping("/sample")@ResponseBody 
    public Map<String, String> sample(){
    	System.out.println("--------------------");
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("aaa", "111");
    	map.put("bbb", "222");
        return map;
    }
    
    @RequestMapping("/aaa")
    public void aaa(HttpServletRequest request,HttpServletResponse response){
        String url ="carlife/eventpage/list";//请求接口地址
        Map<String, Object> params = new HashMap<String, Object>();//请求参数
        params.put("summary",MD5Util.sign("", null,AppAPIUtil.DEF_CHATSET));
 
        PrintWriter out;
        response.setContentType("text/html;charset=UTF-8");
        try {
        	String message = AppAPIUtil.net(baseUrl+url, params, "GET",""); 
        	System.out.println(message);
            out = response.getWriter();
            out.print(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping("/bbb")
    public void bbb(HttpServletRequest request,HttpServletResponse response){
        String url ="parking/getlist";//请求接口地址
        Map<String, Object> params = new LinkedHashMap<String, Object>();//请求参数
        params.put("parkingCountry","");
        params.put("parkingProvince","");
        params.put("parkingCity","");
        params.put("parkingArea","");
        params.put("parkingName","恒积大厦");
        params.put("timestamp","20160413191415");
        params.put("summary",MD5Util.originalSummary(params));
 
        PrintWriter out;
        response.setContentType("text/html;charset=UTF-8");
        try {
        	String message = AppAPIUtil.net(baseUrl+url, params, "POST",null);       
            out = response.getWriter();
            out.print(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
}

package com.boxiang.weixin.sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boxiang.weixin.sample.po.Student;
import com.boxiang.weixin.utils.AppAPIUtil;
import com.boxiang.weixin.utils.JacksonUtil;
import com.boxiang.weixin.utils.MD5Util;
import com.boxiang.weixin.utils.wxPay.CommonUtil;
import com.boxiang.weixin.utils.wxPay.GetWxOrderno;
import com.boxiang.weixin.utils.wxPay.RequestHandler;
import com.boxiang.weixin.utils.wxPay.Sha1Util;
import com.boxiang.weixin.utils.wxPay.TenpayUtil;


@RestController
public class SampleController {
	
	@Resource
	private String baseUrl;

	/**
	 * 全局Json对象格式化测试：null-->""
	 * @return
	 */
    @RequestMapping("/sample")
    @ResponseBody 
    public Map<String, Object> sample(){
    	System.out.println("--------------------");
    	Student student = null;
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("aaa", "111");
    	map.put("bbb", "222");
    	map.put("ccc", student);
    	map.put("ddd", null);
    	Date e = new Date();
    	map.put("eee", e);
    	
        return map;
    }
	
    /**
     * Json对象格式化测试：Date
     * @return
     */
    @RequestMapping("/ccc")
    @ResponseBody 
    public Student ccc(){
    	Student student = new Student();
    	student.setStuId(1);
    	student.setStuName("小明");
    	student.setCreateDate(new Date());
        return student;
    }
    
    @RequestMapping("/aaa")
    public void aaa(HttpServletRequest request,HttpServletResponse response){
        String url ="carlife/eventpage/list";//请求接口地址
        Map<String, Object> params = new HashMap<String, Object>();//请求参数
        params.put("summary",MD5Util.sign("", null,AppAPIUtil.DEF_CHATSET));
        String getMethodUrl = MD5Util.sign("", null,AppAPIUtil.DEF_CHATSET);
        PrintWriter out;
        response.setContentType("text/html;charset=UTF-8");
        try {
        	String message = AppAPIUtil.net(baseUrl+url, params, "GET",getMethodUrl);       
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
    
 /*@RequestMapping("/wxPay")
    public void wxOauth(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        try {
            // http://服务器地址/mainServlet
            // 共账号及商户相关参数
            String appid = appId;
            String userId = String.valueOf(session.getAttribute("wxopenid"));
            String backUri = backUrl;
            // 授权后要跳转的链接所需的参数一般有会员号，金额，订单号之类，
            // 最好自己带上一个加密字符串将金额加上一个自定义的key用MD5签名或者自己写的签名,
            // 比如 Sign = %3D%2F%CS%
            String orderNo = req.getParameter("orderNo");
            String money = req.getParameter("money");
            money = "0.01";
            backUri = backUri + "?userId=" + userId + "&orderNo=" + orderNo + "&describe=test&money=" + money;
            // URLEncoder.encode 后可以在backUri 的url里面获取传递的所有参数
            backUri = URLEncoder.encode(backUri);
            // scope 参数视各自需求而定，这里用scope=snsapi_base
            // 不弹出授权页面直接授权目的只获取统一支付接口的openid
            String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=" + appid + "&redirect_uri=" + backUri + "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
            resp.sendRedirect(url);
        } catch (Exception e) {
        	
        }
    }*/
 
}


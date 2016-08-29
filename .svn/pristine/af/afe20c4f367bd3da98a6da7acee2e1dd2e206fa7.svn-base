package com.boxiang.weixin.sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boxiang.weixin.utils.JacksonUtil;
import com.boxiang.weixin.utils.wxPay.CommonUtil;
import com.boxiang.weixin.utils.wxPay.GetWxOrderno;
import com.boxiang.weixin.utils.wxPay.RequestHandler;
import com.boxiang.weixin.utils.wxPay.Sha1Util;
import com.boxiang.weixin.utils.wxPay.TenpayUtil;

@Controller
@RequestMapping("wxpay")
public class WxpayController {
	  private static final Logger logger = Logger.getLogger(WxpayController.class);
		
	@Resource
	private String baseUrl;
	@Resource
	private String appId;
	@Resource
	private String appSecret;
	@Resource
	private String partner;
	@Resource
	private String partnerKey;
	 //网页授权获取用户信息
    @SuppressWarnings("deprecation")  
    @RequestMapping("/getAuthor")

  	public void getUserInfo(HttpServletRequest request, HttpServletResponse response) {
  		//共账号及商户相关参数
  		String appid = appId;// "wx7e523b5f93fa911d";
  		//String userId = request.getParameter("userId");
  		String backUri = request.getParameter("backUri");
  		String orderNo = request.getParameter("orderNo");
  		String customerId = request.getParameter("customerId");
  		String type = request.getParameter("type");
  		//授权后要跳转的链接所需的参数一般有会员号，金额，订单号之类，
  		//最好自己带上一个加密字符串将金额加上一个自定义的key用MD5签名或者自己写的签名,
  		//比如 Sign = %3D%2F%CS% 
  		//String orderNo=appid+Sha1Util.getTimeStamp();
  		//backUri = backUri+"&orderNo="+orderNo+"&describe=test&customerId="+customerId;
  		backUri = backUri+"&customerId="+customerId+"&type="+type;
  		//URLEncoder.encode 后可以在backUri 的url里面获取传递的所有参数
  		backUri = URLEncoder.encode(backUri);
  		//scope 参数视各自需求而定，这里用scope=snsapi_base 不弹出授权页面直接授权目的只获取统一支付接口的openid
  		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
  				"appid=" + appid+
  				"&redirect_uri=" +
  				 backUri+
  				"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
  		logger.info("((((((((((((((((((((((((("+url);
  		
  		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			logger.info("",e);
		}
  	}
	@RequestMapping("/getCode")
  	public void getCode(HttpServletRequest request, HttpServletResponse response) {
  		//共账号及商户相关参数
  		String code = request.getParameter("code");
  		String type = request.getParameter("type");
  		String customerId = request.getParameter("customerId");
  		String directUrl = request.getParameter("directUrl");
  		logger.info("-------------code--------"+code);
  		logger.info("------------directUrl---------"+directUrl);
  		if(null==type){
  			type="boxiang";
  		}
  		try {
  			logger.info("==================(((((((("+directUrl+"&code="+code+"&customerId="+customerId);
  			response.sendRedirect(directUrl+"?code="+code+"&customerId="+customerId+"&type="+type);
			//response.sendRedirect("http://p-share.cn/wx_share/html5/temporaryTest.html?code="+code);
		} catch (IOException e) {
			logger.info("",e);
			e.printStackTrace();
		}
  	}
	@RequestMapping("/getOpenId")
	 public void getOpenId(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		/*String appid = "wx7e523b5f93fa911d";
		String appsecret = "6fd867cc4dd43bea3fc4c098fbc0c87b";
		String partner = "1264436501";
		String partnerkey = "1234567890sukenxzkhcnsjdhydfnjag";*/
		
		String appid = appId;
		String appsecret = appSecret;
		//String partner = partner;
		String partnerkey = partnerKey;
		String openId ="";
		//String openId ="oaBhPwWyhTL0J_QR_fJY0JhRyoak";
		String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code";
		
		JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
		logger.info(jsonObject+"-------------------------获取openId");
		if (null != jsonObject) {
			try {
				openId = jsonObject.getString("openid");
				logger.info("----------------------openId=="+openId);
			} catch (Exception e) {
				logger.info("openid错误",e);
			}
			
		}
		Map<String,Object> mp = new HashMap<String,Object>();
		mp.put("openId", openId);
		PrintWriter out;
	    response.setContentType("text/html;charset=UTF-8");
	    response.setHeader("Access-Control-Allow-Origin","*");
		try {      
            out = response.getWriter();
            out.print(JacksonUtil.toJson(mp));
        } catch (IOException e) {
           logger.info("",e);
        } catch (Exception e) {
           logger.info("",e);
		}
}
 @RequestMapping("/towxPay")
 public void towxPay(/*@RequestParam(value = "orderNo", defaultValue = "1") String orderNo,
		 @RequestParam(value = "money", defaultValue = "1") String money,
		 @RequestParam(value = "code", defaultValue = "1") String code,*/
		 HttpServletRequest request, HttpServletResponse response) {
	//网页授权后获取传递的参数
	/* String []orderNo1 = (String[]) request.getParameterMap().get("orderNo");
	String userId = request.getParameter("userId"); 	
	String orderNo = request.getParameter("orderNo"); 
	String money = request.getParameter("money");
	String code = request.getParameter("code");
	//money="1";
	logger.info("userId==========="+userId);
	logger.info("orderNo==========="+orderNo);
	logger.info("money==========="+money);
	logger.info("code==========="+code);*/
	 String []orderNo1 = (String[]) request.getParameterMap().get("orderNo");
		String []money1 = (String[]) request.getParameterMap().get("money");
		String []code1 = (String[]) request.getParameterMap().get("code");
		String []openId1 = (String[]) request.getParameterMap().get("openId");
		String []body1 = (String[]) request.getParameterMap().get("body");
		String []notify_url1 = (String[]) request.getParameterMap().get("notify_url");
		//String userId = request.getParameter("userId"); 
		logger.info(openId1[0]+"------------------------");
		/*if(orderNo1.length==0||money1.length==0||body1.length==0||notify_url1.length==0){
			Map<String,Object> pa = new HashMap<String,Object>();
			pa.put("erroNum", "2");
			pa.put("erroInfo", "参数错误");
			logger.info("参数错误");
			try {
				response.getWriter().print(JacksonUtil.toJson(pa));
			} catch (IOException e) {
				logger.info("",e);
			}
			return ;
		}*/
		logger.info("-----111111111-------------------");
		String orderNo = orderNo1[0];
		String money = money1[0];
		String body = body1[0];
		String notify_url = notify_url1[0];
		logger.info("-----222-------------------");
		String openId =openId1[0];
		logger.info("-----333-------------------"+openId1[0]);
	float fee = Float.parseFloat(money) * 100;
	int tf = (int) fee;
	money = String.valueOf(tf); // 订单总金额（分）
	//金额转化为分为单位
	float sessionmoney = Float.parseFloat(money);
	String finalmoney = String.format("%.2f", sessionmoney);
	finalmoney = finalmoney.replace(".", "");
	
	//商户相关资料 
	/*String appid = "wx7e523b5f93fa911d";
	String appsecret = "6fd867cc4dd43bea3fc4c098fbc0c87b";
	String partner = "1264436501";
	String partnerkey = "1234567890sukenxzkhcnsjdhydfnjag";*/
	logger.info("-----------------------------1111111");
	String appid = appId;
	String appsecret = appSecret;
	//String partner = partner;
	String partnerkey = partnerKey;
	
	//String openId ="oaBhPwWyhTL0J_QR_fJY0JhRyoak";
	/*String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code";
	
	JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
	logger.info(jsonObject+"-------------------------获取openId");
	if (null != jsonObject) {
		try {
			openId = jsonObject.getString("openid");
			logger.info("----------------------openId=="+openId);
		} catch (Exception e) {
			logger.info("openid错误",e);
		}
		
	}*/
	
	//获取openId后调用统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder
			String currTime = TenpayUtil.getCurrTime();
			//8位日期
			String strTime = currTime.substring(8, currTime.length());
			//四位随机数
			String strRandom = TenpayUtil.buildRandom(4) + "";
			//10位序列号,可以自行调整。
			String strReq = strTime + strRandom;
			
			
			//商户号
			String mch_id = partner;
			//子商户号  非必输
			//String sub_mch_id="";
			//设备号   非必输
			//String device_info="";
			//随机数 
			String nonce_str = strReq;
			//商品描述
			//String body = describe;
			
			//商品描述根据情况修改
			//String body = "美食";
			//附加数据
			String attach = "test";
			//商户订单号
			String out_trade_no = orderNo;
			//int intMoney = Integer.parseInt(finalmoney);
			
			//总金额以分为单位，不带小数点
			//int total_fee = intMoney;
			//订单生成的机器 IP
			String spbill_create_ip = request.getRemoteAddr();
			//订 单 生 成 时 间   非必输
	//					String time_start ="";
			//订单失效时间      非必输
	//					String time_expire = "";
			//商品标记   非必输
	//					String goods_tag = "";
			
			//这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
			//String notify_url =request.getParameter("notify_url");
			//String notify_url ="http://p-share.cn/p_share_weixin/";
			
			String trade_type = "JSAPI";
			String openid = openId;
			//非必输
	//					String product_id = "";
			SortedMap<String, String> packageParams = new TreeMap<String, String>();
			packageParams.put("appid", appid);  
			packageParams.put("mch_id", mch_id);  
			packageParams.put("nonce_str", nonce_str);  
			packageParams.put("body", body);  
			packageParams.put("attach", attach);  
			packageParams.put("out_trade_no", out_trade_no);  
			
			
			//这里写的金额为1 分到时修改
			packageParams.put("total_fee", money);  
	//					packageParams.put("total_fee", "finalmoney");  
			packageParams.put("spbill_create_ip", spbill_create_ip);  
			packageParams.put("notify_url", notify_url);  
			
			packageParams.put("trade_type", trade_type);  
			packageParams.put("openid", openid);  
	
			RequestHandler reqHandler = new RequestHandler(request, response);
			reqHandler.init(appid, appsecret, partnerkey);
			logger.info("-----------------------------2222222222222222222");
			String sign = reqHandler.createSign(packageParams);
			String xml="<xml>"+
					"<appid>"+appid+"</appid>"+
					"<mch_id>"+mch_id+"</mch_id>"+
					"<nonce_str>"+nonce_str+"</nonce_str>"+
					"<sign>"+sign+"</sign>"+
					"<body><![CDATA["+body+"]]></body>"+
					"<attach>"+attach+"</attach>"+
					"<out_trade_no>"+out_trade_no+"</out_trade_no>"+
					//金额，这里写的1 分到时修改
					"<total_fee>"+money+"</total_fee>"+
					//"<total_fee>"+finalmoney+"</total_fee>"+
					"<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"+
					"<notify_url>"+notify_url+"</notify_url>"+
					"<trade_type>"+trade_type+"</trade_type>"+
					"<openid>"+openid+"</openid>"+
					"</xml>";
			System.out.println(xml);
			/*String allParameters = "";
			try {
				allParameters =  reqHandler.genPackage(packageParams);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
			String prepay_id="";
			try {
				prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);
				if(prepay_id.equals("")){
					request.setAttribute("ErrorMsg", "统一支付接口获取预支付订单出错");
					//response.sendRedirect("error.jsp");
				}
			} catch (Exception e1) {
				logger.info("e1",e1);
			}
			SortedMap<String, String> finalpackage = new TreeMap<String, String>();
			String appid2 = appid;
			String timestamp = Sha1Util.getTimeStamp();
			
			
			String nonceStr2 = nonce_str;
			String prepay_id2 = "prepay_id="+prepay_id;
			String packages = prepay_id2;
			finalpackage.put("appId", appid2);  
			finalpackage.put("timeStamp", timestamp);  
			finalpackage.put("nonceStr", nonceStr2);  
			finalpackage.put("package", packages);  
			finalpackage.put("signType", "MD5");
			String finalsign = reqHandler.createSign(finalpackage);
			finalpackage.put("sign", finalsign);
			System.out.println("pay.jsp?appid="+appid2+"&timeStamp="+timestamp+"&nonceStr="+nonceStr2+"&package="+packages+"&sign="+finalsign);
			//response.sendRedirect("pay.jsp?appid="+appid2+"&timeStamp="+timestamp+"&nonceStr="+nonceStr2+"&package="+packages+"&sign="+finalsign);
			PrintWriter out;
		    response.setContentType("text/html;charset=UTF-8");
		    response.setHeader("Access-Control-Allow-Origin","*");
			try {      
	            out = response.getWriter();
	            out.print(JacksonUtil.toJson(finalpackage));
	        } catch (IOException e) {
	           logger.info("",e);
	        } catch (Exception e) {
	           logger.info("",e);
			}
}
 @RequestMapping("/back_10")
 public void back_10(HttpServletRequest request, HttpServletResponse response) {
	 String str = request.getParameter("str");
	 String code = request.getParameter("code");
		String appid = appId;
		String appsecret = appSecret;
		String partnerkey = partnerKey;
		String openId ="";
		String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code";
		JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
		logger.info(jsonObject+"-------------------------获取openId");
		if (null != jsonObject) {
			try {
				openId = jsonObject.getString("openid");
				logger.info("----------------------openId=="+openId);
			} catch (Exception e) {
				logger.info("openid错误",e);
			}
			
		}
	 logger.info("------------回调回调");
	 logger.info("------------回调回调");
	 logger.info("------------回调回调");
	 logger.info("------------回调回调");
	 logger.info("------------回调回调");
 }
 //网页授权获取用户信息
 @SuppressWarnings("deprecation")  
 @RequestMapping("/getCodeTest")

	public void getCodeTest(HttpServletRequest request, HttpServletResponse response) {
		//共账号及商户相关参数
		String appid = appId;// "wx7e523b5f93fa911d";
		String backUri = request.getParameter("backUri");
		String orderNo = request.getParameter("orderNo");
		String customerId = request.getParameter("customerId");
		//backUri = backUri+"&customerId="+customerId;
		logger.info("backUri========="+backUri);
		backUri = URLEncoder.encode(backUri);
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
				"appid=" + appid+
				"&redirect_uri=" +
				 backUri+
				"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			logger.info("",e);
		}
	}
 @RequestMapping("/back_11.html")
 public void back_11(HttpServletRequest request, HttpServletResponse response) {
	 String code = request.getParameter("code");
	 String appid = appId;
		String appsecret = appSecret;
		//String partner = partner;
		String partnerkey = partnerKey;
		String openId ="";
		//String openId ="oaBhPwWyhTL0J_QR_fJY0JhRyoak";
		String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code";
		
		JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
		logger.info(jsonObject+"-------------------------获取openId");
		if (null != jsonObject) {
			try {
				openId = jsonObject.getString("openid");
				logger.info("----------------------openId=="+openId);
			} catch (Exception e) {
				logger.info("openid错误",e);
			}
			
		}
		String url = "http://www.p-share.com/wx_share/html5/temporaryTest.html?openId="+openId;
		 logger.info("url------------"+url);
		 logger.info("------------codetest11111111");
		 logger.info("code------------"+code);
		 logger.info("code------------"+code);
		 logger.info("code------------"+code);
		 try {
			response.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	
	 
	 

 }
 /**
  * 微信sdk支付
  */
 @RequestMapping("/getWxConfig")
 public void getWxConfig(HttpServletRequest request, HttpServletResponse response) {
	 String appid = appId;
	 String timestamp = Long.toString(System.currentTimeMillis() / 1000);
	 String currTime = TenpayUtil.getCurrTime();
	 //8位日期
	 String strTime = Sha1Util.getTimeStamp();//currTime.substring(8, currTime.length());
	 //四位随机数
	 String strRandom = TenpayUtil.buildRandom(4) + "";
	 //10位序列号,可以自行调整。
	 String nonceStr = strTime + strRandom;
	 SortedMap<String, String> packageParams = new TreeMap<String, String>();
	 
	 packageParams.put("appId", appid);
	 packageParams.put("timestamp", timestamp);
	 packageParams.put("nonceStr", nonceStr);
	 RequestHandler reqHandler = new RequestHandler(request, response);
	 String signature = reqHandler.createSign(packageParams);
	 packageParams.put("signature", signature);
	 PrintWriter out;
	    response.setContentType("text/html;charset=UTF-8");
	    response.setHeader("Access-Control-Allow-Origin","*");
		try {      
         out = response.getWriter();
         out.print(JacksonUtil.toJson(packageParams));
     } catch (IOException e) {
        logger.info("",e);
     } catch (Exception e) {
        logger.info("",e);
		}
	 

 }
 
 @RequestMapping("/getWxReady")
 public void getWxReady(HttpServletRequest request, HttpServletResponse response) {
	 String []orderNo1 = (String[]) request.getParameterMap().get("orderNo");
		String []money1 = (String[]) request.getParameterMap().get("money");
		String []code1 = (String[]) request.getParameterMap().get("code");
		String []openId1 = (String[]) request.getParameterMap().get("openId");
		String []body1 = (String[]) request.getParameterMap().get("body");
		String []notify_url1 = (String[]) request.getParameterMap().get("notify_url");
	 

 }
}

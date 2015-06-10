//package com.netease.user;
//import java.io.IOException;  
//import java.util.ArrayList;  
//import java.util.List;  
//  
//
//
//
//import org.apache.http.Header;
//import org.apache.http.HttpResponse;  
//import org.apache.http.NameValuePair;  
//import org.apache.http.client.HttpClient;  
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;  
//import org.apache.http.impl.client.DefaultHttpClient;  
//import org.apache.http.message.BasicNameValuePair;
//  
//public class GetCookie {  
//
//    public String login() throws IOException {  
//          
//        //核心应用类   
//        HttpClient httpClient = new DefaultHttpClient();  
//          
//        //设定表单需要提交的参数  
//        List<NameValuePair> qparams = new ArrayList<NameValuePair>();  
//        //提交用户名和密码  
//        qparams.add(new BasicNameValuePair("username", "testgentie0003@163.com"));  
//        qparams.add(new BasicNameValuePair("password", "2wsx3edc")); 
//        qparams.add(new BasicNameValuePair("type", "1")); 
//          
//        HttpPost httpPost = new HttpPost("https://reg.163.com:443/logins.jsp");  
//        httpPost.setEntity(new UrlEncodedFormEntity(qparams,"utf-8"));
//        //httpClient执行，返回response  
//        HttpResponse response = httpClient.execute(httpPost);  
//        // 从头中取出cookie
//        Header locationHeader = response.getFirstHeader("Set-Cookie");
////         System.out.println(locationHeader);
//        String  lh = locationHeader.toString(); 
//        return lh;
//}  
//    public String getCookie(){
//    	GetCookie gtc = new GetCookie();
//    	try{
//    	 String test = gtc.login();
//    	 int i1=test.indexOf("");
//    	 int i2=test.indexOf("; path=/;");
//    	 String cookie = test.substring((i1+22),i2);
//    	 System.out.println(cookie);
//    	 return cookie;
//    	}catch (Exception e) {  
//            throw new RuntimeException(e);  
//        }
//    	
//    }
//}
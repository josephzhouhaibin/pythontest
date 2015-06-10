package com.netease.util;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpRequest { 
	  private boolean result;
	  public String entitystring;
	  public String code;
      public boolean httpGetRequest(String uri){
    	//创建HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
//	    GetCookie getcookie = new GetCookie();
        //HttpClient  
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build(); 
        HttpGet httpGet = new HttpGet(uri);
        System.out.println(httpGet.getRequestLine());  
//        System.out.println(getcookie.getCookie());
        try{
  	      //设置header
//            httpGet.setHeader("Cookie","NTES_SESS="+getcookie.getCookie());
            httpGet.setHeader("Cookie","NTES_SESS=ZWOHPsyXlXqI2t97eodZP7vOmN.t9qH.FxIYogVARfc.lwr82lQrsyVk..MqmUXPACscANJdx.K47n9WnNMGtcuGxatnNf1HGNoIsJ8MLyISou2K2XSREdC1sgAhXmnWMda82C4.2U82StuRcK30HSgZyy65EvFCW;");
            httpGet.setHeader("App-Key","eecc698764a1403d846bef6f9a01d90d");
            httpGet.setHeader("Content-Type","application/json");
//            httpGet.setHeader("Domain","qa.gentie.163.com");
        //执行get请求  
        HttpResponse httpResponse = closeableHttpClient.execute(httpGet);  
        //获取响应消息实体  
        HttpEntity entity = httpResponse.getEntity();  
        //响应状态  
        int statuscode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("status:" + statuscode);
        //获取响应body
         entitystring = EntityUtils.toString(entity);
         ReturnCheck rc = new ReturnCheck();
         result = rc.returnCheck(statuscode, entitystring, code);
        }catch(IOException e){
        	e.printStackTrace(); 
        }finally {  
            try {  
                //关闭流并释放资源  
                closeableHttpClient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }
        return result;
    }
      public boolean httpPostRequest(String uri){
      	//创建HttpClientBuilder  
          HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
//          GetCookie getcookie = new GetCookie();
          //HttpClient  
          CloseableHttpClient closeableHttpClient = httpClientBuilder.build(); 
          HttpPost httpPost = new HttpPost(uri);
//        System.out.println(httpGet.getRequestLine());  
          try{
      	      //设置header
//        	  httpPost.setHeader("Cookie","NTES_SESS="+getcookie.getCookie());
              httpPost.setHeader("Cookie","NTES_SESS=ZWOHPsyXlXqI2t97eodZP7vOmN.t9qH.FxIYogVARfc.lwr82lQrsyVk..MqmUXPACscANJdx.K47n9WnNMGtcuGxatnNf1HGNoIsJ8MLyISou2K2XSREdC1sgAhXmnWMda82C4.2U82StuRcK30HSgZyy65EvFCW;");
        	  httpPost.setHeader("App-Key","eecc698764a1403d846bef6f9a01d90d");
        	  httpPost.setHeader("Content-Type","application/json");
//              httpGet.setHeader("Domain","qa.gentie.163.com");
          //执行get请求  
          HttpResponse httpResponse = closeableHttpClient.execute(httpPost);  
          //获取响应消息实体  
          HttpEntity entity = httpResponse.getEntity();  
          //响应状态  
          int statuscode = httpResponse.getStatusLine().getStatusCode();
          System.out.println("status:" + statuscode);
          //获取响应body
           entitystring = EntityUtils.toString(entity);
//           System.out.println("ReturnBody="+entitystring);
           ReturnCheck rc = new ReturnCheck();
           result = rc.returnCheck(statuscode, entitystring, code);
          }catch(IOException e){
          	e.printStackTrace(); 
          }finally {  
              try {  
                  //关闭流并释放资源  
                  closeableHttpClient.close();  
              } catch (IOException e) {  
                  e.printStackTrace();  
              }  
          }
          return result;
      }
}

package com.netease.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class ThreadPostRequest {
	  public String entitystring;
	  public String code;
	  private boolean result;
	  public boolean threadRequest(String uri,String url,String title,String docid,boolean app,boolean web,boolean against,boolean audio,String requesttype,String expectcode){ 
		  	   GetJson gj = new GetJson();
	   	       String obj = gj.getJson(url,title,docid,app,web,against,audio).toString();
	   	       System.out.println(obj);
			   GetAppSignature gas =new GetAppSignature ();
			   String md5 = gas.getMd5(obj);
			   String date = gas.date;
			   
			  //创建HttpClientBuilder  
		      HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
		      //HttpClient  
		      CloseableHttpClient closeableHttpClient = httpClientBuilder.build(); 
		      HttpPost post = new HttpPost(uri);  
		      try {
	           StringEntity s = new StringEntity(obj);  
	           s.setContentEncoding("UTF-8");  
	           s.setContentType("application/json");  
	           post.setEntity(s);  
	           post.addHeader("x-gt-appkey", "eecc698764a1403d846bef6f9a01d90d");
	           post.addHeader("x-gt-domain", "qa.gentie.163.com");
	           post.addHeader("x-gt-date",date);
	           post.addHeader("x-gt-contentmd5", md5);
	           post.addHeader("x-gt-signature", gas.getAppsignture("eecc698764a1403d846bef6f9a01d90d", "51152fc76d8a4fb1b3230e1af549f0ff", "qa.gentie.163.com", requesttype, uri.substring(26), obj));
	           HttpResponse res = closeableHttpClient.execute(post); 
	           HttpEntity entity = res.getEntity();  
	           String entitystring = EntityUtils.toString(entity);
	           System.out.println("status="+res.getStatusLine().getStatusCode());
	           //响应状态  
	           int statuscode = res.getStatusLine().getStatusCode();
	           ReturnCheck rc = new ReturnCheck();
	           result = rc.returnCheck(statuscode, entitystring, code);
		      }catch (Exception e) {  
	               throw new RuntimeException(e);  
	           }
	   	      finally {  
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

package com.netease.debug;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import com.netease.util.HttpRequest;
import com.netease.util.ThreadPostRequest;

public class Debug{
  @Test(dataProvider = "dp") 
  public void queryThread(String threadid,String productkey,int code) {
	//创建HttpClientBuilder  
      HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
      //HttpClient  
      CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  
      HttpGet httpGet = new HttpGet("http://gentie.163.com:8181/api/v1/products/"+productkey+"/threads/"+threadid);
//      System.out.println(httpGet.getRequestLine());  
      try {  
          //执行get请求  
          HttpResponse httpResponse = closeableHttpClient.execute(httpGet);  
          //获取响应消息实体  
          HttpEntity entity = httpResponse.getEntity();  
          byte[] js= EntityUtils.toByteArray(entity);
          //响应状态  
          System.out.println("status:" + httpResponse.getStatusLine().getStatusCode());
          //转换响应
          String entitystring = EntityUtils.toString(entity);
          NewTest nt = new NewTest();
          nt.jsonEquals(entitystring, j2)
      	try{
  			if ( httpResponse.getStatusLine().getStatusCode() == 200) {
  				Assert.assertEquals(200, code);	
  				Assert.assertNotNull(entity);
  				Assert.assertEquals(entitystring.contains("docid"),true);
                System.out.println("response content:" + entitystring);
  			}else if( httpResponse.getStatusLine().getStatusCode() == 404){
  				System.out.println("response content:" + entitystring);
  				Assert.assertEquals(404, code);
  			}else{
          	   Assert.assertEquals(false,true);
          	   System.out.println(entitystring);
          }
  		}catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}	
      } catch (IOException e) {  
          e.printStackTrace();  
      } finally {  
          try {  
          //关闭流并释放资源  
          closeableHttpClient.close();  
      } catch (IOException e) {  
          e.printStackTrace();  
      }  
  }  
  }
//
  @DataProvider(name = "dp") 
  public Object[][] dp() {
	return new Object[][] {
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d",200},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d",200},
    };
  }	
	
  public static void main(String args[]){
	  
  }	   
}

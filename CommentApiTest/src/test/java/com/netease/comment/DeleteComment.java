package com.netease.comment;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netease.util.ReturnCheck;

public class DeleteComment {
	@Test(dataProvider="dp")
	 public void deleteComment(String productid,String threadid,String commentid,boolean status,int code){
		String uri = "http://gentie.163.com:8181/api/v1//products/"+productid+"/threads/"+threadid+"/comments/"+commentid;
	    JSONObject obj = new JSONObject();
	    String s1= obj.put("isDel",status).toString();
	    //创建HttpClientBuilder  
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        //HttpClient  
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build(); 
        HttpPut put = new HttpPut(uri);  
      try {
          StringEntity s = new StringEntity(s1);  
          s.setContentEncoding("UTF-8");  
          s.setContentType("application/json");  
          put.setEntity(s); 
          HttpResponse res = closeableHttpClient.execute(put); 
//          HttpEntity entity = res.getEntity();  
//          String entitystring = EntityUtils.toString(entity);
          int statuscode = res.getStatusLine().getStatusCode();
          if(statuscode == 204){
//        	  System.out.println(entitystring);
        	  Assert.assertEquals(statuscode,code);
          }else if(statuscode == 404)
          {
//        	  System.out.println(entitystring);
        	  Assert.assertEquals(statuscode,code);
          }else{
//        	  System.out.println(entitystring);
        	  Assert.assertEquals(statuscode,403);
          }
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
	}
	 @DataProvider(name = "dp") 
			  public Object[][] dp() {
				return new Object[][] {
						  //正常请求
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D","230218",false,204},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D","230218",true,204},
						 new Object[]{"","A014A5A11001768D","230218",false,404},
						 new Object[]{"wrongproduct","A014A5A11001768D","230218",false,404},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","","230218",false,404},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","wrongthreadid","230218",false,404},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D","",false,404},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D","1",false,404},
						 new Object[]{"","A014A5A11001768D","230218",true,404},
						 new Object[]{"wrongproduct","A014A5A11001768D","230218",true,404},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","","230218",true,404},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","wrongthreadid","230218",true,404},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D","",true,404},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D","1",true,404},
						 
				};
	 }
}	 

package com.netease.comment;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.netease.util.ReturnCheck;

public class CreateComment {
	  private boolean result;
	  public String entitystring;
	@Test(dataProvider="dp")
	 public void createComment(String productid,String threadid,boolean anonymous,String content,String parentId,String imageUrl,String ext,String code){
		String uri = "http://gentie.163.com:8181/api/v1/products/"+productid+"/threads/"+threadid+"/comments";
	    JSONObject obj = new JSONObject();
	    String s1= obj.put("content",content).put("parentId",parentId).put("anonymous",anonymous).put("imageUrl",imageUrl).put("ext",ext).toString();
	    //创建HttpClientBuilder  
       HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
       //HttpClient  
       CloseableHttpClient closeableHttpClient = httpClientBuilder.build(); 
       HttpPost post = new HttpPost(uri);   
     try {
         StringEntity s = new StringEntity(s1);  
         s.setContentEncoding("UTF-8");  
         s.setContentType("application/json");  
         post.setEntity(s); 
 	      //设置header
         post.setHeader("Cookie","NTES_SESS=sU3ItjYbDr_lRdC66Dx_LVHxm8C6RlgtWL.mJprwyYbF8g50H8O5Nur1FFQBkPhCwBhORIpJ_mGsc7iS7vQ_Vbz_LRV7vYoK_vJ.NM0Qeu.aJzH4HhayDAloNpwnhk7SQAR0Hl3FHP0HaVzyb4ZTKapsuujfDdUlS;");
//         httpGet.setHeader("Cookie","NTES_SESS=ZWOHPsyXlXqI2t97eodZP7vOmN.t9qH.FxIYogVARfc.lwr82lQrsyVk..MqmUXPACscANJdx.K47n9WnNMGtcuGxatnNf1HGNoIsJ8MLyISou2K2XSREdC1sgAhXmnWMda82C4.2U82StuRcK30HSgZyy65EvFCW;");
         post.setHeader("App-Key","eecc698764a1403d846bef6f9a01d90d");
         post.setHeader("Content-Type","application/json");
//         httpGet.setHeader("Domain","qa.gentie.163.com");
         HttpResponse res = closeableHttpClient.execute(post); 
         //获取响应消息实体  
         HttpEntity entity = res.getEntity(); 
         int statuscode = res.getStatusLine().getStatusCode();
         //获取响应body
         entitystring = EntityUtils.toString(entity);
         ReturnCheck rc = new ReturnCheck();
         result = rc.returnCheck(statuscode, entitystring, code);
         } catch (IOException e) {  
                 e.printStackTrace();  
             }  
 	      }
	
	 @DataProvider(name = "dp") 
			  public Object[][] dp() {
				return new Object[][] {
						  //正常请求
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"contenttest1","230218","imageurlaaaa","extsssssssss","201"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"contenttest2","0","imageurlaaaa","extsssssssss","201"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",true,"contenttest3","230218","imageurlaaaa","extsssssssss","201"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",true,"contenttest3","12345","imageurlaaaa","extsssssssss","404"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",true,"contenttest3","ADBF","imageurlaaaa","extsssssssss","400"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"","230218","imageurlaaaa","extsssssssss","422"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"contenttest2","0","","extsssssssss","201"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",true,"contenttest3","230218","imageurlaaaa","","201"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"中文","230218","imageurlaaaa","extsssssssss","201"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"contenttest2","0","中文","extsssssssss","201"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",true,"contenttest3","230218","imageurlaaaa","中文","201"},
//						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"！@＃¥％……&＊（）》《？：“｝｜!@#$%^&*()_+}{:?>><","153697","imageurlaaaa","extsssssssss","201"},
//						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"contenttest2","0","！@＃¥％……&＊（）》《？：“｝｜!@#$%^&*()_+}{:?>><","extsssssssss","201"},
//						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",true,"contenttest3","153697","imageurlaaaa","！@＃¥％……&＊（）》《？：“｝｜!@#$%^&*()_+}{:?>><","201"},
//						 //边界值测试
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试","230218","imageurlaaaa","extsssssssss","201"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"contenttest","230218","urlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlte","extsssssssss","201"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"contenttest","230218","imageurlaaaa","extsssssssssextsssssssss","201"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"contenttest","230218","imageurlaaaa","extsssssssss","201"},
						 //超过边界值
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"1一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试一千字测试","230218","imageurlaaaa","extsssssssss","422"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"contenttest","230218","1urlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlteurlte","extsssssssss","422"},
						 new Object[]{"eecc698764a1403d846bef6f9a01d90d","A014A5A11001768D",false,"contenttest","230218","imageurlaaaa","1extaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaaextaa","422"},
						 
						 
						 
						 
				};
	 }
}	 

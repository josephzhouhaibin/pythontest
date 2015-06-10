package com.netease.comment;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.netease.util.HttpRequest;

public class QueryComment {
	  @Test(dataProvider = "dp") 
	  public void queryComment(String threadid,String productkey,String expectcode,String comments) {
		  String uri;
		  	 uri = "http://gentie.163.com:8181/api/v1//products/"+productkey+"/threads/"+threadid+"/comments/"+comments;
		  	 HttpRequest hgr = new HttpRequest();
		  	 hgr.code = expectcode;
			 boolean result = hgr.httpGetRequest(uri);
			 Assert.assertEquals(true,result);
	  }
  @DataProvider(name = "dp") 
  public Object[][] dp() {
	return new Object[][] {
			 //正确的请求
		      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200","230218"},
				 //跟贴id格式错误
		      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422","ABC"},
		      //主贴id为空
		      new Object[]{ "", "eecc698764a1403d846bef6f9a01d90d","404","230218"},
		      //主贴id不存在
		      new Object[]{ "A014A5A1", "eecc698764a1403d846bef6f9a01d90d","404","230218"},
		      //key为空
		      new Object[]{ "A014A5A11001768D", "","404","230218"},
		      //key错误
		      new Object[]{ "A014A5A11001768D", "e98764a1403d846bef6f9a01d90d","404","230218"},
		      //跟贴id为空
		      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","404",""},
		      //跟贴不存在
		      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","404","17"},
		      //主贴关闭，需要调试
		      new Object[]{ "B014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","404","230218"}  
    };
  }
}

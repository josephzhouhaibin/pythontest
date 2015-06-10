package com.netease.thread;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import com.netease.util.HttpRequest;

public class QueryThread{
	 @Test(dataProvider="dp")
	 public void queryThread(String threadid,String productkey,String expectcode){
		 String uri;
		 uri = "http://gentie.163.com:8181/api/v1/products/"+productkey+"/threads/"+threadid;
		 HttpRequest hgr = new HttpRequest();
		 hgr.code = expectcode;
		 boolean result = hgr.httpGetRequest(uri);
		  Assert.assertEquals(true,result);
	 }
  @DataProvider(name = "dp") 
  public Object[][] dp() {
	return new Object[][] {
      new Object[]{ "C4C4A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","404"},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200"},
      new Object[]{ "11", "wrongproduct","404"},
      new Object[]{ "", "eecc698764a1403d846bef6f9a01d90d","404"},
      new Object[]{ "A014A5A11001768", "eecc698764a1403d846bef6f9a01d90d","404"},
      new Object[]{ "A014A5A11001768", "","404"}
    };
  }
  @BeforeTest
  public void beforeTest() {
  }
}

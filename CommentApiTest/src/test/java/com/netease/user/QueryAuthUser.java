package com.netease.user;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netease.util.HttpRequest;

public class QueryAuthUser {
	  @Test(dataProvider = "dp") 
	  public void queryAuthUser(String productkey,String expectcode) {
		  String uri;
		  uri = "http://gentie.163.com:8181/api/v1/products/"+productkey+"/users";
		  HttpRequest hgr = new HttpRequest();
	      hgr.code = expectcode;
	      boolean result = hgr.httpGetRequest(uri);
		  Assert.assertEquals(true,result);
	  }
	  @DataProvider(name = "dp") 
	  public Object[][] dp() {
		return new Object[][] {
		  //正确请求
	      new Object[]{ "eecc698764a1403d846bef6f9a01d90d","200"},
	      //错误的key
	      new Object[]{ "eecc698764a1403d846bef6f9a01d90","404"},
	      new Object[]{ "wrongproductkey","404"},
	      //key为空
	      new Object[]{ "","404"}
	      
	    };
	  }
	  @BeforeTest
	  public void beforeTest() {
	  }
}

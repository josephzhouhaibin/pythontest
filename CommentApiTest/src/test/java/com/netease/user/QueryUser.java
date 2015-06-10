package com.netease.user;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import com.netease.util.HttpRequest;

public class QueryUser{
//	public String code;
	  @Test(dataProvider = "dp") 
	  public void queryUser(int threadid,String productkey,String userid,String expectcode) {
		  String uri;
		  uri = "http://gentie.163.com:8181/api/v1//products/"+productkey+"/users/"+userid;
		  HttpRequest hgr = new HttpRequest();
	      hgr.code = expectcode;
	      boolean result = hgr.httpGetRequest(uri);
		  Assert.assertEquals(true,result);
	  }
	  @DataProvider(name = "dp") 
	  public Object[][] dp() {
		return new Object[][] {
		  //正确的用户
	      new Object[]{ 197, "eecc698764a1403d846bef6f9a01d90d","46554","200"},
	      //用户不存在
	      new Object[]{ 197, "eecc698764a1403d846bef6f9a01d90d","4655","404"},
	      //用户为空
	      new Object[]{ 197, "eecc698764a1403d846bef6f9a01d90d","","404"},
	      //错误的key
	      new Object[]{ 197, "wrongproductkey","46554","404"},
	      //key为空
	      new Object[]{ 197, "","","404"}
	      
	    };
	  }
	  @BeforeTest
	  public void beforeTest() {
	  }
}
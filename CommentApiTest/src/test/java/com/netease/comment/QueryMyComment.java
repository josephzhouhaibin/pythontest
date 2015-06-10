package com.netease.comment;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netease.util.HttpRequest;

public class QueryMyComment {
	@Test(dataProvider = "dp") 
	  public void queryMyComment(String userid,String productkey,String expectcode,int offset,int limit,int hiddenCondition,int hiddenStart,int hiddenEnd) {
		  String uri;
		  uri = "http://gentie.163.com:8181/api/v1//products/"+productkey+"/users/"+userid+"/mycomments/"+offset+"/"+limit+"/"+hiddenCondition+"/"+hiddenStart+"/"+hiddenEnd;
	      System.out.println(uri);
		  HttpRequest hgr = new HttpRequest();
		  hgr.code = expectcode;
		  boolean result = hgr.httpGetRequest(uri);
		  Assert.assertEquals(true,result);
	  }

	  @DataProvider(name = "dp") 
	  public Object[][] dp() {
		return new Object[][] {
				//正常请求
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,10,100,50,10},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,9,90,45,18},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,8,80,35,17},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,7,70,25,16},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,6,60,15,15},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,5,50,16,14},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,4,40,17,13},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,3,30,18,12},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,2,20,10,11},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,1,10,5,6},
			      new Object[]{ "ADB", "eecc698764a1403d846bef6f9a01d90d","422",0,8,80,35,17},
			      //用户id为空
			      new Object[]{ "", "eecc698764a1403d846bef6f9a01d90d","404",0,10,100,50,10},
			      //id不存在
			      new Object[]{ "12345", "eecc698764a1403d846bef6f9a01d90d","404",0,10,100,50,10},
			      //key不存在
			      new Object[]{ "46556", "wrongproduct","404",0,10,100,50,10},
			      //key为空
			      new Object[]{ "46556", "","404",0,10,100,50,10},
			      //URL错误
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d/aaa","404",0,10,100,50,10},
			      //单个参数异常
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","422",-1,10,100,50,10},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","422",0,-1,100,50,10},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","422",0,10,-1,50,10},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","422",0,10,100,-1,10},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","422",0,10,100,50,-1},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,10,100,50,10},
			      //单个参数越界
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","422",10,101,100,50,10},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","422",0,100,101,50,10},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","422",0,10,100,101,10},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","422",0,10,100,10,101},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","422",0,10,100,50,101},
			      new Object[]{ "46556", "eecc698764a1403d846bef6f9a01d90d","200",0,10,100,100,10},
	    };
	  }
	  @BeforeTest
	  public void beforeTest() {
	  }
}


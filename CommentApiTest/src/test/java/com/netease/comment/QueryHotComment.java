package com.netease.comment;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import com.netease.util.HttpRequest;


public class QueryHotComment{
  @Test(dataProvider = "dp") 
  public void queryHotComment(String threadid,String productkey,String expectcode,int offset,int limit,int hiddenCondition,int hiddenStart,int hiddenEnd) {
	  	 String uri;
	  	 uri = "http://gentie.163.com:8181/api/v1//products/"+productkey+"/threads/"+threadid+"/comments/hot/"+offset+"/"+limit+"/"+hiddenCondition+"/"+hiddenStart+"/"+hiddenEnd;
	  	 HttpRequest hgr = new HttpRequest();
	  	 hgr.code = expectcode;
		 boolean result = hgr.httpGetRequest(uri);
		 Assert.assertEquals(true,result);
  }
  @DataProvider(name = "dp") 
  public Object[][] dp() {
	return new Object[][] {
	  //正常请求
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,10,100,50,10},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,9,90,45,18},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,8,80,35,17},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,7,70,25,16},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,6,60,15,15},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,5,50,16,14},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,4,40,17,13},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,3,30,18,12},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,2,20,10,11},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,1,10,5,6},
      //主贴为空
      new Object[]{ "", "eecc698764a1403d846bef6f9a01d90d","404",0,10,100,50,10},
      //主贴不存在
      new Object[]{ "A024A5A110", "eecc698764a1403d846bef6f9a01d90d","404",0,10,100,50,10},
      //key不存在
      new Object[]{ "A014A5A11001768D", "wrongproduct","404",0,10,100,50,10},
      //key为空
      new Object[]{ "A014A5A11001768D", "","404",0,10,100,50,10},
      //URL错误
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d/aaa","404",0,10,100,50,10},
      //单个参数异常
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422",-1,10,100,50,10},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422",0,-1,100,50,10},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422",0,10,-1,50,10},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422",0,10,100,-1,10},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422",0,10,100,50,-1},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,10,100,50,10},
      //单个参数越界
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422",10,101,100,50,10},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422",0,100,101,50,10},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422",0,10,100,101,10},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422",0,10,100,10,101},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","422",0,10,100,50,101},
      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d","200",0,10,100,100,10},
      
    };
  }
  @BeforeTest
  public void beforeTest() {
  }
}

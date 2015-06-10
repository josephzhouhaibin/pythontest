package com.netease.comment;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import com.netease.util.HttpRequest;

public class AgainstComment{
	  @Test(dataProvider = "dp") 
	  public void againstComment(String threadid,String productkey,int commentid,String expectcode) {
			 String uri;
			 uri = "http://gentie.163.com:8181/api/v1/products/"+productkey+"/threads/"+threadid+"/comments/"+commentid+"/action/against";
			 HttpRequest hr = new HttpRequest();
			 hr.code = expectcode;
			 boolean result = hr.httpPostRequest(uri);
			  Assert.assertEquals(true,result);
		  }

		  @DataProvider(name = "dp") 
		  public Object[][] dp() {
			return new Object[][] {
			  //正确的请求
		      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d",230218,"200"},
		      //主贴不存在
		      new Object[]{ "asdfg", "eecc698764a1403d846bef6f9a01d90d",11,"404"},
		      //跟贴不存在
		      new Object[]{ "A014A5A11001768D", "eecc698764a1403d846bef6f9a01d90d",100,"404"},
		     //key错误
		      new Object[]{ "A014A5A11001768D", "wrongproduct",397,"404"},
		    //key为空
		      new Object[]{ "A014A5A11001768D", "",397,"404"},
		    //主贴id为空
		      new Object[]{ "", "eecc698764a1403d846bef6f9a01d90d",397,"404"},
		    //key为空主贴id也为空
		      new Object[]{ "", "",1,"404"},
		      
		    };
		  }
		  @BeforeTest
		  public void beforeTest() {
		  }
	}
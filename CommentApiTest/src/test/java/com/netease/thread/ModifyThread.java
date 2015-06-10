package com.netease.thread;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netease.util.ThreadPutRequest;

public class ModifyThread{
	@Test(dataProvider="dp")
	 public void modifyRequest(String uri,String url,String title,String docid,boolean app,boolean web,boolean against,boolean audio,String requesttype,String expectcode){
		 ThreadPutRequest tr = new ThreadPutRequest();
		 tr.code = expectcode;
		 boolean result = tr.threadPutRequest(uri,url,title,docid,app,web,against,audio,requesttype,expectcode);
		  Assert.assertEquals(true,result);
	 }
    @DataProvider(name = "dp") 
    public Object[][] dp() {
  	return new Object[][] {
//  			//正常修改测试
  	   		 new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/B014A5A11001768D","http://tie.163.com11112", "test2","B014A5A11001768D",false,false,false,true,"PUT","200"},
//  	  	    	//主贴url为空
  	   		 new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/B014A5A11001768D","", "test1","C4C4A5A11001768F",false,false,false,true,"PUT","200"},
//  	        	//标题title为空
  	   		 new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/B014A5A11001768D","http", "","C4C4A5A11001768R",false,false,false,true,"PUT","200"},
//  	        	//主贴docid为空
  	   		 new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/B014A5A11001768D","http", "test","",false,false,false,true,"PUT","200"},
//  	        	//url超过边界300
  	  	    new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/B014A5A11001768D","qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop1", "test5","C4C4A5A11001768F",false,false,false,true,"PUT","422"},
//  	  	    	//title超过规格400
  	  	    new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/B014A5A11001768D","http://tie.163.com111", "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest1","C4C4A5A11001768F",false,false,false,true,"PUT","422"},
//  	  	    	//docid超过21
  	  	     new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/B014A5A11001768D", "http://tie.163.com111", "test6","C4C4A5A11001768Saaaaaa",false,false,false,true,"PUT","200"},
//  	  	    	//url边界300
  		    new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/B014A5A11001768D","qertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop1", "test7","abc",false,false,false,true,"PUT","200"},
//  		    	//title规格400
  		    new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/B014A5A11001768D","http://tie.163.com111", "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest1","abc",false,false,false,true,"PUT","200"},
//  		    	//docid规格21
  		    new Object[]{"http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads/B014A5A11001768D", "http://tie.163.com111", "test10","wertyuiopqwertyuiop",false,false,false,true,"PUT","200"},
//  	  			//主贴url为特殊字符测试
//  	  		new Object[]{ "～！@＃¥％……&＊（）——＋｛｝：“｜《》？~!@#$%^&*()_+|}{\":?><", "test2","abc",false,false,false,true,"201"},
//  	        	//主贴title特殊字符字符测试
//  	  		new Object[]{ "http://tie.163.com", "～！@＃¥％&＊（）＋｛｝：“｜？~!@#$%^&*()_+|}{\":?><","abc",false,false,false,true,"201"},
//  	        	//主贴doc为复杂字符测试
//  	  		new Object[]{ "http://tie.163.com", "title", "～！@＃¥％……&＊（）——＋｛｝：“｜《》？~!@#$%^&*()_+|}{\":?><",false,false,false,true,"201"},
//  	        	//主贴url包含中文
//  	        new Object[]{ "测试", "test","abc",false,false,false,true,"201"},
//  	        	//主贴title为中文字符测试
//  	        new Object[]{ "http://tie.163.com", "测试","abc",false,false,false,true,"201"}
      };
    }
 
}
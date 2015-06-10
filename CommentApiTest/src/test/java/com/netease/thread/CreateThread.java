package com.netease.thread;


import java.util.Random;
import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.netease.util.ThreadPostRequest;

public class CreateThread{
	 @Test(dataProvider="dp")
	 public void creatThread(String uri,String url,String title,int docid,boolean app,boolean web,boolean against,boolean audio,String requesttype,String expectcode){
		 ThreadPostRequest tr = new ThreadPostRequest();
		 tr.code = expectcode;
		 boolean result = tr.threadRequest(uri,url,title,getRandomString(docid),app,web,against,audio,requesttype,expectcode);
//		 System.out.println("statuscode="+hr.getRequest(uri));
		 Assert.assertEquals(true,result);
	 }
	 public static String getRandomString(int length) { //length表示生成字符串的长度  
		    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
		    Random random = new Random();     
		    StringBuffer sb = new StringBuffer();     
		    for (int i = 0; i < length; i++) {     
		        int number = random.nextInt(base.length());     
		        sb.append(base.charAt(number));     
		    }     
		    return sb.toString();     
		 }  
    @DataProvider(name = "dp") 
    public Object[][] dp() {
  	return new Object[][] {
  			//正常发贴测试
   		 new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads","http://tie.163.com1111", "test1",16,true,true,true,true,"POST","201"},
//  	    	//主贴url为空
   		 new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads","", "test1",16,false,false,false,true,"POST","422"},
//        	//标题title为空
   		 new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads","http", "",26,false,false,false,true,"POST","422"},
//        	//主贴docid为空
   		 new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads","http", "test",0,false,false,false,true,"POST","422"},
//        	//url超过边界300
  	    new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads","qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop1", "test5",16,false,false,false,true,"POST","422"},
//  	    	//title超过规格400
  	    new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads","http://tie.163.com111", "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest1",16,false,false,false,true,"POST","422"},
//  	    	//docid超过21
  	    new Object[]{"http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads", "http://tie.163.com111", "test6",22,false,false,false,true,"POST","422"},
//  	    	//url边界300
	    new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads","qertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop1", "test7",16,false,false,false,true,"POST","201"},
//	    	//title规格400
	    new Object[]{ "http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads","http://tie.163.com111", "esttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest1",16,false,false,false,true,"POST","201"},
//	    	//docid规格21
	    new Object[]{"http://gentie.163.com:8181/api/v1/products/eecc698764a1403d846bef6f9a01d90d/threads", "http://tie.163.com111", "test10",20,false,false,false,true,"POST","201"},
//  			//主贴url为特殊字符测试
//  		new Object[]{ "～！@＃¥％……&＊（）——＋｛｝：“｜《》？~!@#$%^&*()_+|}{\":?><", "test2","abc",false,false,false,true,"201"},
//        	//主贴title特殊字符字符测试
//  		new Object[]{ "http://tie.163.com", "～！@＃¥％&＊（）＋｛｝：“｜？~!@#$%^&*()_+|}{\":?><","abc",false,false,false,true,"201"},
//        	//主贴doc为复杂字符测试
//  		new Object[]{ "http://tie.163.com", "title", "～！@＃¥％……&＊（）——＋｛｝：“｜《》？~!@#$%^&*()_+|}{\":?><",false,false,false,true,"201"},
        	//主贴url包含中文
//        new Object[]{ "测试", "test","abc",false,false,false,true,"201"},
        	//主贴title为中文字符测试
//        new Object[]{ "http://tie.163.com", "测试","abc",false,false,false,true,"201"}
      };
    }
 
}
package com.netease.util;

import org.testng.Assert;

public class ReturnCheck {
	private boolean result;
	public boolean returnCheck(int statuscode,String entitystring,String code){
		String actualcode = String.valueOf(statuscode);
//		System.out.println(actualcode);
		try{
  			if ( statuscode == 200) {
                System.out.println("200response content:" + entitystring);
                Assert.assertEquals(actualcode,code);
//              Assert.assertEquals(entitystring.contains(code),true);
//  	     	Assert.assertNotNull(entitystring);
//                Assert.assertEquals(entitystring.contains("createTime"),true);
  				result = true;
//  				System.out.println(result);
  			}else if( statuscode == 201){
  				System.out.println("response content:" + entitystring);
                Assert.assertEquals(actualcode,code);
                Assert.assertEquals(entitystring.contains("createTime"),true);
                result = true;
			}else if( statuscode == 204){
  				System.out.println("response content:" + entitystring);
                Assert.assertEquals(actualcode,code);
                result = true;
  			}else if( statuscode == 400){
  				System.out.println("response content:" + entitystring);
              Assert.assertEquals(actualcode,code);
                Assert.assertEquals(entitystring.contains(code),true);
                result = true;
				Assert.assertEquals(entitystring.contains("code"),true);
			}else if( statuscode == 401){
  				System.out.println("response content:" + entitystring);
                Assert.assertEquals(actualcode,code);
                Assert.assertEquals(entitystring.contains(code),true);
                result = true;
  				Assert.assertEquals(entitystring.contains("code"),true);
  			}else if( statuscode == 404){
  				System.out.println("response content:" + entitystring);
                Assert.assertEquals(actualcode,code);
                Assert.assertEquals(entitystring.contains(code),true);
                result = true;
				Assert.assertEquals(entitystring.contains("code"),true);
			}else if( statuscode == 422){
  				System.out.println("response content:" + entitystring);
                Assert.assertEquals(actualcode,code);
                Assert.assertEquals(entitystring.contains(code),true);
                result = true;
				Assert.assertEquals(entitystring.contains("code"),true);
			}else{
				result = false;
           	   System.out.println(entitystring);
          	   Assert.assertEquals(false,true);
          }
//  			else{
//  				Assert.assertEquals(500, httpResponse.getStatusLine().getStatusCode());	
//  			}
//  			
  		}catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
		return result;
	}
}

package com.netease.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GetAppSignature {
	
	public String date = DateUtil.formatRFC822(new Date());
	
  public  String getMd5(String body) {
	  byte[] arr = body.getBytes();
//	  System.out.println(arr);
	  String md5 =  AppSignatureUtil.getMD5AsHex(arr);
	  return md5;
  }
  
  public  String getAppsignture(String appKey,String appSecret, String domain,String method,String uri,String body) throws Exception {

	  
	  
	  Map<String, String > headers = new HashMap<String, String>();
      headers.put("x-gt-appkey", appKey);
      headers.put("x-gt-domain", domain);
      headers.put("x-gt-contentmd5", getMd5(body));
      headers.put("x-gt-date", date);

      String signature = AppSignatureUtil.getSignature(uri, method, domain, headers, appSecret);
	  return signature;
  }
  
}

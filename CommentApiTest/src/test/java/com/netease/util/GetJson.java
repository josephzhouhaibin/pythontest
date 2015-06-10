package com.netease.util;

import org.json.JSONObject;

public class GetJson {
    public  JSONObject getJson(String url,String title,String docid,boolean app,boolean web,boolean against,boolean audio){
        JSONObject obj2 = new JSONObject();
        JSONObject obj3 = new JSONObject();
//          obj2.put("url", "http://tie.163.com").put("title", "test1").put("docid", "abc").put("plock", obj3);
//          obj3.put("app", false).put("web",false).put("against",false).put("audio", true);
        	obj2.put("url", url).put("title", title).put("docid", docid).put("plock", obj3);
        	obj3.put("app", app).put("web",web).put("against",against).put("audio", audio);
//          System.out.println(obj2);
          return obj2;       
    }
}

package com.netease.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yanglong on 15/3/23.
 */
public class AppSignatureUtil {

    /**
     * basic string：接入app domain name + "\n" +  url path + "\n" + http method + "\n" + header string)
     * header string:
     * 需要包含且只包含所有以'x-gt-'开头的标准头
     * header 项名称全部小写，值必须经过trim 去除空格
     * header 项按照名字的字典序从小到大排序
     * header 项的名称和值之间以':' 相隔
     * 每个header 之间以换行符相隔
     *
     * 对basic string进行基于app secret key的hmac_sha1加密，再进行base64 encode，得到签名
     * @param requestUri http请求的路径部分，比如 /a/b
     * @param httpMethod GET POST PUT DELETE 等
     * @param domain 产品域
     * @param headers 请求的头部
     * @param appSecret 产品密钥
     * @return
     * @throws Exception
     */
    public static String getSignature(String requestUri,String httpMethod, String domain, Map<String, String> headers,
                                      String appSecret) throws Exception {


        StringBuffer stringToSign = new StringBuffer();
        stringToSign
                //添加domain
                .append(domain.trim().toLowerCase()).append("\n")
                // 添加 url path 部分
                .append(requestUri.trim()).append("\n")
                //添加http 方法
                .append(httpMethod.toLowerCase()).append("\n");

        //添加http header部分
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        for(String s : headers.keySet()){
            if(s.startsWith("x-gt-") && !s.equalsIgnoreCase("x-gt-signature")) {
                treeMap.put(s, headers.get(s));
            }
        }

        for(String k : treeMap.keySet()){
            stringToSign.append(k.trim().toLowerCase()).append(":").append(treeMap.get(k).trim().toLowerCase()).append("\n");
        }

        String signature = calculateRFC2104HMAC(stringToSign.toString(), appSecret);

        return signature;
    }

    public static String calculateRFC2104HMAC(String data, String key)
            throws java.security.SignatureException
    {
        String result;
        try {

            // get an hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");

            // get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);

            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes());

            // base64-encode the hmac
            result = Base64.encodeBase64String(rawHmac);

        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

    /**
     * 生成md5
     * @param key
     * @return
     */
    public static String getMD5AsHex(byte[] key) {
        return getMD5AsHex(key, 0, key.length);
    }

    public static String getMD5AsHex(byte[] key, int offset, int length) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(key, offset, length);
            byte[] digest = messageDigest.digest();
            return new String(Hex.encodeHex(digest));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error computing MD5 hash", e);
        }
    }

}
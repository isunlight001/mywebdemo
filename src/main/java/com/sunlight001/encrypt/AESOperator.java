package com.sunlight001.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder; 
public class AESOperator {
	/* 
     * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。 
     */  
    private String sKey = "0123456789abcdef";//key，可自行修改  
    private String ivParameter = "1020304050607080";//偏移量,可自行修改  
    private static AESOperator instance = null;  
  
    private AESOperator() {  
  
    }  
  
    public static AESOperator getInstance() {  
        if (instance == null)  
            instance = new AESOperator();  
        return instance;  
    }  
  
    // 加密  
    public String encrypt(String sSrc) throws Exception {  
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
        byte[] raw = sKey.getBytes();  
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");  
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度  
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);  
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));  
        return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。  
    }  
  
    // 解密  
    public String decrypt(String sSrc) throws Exception {  
        try {  
            byte[] raw = sKey.getBytes("ASCII");  
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");  
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());  
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);  
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密  
            byte[] original = cipher.doFinal(encrypted1);  
            String originalString = new String(original, "utf-8");  
            return originalString;  
        } catch (Exception ex) {  
            return null;  
        }  
    }  
  
    public static void main(String[] args) throws Exception {  
        // 需要加密的字串  
        //String cSrc = "[{\"request_no\":\"1001\",\"service_code\":\"FS0001\",\"contract_id\":\"100002\",\"order_id\":\"0\",\"phone_id\":\"13913996922\",\"plat_offer_id\":\"100094\",\"channel_id\":\"1\",\"activity_id\":\"100045\"}]";  
          
        String cSrc = "15811111111";  
        AESOperator.getInstance();  
        // 加密  
        long lStart = System.currentTimeMillis();  
        String enString = AESOperator.getInstance().encrypt(cSrc);  
        System.out.println("加密后的字串是：" + enString);  
  
        long lUseTime = System.currentTimeMillis() - lStart;  
        System.out.println("加密耗时：" + lUseTime + "毫秒");  
        // 解密  
        lStart = System.currentTimeMillis();  
        String DeString = AESOperator.getInstance().decrypt(enString);  
        System.out.println("解密后的字串是：" + DeString);  
        lUseTime = System.currentTimeMillis() - lStart;  
        System.out.println("解密耗时：" + lUseTime + "毫秒");  
    }  
  
}

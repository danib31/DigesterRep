package com.testpackage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class MessageService { 
	
   static HashMap<String,String> strToHash = new HashMap<String,String>();
   static HashMap<String,String> hashToStr = new HashMap<String,String>();
      
   public String getDecryptedMessage(String str){
	      if(hashToStr.get(str) != null) return "Message: " + hashToStr.get(str);
	      return "404: Original message not found.";
   }
   
   public String getEncryptedMessage(String str){
	 
	   if(strToHash.get(str) != null) return "Digest: " + strToHash.get(str);
	   try {
           byte[] hashBytes = MessageDigest.getInstance("SHA-256").digest(str.getBytes());
           String text = new BigInteger(1, hashBytes).toString(16);
           while (text.length() < 32) {
               text = "0" + text;
           }
           strToHash.put(str, text);
           hashToStr.put(text, str);
           return "Digest: " + text;
       }
       catch (NoSuchAlgorithmException e) {
           return "Exception: No Such Algorithm: " + e;
       }
   }
   
}

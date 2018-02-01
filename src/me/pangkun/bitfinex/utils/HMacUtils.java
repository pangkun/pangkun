package me.pangkun.bitfinex.utils;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 庞昆 on 2017/9/23.
 */
public class HMacUtils {

    public static void main(String[] args) throws Exception {
        String key = "1234";
        String word = "1234";
        System.out.println(getSHA384(word,key));
    }
    public static String getSHA384(String data,String key) {
        String result = "";
        byte[] bytesKey = key.getBytes();
        final SecretKeySpec secretKey = new SecretKeySpec(bytesKey, "HmacSHA384");
        try {
            Mac mac = Mac.getInstance("HmacSHA384");
            mac.init(secretKey);
            final byte[] macData = mac.doFinal(data.getBytes());
            byte[] hex = new Hex().encode(macData);
            result = new String(hex, "ISO-8859-1");
        } catch (NoSuchAlgorithmException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return result;
    }
    
}
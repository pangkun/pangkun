package me.pangkun.bitfinex.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by 庞昆 on 2017/9/24.
 */
public class BASE64Utils {
    public static String getBase64(String payLoad){
        return Base64.encodeBase64String(payLoad.getBytes());
    }
}

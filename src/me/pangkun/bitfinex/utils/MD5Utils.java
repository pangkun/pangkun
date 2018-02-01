package me.pangkun.bitfinex.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by 庞昆 on 2017/9/5.
 */
public class MD5Utils {
    private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    public static String buildSign(Map<String, String> sArray, String secretKey) {
        String mysign = "";
        try {
            //String prestr = createLinkString(sArray); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            List<String> keys = new ArrayList<String>(sArray.keySet());
            Collections.sort(keys);
            String prestr = "";
            for (int i = 0; i < keys.size(); i++) {
                String key = keys.get(i);
                String value = sArray.get(key);
                if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                    prestr = prestr + key + "=" + value;
                } else {
                    prestr = prestr + key + "=" + value + "&";
                }
            }
            prestr = prestr + "&secret_key=" + secretKey; // 把拼接后的字符串再与安全校验码连接起来
            mysign = getMD5String(prestr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mysign;
    }
    public static String getMD5String(String str) {
        try {
            if (str == null || str.trim().length() == 0) {
                return "";
            }
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            bytes = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(HEX_DIGITS[(bytes[i] & 0xf0) >> 4] + ""
                        + HEX_DIGITS[bytes[i] & 0xf]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}

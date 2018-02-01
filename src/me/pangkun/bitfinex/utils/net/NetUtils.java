package me.pangkun.bitfinex.utils.net;

import me.pangkun.bitfinex.utils.BASE64Utils;
import me.pangkun.bitfinex.utils.HMacUtils;
import me.pangkun.bitfinex.utils.userapi.UserApi;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


/**
 * Created by 庞昆 on 2017/9/5.
 */
public class NetUtils {
    public static HttpURLConnection httpURLConnection = null;

    public static BufferedWriter upLoad(String request,Map<String,String>map) throws IOException {
        URL url = new URL(request);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.addRequestProperty("Accept", "application/json");
        httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.connect();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "utf-8"));
        return bufferedWriter;
    }

    public static void upLoad1() throws IOException, JSONException {
        long nonce = System.currentTimeMillis();
        URL url = new URL("https://api.bitfinex.com/v1/balances");
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        JSONObject jo = new JSONObject();
        jo.put("request","/v1/balances");
        jo.put("nonce", Long.toString(++nonce));
        String payload = jo.toString();
        String base64 = BASE64Utils.getBase64(payload);
        httpURLConnection.addRequestProperty("X-BFX-APIKEY", UserApi.BITFINEX_API_KEY);
        httpURLConnection.addRequestProperty("X-BFX-PAYLOAD", base64);
        httpURLConnection.addRequestProperty("X-BFX-SIGNATURE", HMacUtils.getSHA384(base64,UserApi.BITFINEX_SECRET_KEY));
        httpURLConnection.addRequestProperty("Accept", "application/json");
        httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.connect();
    }

    public static void upLoad2(String type,Double price,Double amount) throws IOException, JSONException {
        long nonce = System.currentTimeMillis();
        URL url = new URL("https://api.bitfinex.com/v1/order/new");
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        JSONObject jo = new JSONObject();
        jo.put("request", "/v1/order/new");
        jo.put("nonce", Long.toString(++nonce));
        jo.put("symbol","bchusd");
        jo.put("amount",String.valueOf(amount));
        jo.put("price",String.valueOf(price));
        jo.put("side",type);
        jo.put("type","exchange limit");
        jo.put("ocoorder",false);
        jo.put("buy_price_oco",0.0);
        jo.put("sell_price_oco",0.0);
        String payload = jo.toString();
        String base64 = BASE64Utils.getBase64(payload);
        httpURLConnection.addRequestProperty("X-BFX-APIKEY", UserApi.BITFINEX_API_KEY);
        httpURLConnection.addRequestProperty("X-BFX-PAYLOAD", base64);
        httpURLConnection.addRequestProperty("X-BFX-SIGNATURE", HMacUtils.getSHA384(base64,UserApi.BITFINEX_SECRET_KEY));
        httpURLConnection.addRequestProperty("Accept", "application/json");
        httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.connect();
    }

    public static void upLoad3(long order_id) throws IOException, JSONException {
        long nonce = System.currentTimeMillis();
        URL url = new URL("https://api.bitfinex.com/v1/order/status");
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        JSONObject jo = new JSONObject();
        jo.put("request", "/v1/order/status");
        jo.put("nonce", Long.toString(++nonce));
        jo.put("order_id",order_id);
        String payload = jo.toString();
        String base64 = BASE64Utils.getBase64(payload);
        httpURLConnection.addRequestProperty("X-BFX-APIKEY", UserApi.BITFINEX_API_KEY);
        httpURLConnection.addRequestProperty("X-BFX-PAYLOAD", base64);
        httpURLConnection.addRequestProperty("X-BFX-SIGNATURE", HMacUtils.getSHA384(base64,UserApi.BITFINEX_SECRET_KEY));
        httpURLConnection.addRequestProperty("Accept", "application/json");
        httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.connect();
    }

    public static void upLoad4(long order_id) throws IOException, JSONException {
        long nonce = System.currentTimeMillis();
        URL url = new URL("https://api.bitfinex.com/v1/order/cancel");
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        JSONObject jo = new JSONObject();
        jo.put("request", "/v1/order/cancel");
        jo.put("nonce", Long.toString(++nonce));
        jo.put("order_id",order_id);
        String payload = jo.toString();
        String base64 = BASE64Utils.getBase64(payload);
        httpURLConnection.addRequestProperty("X-BFX-APIKEY", UserApi.BITFINEX_API_KEY);
        httpURLConnection.addRequestProperty("X-BFX-PAYLOAD", base64);
        httpURLConnection.addRequestProperty("X-BFX-SIGNATURE", HMacUtils.getSHA384(base64,UserApi.BITFINEX_SECRET_KEY));
        httpURLConnection.addRequestProperty("Accept", "application/json");
        httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.connect();
    }

    public static String downLoad() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String data = null;
        while ((data = bufferedReader.readLine()) != null) {
            stringBuilder.append(data + "\r\n");
        }
        bufferedReader.close();
        httpURLConnection.disconnect();
        return stringBuilder.toString();
    }

    public static String downLoad(String request) throws IOException {
        URL url = new URL(request);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.addRequestProperty("Accept", "application/json");
        httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.connect();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String data = null;
        while ((data = bufferedReader.readLine()) != null)
            stringBuilder.append(data + "\r\n");
        return stringBuilder.toString();
    }


}

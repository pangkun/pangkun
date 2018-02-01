package me.pangkun.bitfinex;

import me.pangkun.bitfinex.utils.net.NetUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 庞昆 on 2017/10/8.
 */
@WebServlet("/bitfinex/price")
public class BitfinexPrice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String price = NetUtils.downLoad("https://api.bitfinex.com/v1/pubticker/" + type);
        String account = null;
        try {
            NetUtils.upLoad1();
            account = NetUtils.downLoad();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put(new JSONObject(price));
            jsonArray.put(new JSONArray(account));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.getWriter().print(jsonArray);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String downLoad = NetUtils.downLoad("https://api.bitfinex.com/v1/pubticker/" + type);
        try {
            JSONObject jsonObject = new JSONObject(downLoad);
            String sell = (String) jsonObject.get("ask");
            String buy = (String) jsonObject.get("bid");
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("type", type);
            jsonObject1.put("sell", sell);
            jsonObject1.put("buy", buy);
            response.getWriter().print(jsonObject1);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

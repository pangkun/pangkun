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
 * Created by 庞昆 on 2017/10/10.
 */
@WebServlet("/bitfinex/pricelist")
public class BitfinexPriceList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONArray jsonArray = new JSONArray();
        String list = request.getParameter("list");
        for (int i = 0; i < list.length(); i += 6) {
            String type = list.substring(i, i + 6);
            String downLoad = NetUtils.downLoad("https://api.bitfinex.com/v1/pubticker/" + type);
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(downLoad);
                String sell = (String) jsonObject.get("ask");
                String buy = (String) jsonObject.get("bid");
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("type", type);
                jsonObject1.put("sell", sell);
                jsonObject1.put("buy", buy);
                jsonArray.put(jsonObject1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        response.getWriter().print(jsonArray);
    }

}

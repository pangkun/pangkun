package me.pangkun.bitfinex;

import me.pangkun.bitfinex.utils.Config;
import me.pangkun.bitfinex.utils.javabean.Coin;
import me.pangkun.bitfinex.utils.net.NetUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 庞昆 on 2017/10/12.
 */
public class GetPriceList extends Thread {
    private static GetPriceList getPriceList = null;

    private GetPriceList() {
    }

    public static GetPriceList getInstance() {

        getPriceList = new GetPriceList();
        return getPriceList;
    }

    private static List<Coin> coinList;

    public static List<Coin> getPriceList() {
        return coinList;
    }

    @Override
    public void run() {
        while (true) {
            List<Coin> list = new ArrayList<Coin>();
            for (int i = 0; i < Config.PRICELIST.length(); i += 6) {
                String type = Config.PRICELIST.substring(i, i + 6);
                String downLoad = null;
                JSONObject jsonObject = null;
                try {
                    downLoad = NetUtils.downLoad("https://api.bitfinex.com/v1/pubticker/" + type);
                    jsonObject = new JSONObject(downLoad);
                    String sell = (String) jsonObject.get("ask");
                    String buy = (String) jsonObject.get("bid");
                    Coin coin = new Coin();
                    coin.setBuy(buy);
                    coin.setSell(sell);
                    coin.setType(type);
                    list.add(coin);
                    Thread.sleep(3000);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            coinList=list;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

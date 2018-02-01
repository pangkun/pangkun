package me.pangkun.bitfinex.utils.javabean;

/**
 * Created by 庞昆 on 2017/10/9.
 */

public class Coin {
    private String buy;
    private String sell;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }
}

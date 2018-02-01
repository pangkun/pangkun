package top.pangkun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 庞昆 on 2018/1/24.
 */
public class TimeUtil {
    public static String getNowTime(){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(System.currentTimeMillis());
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    public static void main(String[] args) {
        try {
            System.out.println(System.currentTimeMillis());
            System.out.println(dateToStamp(getNowTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

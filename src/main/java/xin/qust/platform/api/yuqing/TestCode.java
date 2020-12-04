package xin.qust.platform.api.yuqing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TestCode{
    public static void main(String[] args) throws ParseException {
        String str = "2020-12-01T07:22:00.000Z";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        System.out.println(df.parse(str).getSeconds());
        int month = df.parse(str).getMonth()+1;
        int day = df.parse(str).getDay()-1;
        int hours = df.parse(str).getHours();
        int minutes = df.parse(str).getMinutes();
        int seconds = df.parse(str).getSeconds();





    }
}
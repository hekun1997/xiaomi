package com.xiaomi.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TradingFlowUtil {
        //18位交易流水号 前14位为年月时分秒 后四位为随机数 保证不会重复
    public static String get(){
        Date date = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
        int randomNum = (int)((Math.random()*9+1)*1000);
        String tradingFlowNum = sdf2.format(date).toString()+String.valueOf(randomNum);
        return tradingFlowNum;
    }
}

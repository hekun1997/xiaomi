package com.xiaomi.tools;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.xiaomi.configuration.AlipayConfig;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

public class AliPayTools {
    public static String pay(Integer cus_id,String goods_name,Integer goods_quantity,Float goods_price,String tradeing_flow) {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gate_way,
                AlipayConfig.app_id,
                AlipayConfig.private_key,
                "json",
                AlipayConfig.char_set,
                AlipayConfig.public_key,
                AlipayConfig.sign_type);

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url+cus_id);
        System.out.println(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        String out_trade_no = tradeing_flow;
        String total_amount = String.valueOf(goods_price);
        String subject = goods_name;
        String body = cus_id +" : "+goods_name;

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = "";
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return result;
    }
}

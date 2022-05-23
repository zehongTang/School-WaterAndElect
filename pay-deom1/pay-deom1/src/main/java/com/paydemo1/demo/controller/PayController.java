package com.paydemo1.demo.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;


@RestController
public class PayController {
    private final String APP_ID = "2021000119689345";
    private final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCpoK/bZgbh77Z3f8NygOh5eSmgSszju4Y7U4OiLLzkitAITPjyZH3V6JBSj50jJZJEFE35ACgaAkV0KGuXAHcBBqbCc8WtyEBjkIC1VMm6+pgtTbfufBZiC8zPq1f8HxLZxEkXiiiyzF7JO72lF1LzKedmjmvwPhUe7JzZimC1VksBhvXRRnia37PTXG/AIR5tQfo3CMeXLlPKQCnAtPQXJi9MBFdRf2+y9NlXK54LeW7ixWDYTRSh8ZB01JoOeqUeWLjtFwwbJEn8wO6eGeeXCPb0N8WF2ak14+4PEDjG7AOHCOdxljuXT5JUVrQxegHEVPiA/5wjSza53Nua6Pz7AgMBAAECggEAeu7BhDfE9SlNC/3EH8/cq2xsBocvRjw5Y/V6iKXzn44ahmmCYekCaWxKbAs4zqgEAOLWP4cliPPscep5Ts4/cLbpVDOjJ/bg80degAwaxy+l6e9RRb0YW6ZBoJ+E/GtotfnTHwQ5ypriduSc5HCq5R+RXHoLL+lOVUMVyXLH86KNlFKLJtI2QDryvefDaPEjsYwmO7yc2KiFYQqvoc9wcfJmjDzp5MTmztLzb50LorR7l4dwaUiNxnMbNnfDeKZJst8jOpE+jUe0FgtJpeODUUQRhEj9/ZH17Wp8fNCzsIR0xqCW3ya205NN4Ory9KOnZaVX+QSrAL1O09I+elhKwQKBgQDuqzWMZtpmP1B32LEJLY8trb4QdPeVkeeBFyokNDUx2DZjg88q/gLsO1W0aGeLD4lEzBdbPxvbgOvMd1YzysoftkXpzDVu9wY7reJbbIdxJTH/5vZSFuu7/gwB17f96o+cn5WgaP/mLGynoruwucB7c6wHlOg7k2jh1hdp5ZAjdQKBgQC18gWGQVfzYn7KLrOAAlqt8Q9y4OHY3UapQNzBZVoEYjFrzjnMCAis7ZY/3lW2y9D0gzz2i7vbb5TTrVygYx02Z89sdkbaKbt6P4W1H04GkTDaolles1w1DvbJNPz8i/FDycxgLG63wrWMHDE4gbxkVHjVKYLwP/tt75+Sq4XArwKBgQC5bh/Ok+K/ahW055C0lscVMFXpJ1dsx81cCIlfU4i4z0mCi9gbiPrwWzE9V5iK/GkkIIVNCX01T7bkRxucZcQgW1d6TIR/UEFxgKnLakjY6ZMtRV6/bLt+deUSUW3MQ7+Mapiv5qRbSsyoedDlf4xC3h4cTd8Y2nC0dcf/KLKSOQKBgBhaYKrrrB4DnPzq61PC/OgzT+IMf65LT93vtJyeOEJF8l9/pvTMTnz3ABlkZQymkz1nI43MfkSM1trOZYuCOLLDilv2KN2ioFlojzkDC6qNXICnIlcuorTnX9jmosYa5Rwxso1c5STrhulODLiHhPPY6qN9fu0xYzH/1NgI5Uo5AoGATgceGEggqdgAgw4gAPuOcUqRcga/Wg+iuRRJTFNLNGmXyew48c1CSuQVFPxjBFPzA42PNQpZCwhAdYFdSosL0cPCL0xKwHh6x9B/SLcxSoMz2TABrWImEmpJWLjdtFHek9Vdcv+hwxeLd3LKZJeabABh47lPA4frjERnMJoSjto=";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqwAsuAyIWR+oCMlZeA9OMTVS8Rk6vXLMCWSIKGN+lxSk75L54VzTX2PkFuWiQf+yivEIN/acNgbnv3gPVztuD0SI8mHNf3W4LqRJ5vOzBmGxGDxJ5uhLhbAllykHHkpP52XkH9+vBB5tcpfK1VAbh+WByQKDDj7vTjgF4U66jR1SpmCf4OpHNQGNiSWqSVQhVkh07rYyFJLFZLm4cWxiYhRvABQTJn8ma0dhrsZzI2VWBvBWhsU8jcEDnJU9UG3mrfBHn8wHkiFGGDVifQhtP3wXjFXHm+bS+73I/grAFhXxzoUryOcgXXl9Yr0DlSiNuKgkWg/zOTd9k5Xl556gLQIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://localhost:8081";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://10.6.105.33:localhost:8081/notify";




    @RequestMapping("/money")
    public void money(HttpServletResponse httpResponse, String setID, String setMoney) throws IOException {

        SecureRandom r = new SecureRandom();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址

        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);


        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount = setMoney;
        //订单名称，必填
        String subject = "水电缴费";
        //商品描述，可空
        String body = setID;
        request.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();


    }

    @RequestMapping(value = "/notify")
    public void notifyUrl(HttpServletRequest request) throws AlipayApiException{

        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name =  iter.next();
            String[] values =  requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
//            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            //寝室号
             String room_ID = new String(request.getParameter("body").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//            // 商户订单号
//            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            // 付款金额
            String recharge= new String(request.getParameter("total_amount").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            System.out.println("寝室号="+room_ID);
            System.out.println("付款金额="+recharge);
//            p = pocketMapper.updateUser(new Pocket(room_ID,"1",recharge));


        }


    }


}


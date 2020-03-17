package com.atguigu.gmall.order.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.atguigu.gmall.order.vo.PayVo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alipay")
@Component
@Data
public class AlipayTemplate {

    //在支付宝创建的应用的id
    private   String app_id = "2016101500691841";

    // 商户私钥，您的PKCS8格式RSA2私钥
    private  String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCPtI6vmiy/ZZl3K3rsr3c9PbXUoX4C8VlF1mnm2e3+xEB+wZjhUfpJd4srf6052nxdXV2XGSAwKYriwDUrUWMH3OmWAxRUhLHp6oipdNOWBGyMB+AjwzOAgCQIefh7vkErMjFU+lnqCAG0KkUcdfIa45cThyFYKSNb8K4YIktknJdQ6ycFQwJrOgpQqbsRm/VyVpAMgln/OOrqfFvwJb7cgKAP9cDJkn0jVBndEihTKg8oTFBj7octYPsjIcIaYFMQuwPVZZMmC0dQuSeTt2cZ0JZXBSbYryG2KW2ZxBmZNRTjCwSrkboNLPfGyqSKQ5mykNAJXe8onLu2Vn9kSJ/LAgMBAAECggEAVrxgMtUXlR45lpgDxb/SdIA+s2wVpqkNfP2BRfjbkR3a36byI21bZ+Rjd4nEgFrDHYcw6fYcW3V3go0IinDBGQnZYtXQ+4Jr8AfDHKSK4M0ixxIp0uwKtdCh7wvPUsDujKfq5qOEiaDzhk7ND/SQgHJFyV+SXKfX07JdIevxHXQKl6hygcM71c7ppvbCvmYJWaqcHWQa1up3SDH1SoBAfsVj9MGoKdcPjOELExVUJAe8VRe7pqCU3/EWZ2R/YSziAsiqieH3JYF+HjT1vMdKrZ4NrcKtFHrdtKz0+7H497hho/932sFoo2UHvK0NRb+HSeBl783982dyA1pMKwCaYQKBgQDn6Q+b7axI7q5dR73faHCkB8MUYEW7ciDBkFExRZC7Pg5rwRXBeJVmQWnoUxjUpKo6pM/7a+i/6/K9tR6n81kLAUxFX88JW8JXCNi+QsMVvaOV8B47bzC6kadkjXuiTj71R3pL+ndJcuthSEKkKj6wPJcjzPqswyn+tEoGM3IMNQKBgQCeofR8Fs0Gn8KwpZ1h57U/WU87hiES3o2tBiFYgoY9LD6rvQqGN/Xo2uvgYZzqACy6uXXa8kzKYnM/Nn2pK1L0mgQhngVUVhKNPNrEr/RLohEgHXuzoVvoJGm+BbBFHLfHJe0QBXZEJha/+wtXXUUbGosOryWVltUMno/G8q17/wKBgQC0Flu0rl/3UsG8VhWwAx5VgmGO1SPRZ9Lf/P3P0UGO5aW1L3+Bee4qNenUK5NArY4zdAC+MRHQ15zsjFV9/o7K6PsddEUF82d6xrfpJ1bu7xC1Qn13keS5PJpMj0HOzAw/1H23uowfUUpPhRma+eMsYCDOAEM5HWTjEYXaQuDxcQKBgHhQ6Ckx9gF/LOBkTLFUV/EbYPAJtI4mRJimHKaQIRbGtyX09MWGLjqVyO/fuW72APcC8XPF8R5Te4vHXZnwpTOmmVmSDALCYcHEFT23Ivg2jPypwAgna5jv/U/F6sMQnActKdfL/L6FkR29YAW8VUzQXgYeK8iApUiz/uLrb0+rAoGARENAskftuyhm32fG5UnNwHuosUl1qZsjuuaoJN70XgD1jHRsuyJ4gCbe+Lfa08kwZ8+Jkci6qWVU+2/T9cUESRE9DXLrI89EcYHtSVj6YqfGb/Dt71UUvyj0aUXhi58M1gTHvK9jKDeb12qxu4HPI5Y/91YJjonHWudJZC/4yQQ=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    private  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqlwnTqiEIAqmAxP2hydbUFx87OYq85tZPMuChelmeVv9pX5gZEk0oL6XuJV7asq0sgD07vPBBR8QbRaM+p+Xt3Sl+NX8bhKUNbWl3adwYpuVKUBQIvLthHZgaYGe1b0bu7PMSxhrPYpjsJTIN99xId0Y6mladyOsU7Uy6dPKvWOqk73/45uJFRkc0KmhzUDAHg2BMVS+a9zwROcJMzCnDhwvNywXdNIYAHjVGwsM7k+ZYrdFh0ya5C6b0oXN60D+niMVY20cRY1Vs3c+vPAOTsafiDEQMJiJgt4/eRoxmWuSHuAYt5uUxE1987MmztQxDFWLyF4NqlhVSGeUila7rQIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    private  String notify_url;

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    private  String return_url;

    // 签名方式
    private  String sign_type = "RSA2";

    // 字符编码格式
    private  String charset = "utf-8";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    private  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    public  String pay(PayVo vo) throws AlipayApiException {

        //AlipayClient alipayClient = new DefaultAlipayClient(AlipayTemplate.gatewayUrl, AlipayTemplate.app_id, AlipayTemplate.merchant_private_key, "json", AlipayTemplate.charset, AlipayTemplate.alipay_public_key, AlipayTemplate.sign_type);
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,
                app_id, merchant_private_key, "json",
                charset, alipay_public_key, sign_type);

        //2、创建一个支付请求 //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        //付款金额，必填
        String total_amount = vo.getTotal_amount();
        //订单名称，必填
        String subject = vo.getSubject();
        //商品描述，可空
        String body = vo.getBody();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //会收到支付宝的响应，响应的是一个页面，只要浏览器显示这个页面，就会自动来到支付宝的收银台页面
        System.out.println("支付宝的响应："+result);

        return result;

    }
}

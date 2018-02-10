 package com.irandoo.support.alipay;

/**
 * Created by yuel on 2018/1/13.
 */
public class AlipayConfig {
    // 合作身份者ID，以2088开头由16位纯数字组成的字符串
    public static String partner = AliPayPropertiesUtil.getAlipayValByKey("partner")+"";
    // 商户的私钥,使用支付宝自带的openssl工具生成。
    public static String private_key=AliPayPropertiesUtil.getAlipayValByKey("private_key")+"";

    // 支付宝的公钥，无需修改该值
   // public static String ali_public_key  = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1chHCiyjStBFemyGIHXUMiywzpcgcRBKZch9XbvbhyxVuzxTq3pxVD04LY9LuggZAINaNL0W3bKzW+kRXu5bEpOk/CYozHkGBOMPK9hqfG/WYB7XX6sF2281pGs0bDauxd1XSe7ieNuoymCsDmfbqDVfzbm0LkSA4SAs1PLk2dhefchUPn2EiwB0YpUODIKO5IOBIHkmq2UlzTY9KMohpORSCr2F9ofqfLMN5FI42PzIdiVPw0coZ/yi+OMmSACrHlxZhW4vLd9UA6Ec9tUQS3/jGV7JlSk/8GxrofxaVq2maT/hKRrn3HCjD/97aWqpuofMTUliu1H2AkBn6J1saQIDAQAB";
    
    public static String ali_public_key = AliPayPropertiesUtil.getAlipayValByKey("ali_public_key")+"";
    
    public static final String SIGN_ALGORITHMS = AliPayPropertiesUtil.getAlipayValByKey("SIGN_ALGORITHMS")+"";

    public static String seller = AliPayPropertiesUtil.getAlipayValByKey("seller")+"";

    // 调试用，创建TXT日志文件夹路径
    public static String log_path = AliPayPropertiesUtil.getAlipayValByKey("log_path")+"";

    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String input_charset = AliPayPropertiesUtil.getAlipayValByKey("input_charset")+"";

    // 签名方式 不需修改
    public static String sign_type = AliPayPropertiesUtil.getAlipayValByKey("sign_type")+"";

    // 接收通知的接口名(这里的域名或者ip需要填写外网可以访问的地址)
    public static String service = AliPayPropertiesUtil.getAlipayValByKey("service")+"";
    //APPID
    public static String app_id = AliPayPropertiesUtil.getAlipayValByKey("app_id")+"";

    public static String serverUrl= AliPayPropertiesUtil.getAlipayValByKey("serverUrl")+"";
}
package com.irandoo.support.wxpay.util;


public class ConstantUtil {


    /**
     * 微信开发平台应用ID
     */
    public static  String APP_ID = LoadingWechatProperties.getWechatValByKey("app_id")+"";
    /**
     * 应用对应的凭证
     */
    public static  String APP_SECRET = LoadingWechatProperties.getWechatValByKey("app_secret")+"";
    /**
     * 应用对应的密钥
     */
    public static  String APP_KEY = LoadingWechatProperties.getWechatValByKey("app_key")+"";
    /**
     * 微信支付商户号
     */
    public static  String MCH_ID = LoadingWechatProperties.getWechatValByKey("mch_id")+"";
    /**
     * 商品描述
     */
    public static  String BUY_BODY = LoadingWechatProperties.getWechatValByKey("buy_body")+"";

    /**
     * 商户id
     */
    public static  String PARTNER_ID = LoadingWechatProperties.getWechatValByKey("partner_id")+"";
    /**
     * 常量固定值
     */
    public static  String GRANT_TYPE = LoadingWechatProperties.getWechatValByKey("grant_type")+"";
    /**
     * 获取预支付id的接口url
     */
    public static String GATEURL = LoadingWechatProperties.getWechatValByKey("gateurl")+"";
    /**
     * 微信服务器回调通知url
     */
    public static String NOTIFY_URL = LoadingWechatProperties.getWechatValByKey("notify_url")+"";



}
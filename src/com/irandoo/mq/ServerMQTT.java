package com.irandoo.mq;

/**
 * Created by admin on 2018/1/11.
 */

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * Title:Server Description: 服务器向多个客户端推送主题，即不同客户端可向服务器订阅相同主题
 *
 * @author yueli 2017年9月1日下午17:41:10
 */
public class ServerMQTT {
    // tcp://MQTT安装的服务器地址:MQTT定义的端口号
    public static final String HOST = "tcp://mqtt.conn123.com:1883";
    // 定义MQTT的ID，可以在MQTT服务配置中指定
    private static final String clientid = "wawa_server";
    public  MqttClient client;
    private String userName = "mosquitto";
    private String passWord = "mosquitto";

    private MqttMessage message;

    private static ServerMQTT instance = new ServerMQTT();
    private ServerMQTT() {
        try{
            client = new MqttClient(HOST, clientid, new MemoryPersistence());
            connect();
        }catch(MqttException e) {
            e.printStackTrace();
        }
    }
    public MqttClient getClient(){
        return this.client;
    }
    public static ServerMQTT getInstance(){
        return instance;
    }

    /**
     * 构造函数
     *
     * @throws MqttException
     */
//    public ServerMQTT() throws MqttException {
//        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
//        client = new MqttClient(HOST, clientid, new MemoryPersistence());
//        connect();
//    }

    /**
     * 用来连接服务器
     */
    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            client.setCallback(new PushCallback());
            client.connect(options);

//            topic11 = client.getTopic(TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param topic
     * @param message
     * @throws MqttPersistenceException
     * @throws MqttException
     */
    public void publish(MqttTopic topic, MqttMessage message) throws MqttPersistenceException, MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
    }

    /**
     * 启动入口
     *
     * @param args
     * @throws MqttException
     */
    public static void main(String[] args) throws MqttException {
        ServerMQTT server = ServerMQTT.getInstance();
        //-------主题--------
        String TOPIC = "ww/room/r0000001";//r0000001表示房间ID
        MqttTopic topic11 = server.getClient().getTopic(TOPIC);

        //--------消息体-----------
        MqttMessage msg = new MqttMessage();
        //设置消息传输的类型
        msg.setQos(1);
        //设置是否在服务器中保存消息体
        msg.setRetained(false);
        String str = "{type:1,content:{roomId:'r0000001',statue:'1'}}";
        msg.setPayload(str.getBytes());

        //--------发送消息----------------
        server.publish(topic11, msg);

        System.out.println(msg.isRetained() + "------ratained状态");
    }
}
package com.irandoo.app.interf.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

import com.alibaba.fastjson.JSON;
import com.irandoo.mq.ServerMQTT;


/**
  * 消息推送工具类
  * <p>Title: </p>
  * <p>Description: </p>
  * <p>Company: irandoo</p> 
  * @author ager
  * @date 2018-1-26下午3:47:36
 */
public class MqUtil {
	/**
	 * @param roomCode 房间code
	 * @param type 消息类别
	 * @param content 消息内容
	 */
	public static Log logger = LogFactory.getLog(MqUtil.class);
	public static void sendMq(String roomCode, String type, Map<String,Object> map){
		Log logger = LogFactory.getLog(MqUtil.class);
		ServerMQTT server = ServerMQTT.getInstance();
        String TOPIC = "ww/room/"+roomCode;
        MqttTopic topic11 = server.getClient().getTopic(TOPIC);
        //————消息体—————
        MqttMessage msg = new MqttMessage();
        //设置消息传输的类型
        msg.setQos(1);
        //设置是否在服务器中保存消息体
        msg.setRetained(false);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("type", type);
        resultMap.put("content", map);
        String json = "";
        try {
            json = JSON.toJSONString(resultMap);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        logger.info("开始发送消息到消息队列");
    	logger.info("消息主题（TOPIC）:"+TOPIC);
    	logger.info("消息类别（TYPE）:"+type);
    	logger.info("消息体（CONTENT）:"+json);
    	logger.info("结束发送消息到消息队列");
        //————发送消息————————
        try {
        	msg.setPayload(json.getBytes("UTF-8"));
			server.publish(topic11, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

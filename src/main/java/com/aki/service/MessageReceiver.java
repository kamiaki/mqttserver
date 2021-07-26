package com.aki.service;

import com.aki.config.Config;
import com.aki.config.MqttConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class MessageReceiver {

    @Autowired
    private MqttClient mqttClient;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = Config.ALARM_MESSAGE_EXCHANGE_NAME, durable = "true"),
            exchange = @Exchange(name = Config.ALARM_MESSAGE_EXCHANGE_NAME, type = "fanout"),
            key = ""))
    @RabbitHandler
    public void onOrderMessage(@Payload String str,
                               @Headers Map<String, Object> headers,
                               Channel channel //手工签收需要rabbitMQ的通道
    ) {
        //消费者操作
        try {
            log.info(str);
            //3.发送mqtt消息
            MqttMessage msg = new MqttMessage();
            msg.setPayload(str.getBytes());//设置消息内容
            msg.setQos(0);//设置消息发送质量，可为0,1,2.
            msg.setRetained(false);//服务器是否保存最后一条消息，若保存，client再次上线时，将再次受到上次发送的最后一条消息。
//            mqttClient.publish(MqttConfig.topic, msg);//设置消息的topic，并发送
            //告诉RabbitMQ我已经签收了
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.aki.service;

import com.aki.config.Config;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Classname MessageSender
 * @Date 2021/6/29 10:05
 * @Created by hanzhao
 */
@Component
public class MessageSender implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        //测试使用代码
        Boolean where = true;
        while (where){
            System.out.println("Sending message...");
            //消息体
            String msg = "消息体" + UUID.randomUUID().toString();
            //暂时未启用信道和路由
            try{
                rabbitTemplate.convertAndSend(Config.ALARM_MESSAGE_EXCHANGE_NAME,"", msg);
            }catch (Exception e){
                e.printStackTrace();
            }
            Thread.sleep(1000);
        }
    }
}

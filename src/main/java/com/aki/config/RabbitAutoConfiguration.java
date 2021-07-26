package com.aki.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitAutoConfiguration {
    /**
     * 定义个alarmGrid交换器 用于生产预警格点数据
     * @return
     */
    @Bean
    public FanoutExchange alarmMsgExchange() {
        return new FanoutExchange(Config.ALARM_MESSAGE_EXCHANGE_NAME);
    }

}

package com.aki.config;

/**
 * @Author ：daniel
 * @Date ：Created in 2021/6/29 8:31
 * @Description ：静态参数配置
 */
public class Config {
     //预警信息交换机
    public static final String ALARM_MESSAGE_EXCHANGE_NAME="ALARM.MESSAGE.EXCHANGE.NAME";


    //预警格点产品消息队列1
    public static final String ALARM_GRID_QUEUE_NAME1="ALARM.GRID.QUEUE.NAME1";
    //预警格点产品消息队列1
    public static final String PROB_GRID_QUEUE_NAME1="PROB.GRID.QUEUE.NAME1";
    //原始雷电字符串数据消息队列1
    public static final String SOURCE_THUNDER_QUEUE_NAME1="SOURCE.THUNDER.QUEUE.NAME1";
    //解析后的雷电PROTO对象消息队列1
    public static final String PROTO_THUNDER_QUEUE_NAME1="PROTO.THUNDER.QUEUE.NAME1";
    //预警信息消息队列1
    public static final String ALARM_MESSAGE_QUEUE_NAME1="ALARM.MESSAGE.QUEUE.NAME1";
}

package com.yyn.serve.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * rabbitMQ 生产者
 */
public class RabbitPro {

    private static final String host = "127.0.0.1";
    private static final int port = 5672;
    private static final String userName = "guest";
    private static final String password = "guest";

    private static final String exchange_demo = "exchange_demo";
    private static final String queue_name = "queue_name";
    private static final String route_demo = "route_demo";
    private static final String exchangeType = "direct";



    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        //创建连接
        final Connection connection = connectionFactory.newConnection();
        //创建信道
        final Channel channel = connection.createChannel();
        //创建交换机
        channel.exchangeDeclare(exchange_demo,exchangeType,true,false,null);
        //创建队列
        channel.queueDeclare(queue_name,true,false,false,null);
        //交换机和队列通过路由键绑定
        channel.queueBind(queue_name,exchange_demo,route_demo);
        //发送持久化消息
        String message = "hello world";
        channel.basicPublish(exchange_demo,route_demo, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());

        //关闭资源
        channel.close();
        connection.close();
    }

}

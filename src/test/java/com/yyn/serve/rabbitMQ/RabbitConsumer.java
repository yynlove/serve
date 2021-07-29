package com.yyn.serve.rabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer {

    private static final String host = "127.0.0.1";
    private static final int port = 5672;
    private static final String userName = "guest";
    private static final String password = "guest";

    private static final String exchange_demo = "exchange_demo";
    private static final String queue_name = "queue_name";
    private static final String route_demo = "route_demo";
    private static final String exchangeType = "direct";


    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        final Address[] address = new Address[]{new Address(host,port)};
        final ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        //创建连接
        final Connection connection = connectionFactory.newConnection(address);
        //创建信道
        final Channel channel = connection.createChannel();

        channel.basicQos(64);
        final Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接受消息："+ new String(body));
                System.out.println(consumerTag);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        //信道设置为接收默哀模式
        channel.basicConsume(queue_name,consumer);
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }


}

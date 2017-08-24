package com.mingjian.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *  消息生产者
 */
public class RabbitProducer {
    private static String QUEUE_NAME="hello";
    public static void main(String... args) throws Exception{
        //create factory
        ConnectionFactory factory=new ConnectionFactory();
        //set host
        factory.setHost("localhost");
        //create new conn
        Connection connection=factory.newConnection();
        //create channel
        Channel channel = connection.createChannel();
        //declare queue
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //def message
        String message="hello world";
        //publish message
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes("UTF-8"));

        System.out.println("RabbitHello1 [X] sent'"+message+"'");
        //close channel and conn
        channel.close();
        connection.close();

    }
}

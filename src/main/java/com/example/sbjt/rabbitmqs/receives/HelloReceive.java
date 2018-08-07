package com.example.sbjt.rabbitmqs.receives;

import org.springframework.stereotype.Component;

/**
 * @auth: Created by zk on 2018/7/27
 * @description:
 */
@Component
public class HelloReceive {

    //@RabbitListener(queues = "hello")
    public void helloReceive(String msg){

        System.out.println("receive from hello: " + msg );

    }

}

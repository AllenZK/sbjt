package com.example.sbjt.rabbitmqs.sends;

import com.example.sbjt.common.annos.Alog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth: Created by zk on 2018/7/27
 * @description:
 */
@RestController
@RequestMapping("/rabbitmq")
public class HelloSend {

    @Autowired
    //private AmqpTemplate amqpTemplate;


    @Alog("rabbitmq发送方")
    @RequestMapping
    public String send(){
        //amqpTemplate.convertAndSend("hello","我在往hello队列发消息，direct模式：一对一模式！");
        return "direct 模式消息发送";
    }
}

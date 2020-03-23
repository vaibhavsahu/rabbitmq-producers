package com.vaibhav.example.rabbitmqproducer;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${test.rabbitmq.exchange}")
    private String exchange;

    @Value("${test.rabbitmq.routingkey}")
    private String routingKey;

    public void send(Employee company) {
        amqpTemplate.convertAndSend(exchange, routingKey, company);
        System.out.println("Send msg = " + company);
    }

}

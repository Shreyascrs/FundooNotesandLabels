package com.bridgeit.fundoo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${fundoo.rabbitmq.exchange}")
	private String exchange;

	@Value("${fundoo.rabbitmq.exchange_key}")
	private String routingkey;

	@Value("${fundoo.rabbitmq.queue}")
	private String queueName;

	public void send(Object obj) {
		System.out.println(exchange + "    " + routingkey);
		System.out.println("Send msg = " + obj.toString());
		rabbitTemplate.convertAndSend(exchange, routingkey, obj);
	}

	@RabbitListener(queues = "note.queue")
	public void Reciver(Object object) {
		System.out.println("entered to listner of rabbit mq");
		System.out.println(object.toString());

	}
}

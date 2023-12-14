package com.springbootrabbitmq.example.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMq {

	//spring bean for rabbitmq queue
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	@Value("${rabbitmq.routing.json.key}")
	private String jsonRoutingKey;
	
	@Value("${rabbitmq.queue.json.name}")
	private String jsonQueue;
	
	/*@Value("${rabbitmq.exchange.json.name}")
	private String jsonExchange;
	*/
	@Bean
	public Queue  queue() {
		return new Queue(queue); 
	}
	
	@Bean
	public Queue  jsonqueue() {
		return new Queue(jsonQueue); 
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	
	//binding between queue and exchange using routing key
	@Bean
	public Binding binding() {
		return BindingBuilder
				.bind(queue())
				.to(exchange())
				.with(routingKey);
	}
	
	//binding between json queue and exchange using routing key
		@Bean
		public Binding jsonBinding() {
			return BindingBuilder
					.bind(jsonqueue())
					.to(exchange())
					.with(jsonRoutingKey);
		}
	
	//connectionFactory
	//rabbitTemplate
	//rabbitadmin
		
@Bean
public MessageConverter converter() {

	return new Jackson2JsonMessageConverter();
}

@Bean
public AmqpTemplate amqptemplate(ConnectionFactory connectionFactory) {
	RabbitTemplate rabbitTemaplate = new RabbitTemplate(connectionFactory);
	rabbitTemaplate.setMessageConverter(converter());
	return rabbitTemaplate;
	
}
	
}

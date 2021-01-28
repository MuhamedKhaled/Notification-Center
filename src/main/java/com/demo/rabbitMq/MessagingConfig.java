package com.demo.rabbitMq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;



// configuration file that responsible to configure rabbitMQ message
// Exchange and queue and binding

@Configuration
public class MessagingConfig {

    // const variables that declare keys for creating queue
    // it should be declared in config file but i declared them here for demo
    public static final String QUEUE = "notification_queue";
    public static final String EXCHANGE = "rabbitmq_exchange";
    public static final String ROUTING_KEY = "notification_queue_routingKey";

    // creating queue bean
    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    // creating exchange bean
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    // bind exchange and queue using routing key
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    // create bean for message converter
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    // create rabbit template and add message converter to it
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}

package servicos.email.main.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
	
	//FILA
	@Value("${spring.rabbitmq.queue}")
    private String queue;
	
	//dois parametros
	//nome da fila e se a fila vai ser duravel ou não
	@Bean
	 public Queue queue() {
        return new Queue(queue, true);
	}
	
	
	//CRIA CONVERSOR PARA JSON
	@Bean
	 public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
	}
}

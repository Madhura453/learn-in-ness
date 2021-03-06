package com.reddis.Integration4.all;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;



@Configuration
@EnableIntegration
@IntegrationComponentScan("com.springboot")
public class IntegrationConfig {
@Bean
public JedisConnectionFactory jedisConnectionFactory()
{
	JedisConnectionFactory factory=new JedisConnectionFactory();
	//factory.setHostName(null);
	//factory.setPort(0);
	return factory;
}
@Bean
public DirectChannel receiverchannel()
{
	return new DirectChannel();
}
@Bean
public RedisQueueMessageDrivenEndpoint consumerEndPoint()
{
	RedisQueueMessageDrivenEndpoint endPoint=new RedisQueueMessageDrivenEndpoint
			("Redis-queue",jedisConnectionFactory());
	endPoint.setOutputChannelName("receiverChannel");
	return endPoint;
}

}






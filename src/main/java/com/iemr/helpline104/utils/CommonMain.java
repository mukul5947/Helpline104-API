package com.iemr.helpline104.utils;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

import com.iemr.helpline104.utils.config.ConfigProperties;
import com.iemr.helpline104.utils.km.KMService;
import com.iemr.helpline104.utils.km.openkm.OpenKMServiceImpl;
import com.iemr.helpline104.utils.redis.RedisStorage;

@EnableAutoConfiguration
public class CommonMain
{
	@Bean
	public ConfigProperties configProperties()
	{
		return new ConfigProperties();
	}

//	@Bean
//	public SessionObject sessionObject()
//	{
//		return new SessionObject();
//	}

	// @Beanss
	// public RedisConnection redisConnection()
	// {
	// return new RedisConnection();
	// }

	// @Configuration
	// @EnableRedisHttpSession
	// public class Config {

//	@Bean
//	public LettuceConnectionFactory connectionFactory()
//	{
//		return new LettuceConnectionFactory();
//	}
	// }

	@Bean
	public RedisHttpSessionConfiguration redisSession()
	{
		return new RedisHttpSessionConfiguration();
	}

	@Bean
	public KMService getOpenKMService()
	{
		KMService kmService = new OpenKMServiceImpl();
		return kmService;
	}

	@Bean
	public RedisStorage redisStorage()
	{
		return new RedisStorage();
	}
	// public static void main(String[] args) {
	// SpringApplication.run(CommonMain.class, args);
	// }
}

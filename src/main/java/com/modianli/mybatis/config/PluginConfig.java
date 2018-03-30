package com.modianli.mybatis.config;

import com.modianli.mybatis.interceptor.AuthorInterceptor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PluginConfig {

	@Bean
	@ConditionalOnMissingBean
	public AuthorInterceptor authorInterceptor(){
		System.out.println("testssssssssssssssssssssss....");
		return new AuthorInterceptor();
	}
}

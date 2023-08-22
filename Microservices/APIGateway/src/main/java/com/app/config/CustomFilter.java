package com.app.config;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;


public class CustomFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
		List<String> list = headers.get("keys");
		String first2 = headers.getFirst("Encript");
		String first = headers.getFirst("key");
		System.out.println("key value :: "+first);
		list.forEach(System.out::println);
		System.out.println("key value3 :: "+first2);
				
	return  chain.filter(exchange);
		
		
	}
	
	
	

}

package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PostsServiceDelegate {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	public Post getPost() {
		return restTemplate.getForObject("http://localhost:9092/posts/1", Post.class);

	}

	@SuppressWarnings("unused")
	private Post fallback() {
		return new Post(0, 0, "Fallback", "Circuit Broken. The Post Service is down");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

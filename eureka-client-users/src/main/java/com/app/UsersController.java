package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UsersController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/users/{name}")
	public Post getUser(@PathVariable String name) {
		return restTemplate.getForObject("http://posts-service/posts/1", Post.class);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
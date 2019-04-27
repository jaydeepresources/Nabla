package com.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UsersController {

	@GetMapping("/users/{name}")
	public Post getUser(@PathVariable String name) {

		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject("http://localhost:8082/posts/1", Post.class);
		
		// restTemplate.getForObject("http://localhost:8082/posts/1", Post.class);

	}

}
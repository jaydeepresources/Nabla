package com.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {

	@GetMapping("/posts/{userId}")
	public Post getPost(@PathVariable int userId) {
		return new Post(1, userId, "title of post", "body of post");
	}

}

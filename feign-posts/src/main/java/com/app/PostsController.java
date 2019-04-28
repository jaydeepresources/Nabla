package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {

	@Autowired
	PostsClient postsClient;

	@GetMapping("/posts")
	public List<Post> getPost() {
		return postsClient.getPosts();
	}

	@GetMapping("/posts/{id}")
	public Post getPost(@PathVariable int id) {
		return postsClient.getPost(id);
	}

}

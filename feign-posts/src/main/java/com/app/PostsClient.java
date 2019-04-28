package com.app;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "posts-service", url = "http://jsonplaceholder.typicode.com/")
public interface PostsClient {

	@GetMapping("/posts")
	public List<Post> getPosts();

	@GetMapping("/posts/{id}")
	public Post getPost(@PathVariable("id") int id);

}

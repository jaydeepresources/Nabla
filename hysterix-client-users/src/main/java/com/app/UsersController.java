package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
	
	@Autowired
	PostsServiceDelegate postsServiceDelegate;

	@GetMapping("/users/{name}")
	public Post getUser(@PathVariable String name) {

		 return postsServiceDelegate.getPost();
		
	}

}
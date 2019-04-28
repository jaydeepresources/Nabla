package com.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

	@GetMapping("/details/{name}")
	public User getUser(@PathVariable String name) {

		return new User(1,name,"9878765654");

	}

}
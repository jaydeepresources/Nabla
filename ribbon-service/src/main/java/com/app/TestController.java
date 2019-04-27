package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	Environment environment;

	@GetMapping("/hitme")
	public String backend() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println("Sleeping");
		}
		String serverPort = environment.getProperty("local.server.port");
		return "You Hit me ! :: Port : " + serverPort;
	}
}

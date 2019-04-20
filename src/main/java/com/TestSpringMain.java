package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

//		HelloWorld obj = (HelloWorld) context.getBean("helloWorld2");
//
//		System.out.println("Msg from spring: " + obj.getMsg());

		 Circle c = (Circle) context.getBean("circle");
		 System.out.println(c);

	}
}

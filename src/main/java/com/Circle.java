package com;

public class Circle {

	String name;
	int radius;

	public Circle(String name, int radius) {
		this.name = name;
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [name=" + name + ", radius=" + radius + "]";
	}

}

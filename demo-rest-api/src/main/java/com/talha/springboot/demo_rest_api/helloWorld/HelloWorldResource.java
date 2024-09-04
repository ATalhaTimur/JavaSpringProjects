package com.talha.springboot.demo_rest_api.helloWorld;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	
	@RequestMapping("/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	

	@RequestMapping("/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@RequestMapping("/hello-world-path-param/{name}")
	public HelloWorldBean HelloWorldPathParam(@PathVariable String name) {
		return new HelloWorldBean("Hello World," + name);
	}
	
}

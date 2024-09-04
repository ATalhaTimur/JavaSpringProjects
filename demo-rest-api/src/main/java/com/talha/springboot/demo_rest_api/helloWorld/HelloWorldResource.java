package com.talha.springboot.demo_rest_api.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldResource {
	
	@RequestMapping("/hello-world")
	@ResponseBody
	public String HelloWorld() {
		return "Hello World";
	}
	
}

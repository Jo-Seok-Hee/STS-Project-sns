package com.sucky.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	
	@RequestMapping("/hello")
	public String test() {
		return "hello world";
	}
}

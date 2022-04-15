package com.controller.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "Hello Visitor!";
	}
	@GetMapping("/task")
	public String sendTaskMessage() {
		return "Task demonstration";
	}
}
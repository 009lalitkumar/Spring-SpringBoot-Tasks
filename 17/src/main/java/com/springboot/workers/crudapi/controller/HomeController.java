package com.springboot.workers.crudapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.util.Utils;

@RestController
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "Hello Visitor!  \nVisiting time: "+Utils.getCurrentTimestamp();
	}
	
}
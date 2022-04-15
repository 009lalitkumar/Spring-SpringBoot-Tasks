package com.controller.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@GetMapping("/showMyInfo")
	public List<String> showMyInfo(){
		return List.of("Lalit", "Gurgaon", "Haryana");
	}
	
	@GetMapping("/showMyHobbies")
	public List<String> showMyHobbies(){
		return List.of("Playing badminton", "Anime", "Music");
	}
}

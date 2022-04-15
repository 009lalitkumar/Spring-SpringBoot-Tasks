package com.springboot.workers.crudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.service.WorkerService;
import com.springboot.workers.crudapi.util.Utils;

@RestController
public class HomeController {
	@Autowired
	private WorkerService service;
	
	@GetMapping("/")
	public String index() {
		return "Hello Visitor!  \nVisiting time: "+Utils.getCurrentTimestamp();
	}
	
	@GetMapping("/worker")
	public Worker showWorker(@RequestParam int worker_id) {
		return service.getWorker(worker_id);
	}
}
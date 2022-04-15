package com.controller.demo.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.demo.models.Worker;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	@GetMapping("/showWorker")
	public Worker showWorker() {
		return new Worker(1,"HellCreator@gmail.com");
	}
	@GetMapping("/all/showWorkers")
	public List<Worker> showAllWorkers() {
		return List.of(new Worker(1, "Rias", "Gremory", 12000,new Date() ,"new","rias@gmail.com"),
		 new Worker(2, "Mai", "Sakurajima", 15000,new Date() , "new","mai@gmail.com"),
		 new Worker(3, "Juuzou", "Suzuya", 17500,new Date() , "new","juuzu@gmail.com"));
	}
}

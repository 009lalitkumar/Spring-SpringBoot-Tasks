
package com.springboot.workers.springjdbcexample.controller;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbcexample.model.Worker;
import com.springboot.workers.springjdbcexample.repository.WorkerRepository;



@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping("/showWorker")
	public Worker showWorker() throws SQLException {
		return this.workerRepository.getWorkerById(5);
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showAllWorkers() throws SQLException {
		return this.workerRepository.getAllWorkers();
	}
	
	@GetMapping("/create")
	public String createWorker() throws SQLException {
		return this.workerRepository.addWorker(new Worker(9, "Disha", "Maurya", 452769,
				new java.sql.Date(new Date().getTime()), "IT", "Xyz@gmail.com"));
	}
	
	@GetMapping("/update")
	public String updateWorker() throws SQLException {
		return this.workerRepository.updateWorker(new Worker(9, "Lalit", "Kumar", 452769,
				new java.sql.Date(new Date().getTime()), "IT", "mfs.akash@gmail.com"));
	}
	
	@GetMapping("/delete")
	public String deleteWorker() throws SQLException {
		this.workerRepository.deleteWorkerById(9);
		return "Record deleted";
	}
}

package com.springboot.workers.crudapi.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping("/{id}")
	public Worker showWorker(@PathVariable int id) throws SQLException {
		return this.workerRepository.getWorkerById(id);
	}
	
	@GetMapping("/all")
	public List<Worker> showAllWorkers() throws SQLException {
		return this.workerRepository.getAllWorkers();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public int createWorker(@RequestBody Worker worker) throws SQLException {
		return this.workerRepository.addWorker(worker);
	}
	
	@PatchMapping("/update/{id}")
	public String updateWorker(@RequestBody Map<String,String> params,@PathVariable int id) throws SQLException {
		int rowsAffected = this.workerRepository.updateWorkerEmailById(params.get("email"),id);
		return rowsAffected + " rows Affected";
	}
	
	@DeleteMapping("/delete/{id}")
	public int deleteWorker(@PathVariable int id) throws SQLException {
		return this.workerRepository.deleteWorkerById(id);
	}
}

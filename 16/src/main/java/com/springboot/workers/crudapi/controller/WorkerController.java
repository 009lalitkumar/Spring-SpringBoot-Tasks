package com.springboot.workers.crudapi.controller;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerService service;

	@GetMapping("/{id}")
	public Worker showWorker(@PathVariable int id) {
		return service.getWorker(id);
	}

	@GetMapping("/all")
	public List<Worker> showWorkers() {
		return service.getAllWorkers();

	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@RequestBody Worker worker) {
		return service.addWorker(worker);
	}
	
	@PostMapping(path ="/createByForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public boolean createByForm(@RequestParam MultiValueMap<String,String> paramMap) {
		return service.addWorker(new Worker(Integer.parseInt(paramMap.getFirst("worker_id")),paramMap.getFirst("first_name"),paramMap.getFirst("last_name"),
				Integer.parseInt(paramMap.getFirst("salary")),java.sql.Date.valueOf(paramMap.getFirst("joining_date")),paramMap.getFirst("department"),paramMap.getFirst("email") 
				) );
	}

	@PatchMapping("/update/{id}")
	public boolean update(@PathVariable int id, @RequestBody Map<String, String> map) {
		return service.updateEmailById(id, map.get("email"));

	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id) {

		return service.deleteById(id);

	}
}
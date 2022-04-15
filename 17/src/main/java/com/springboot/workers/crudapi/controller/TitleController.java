package com.springboot.workers.crudapi.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.model.Title;
import com.springboot.workers.crudapi.service.TitleService;

@RestController
public class TitleController {

	@Autowired
	private TitleService service;
	
	@GetMapping("/worker/title/{id}")
	public Title getTitleById(@PathVariable int id) throws SQLException {
		return service.getTitleById(id);
	}
	
	@GetMapping("dept/{dept}/all")
	public List<Title> getAllWorkerTitle(@PathVariable String dept) throws SQLException{
		return service.getTitleByDept(dept);
	}
	
	@PostMapping("worker/{id}/promote/{title}")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean promoteWorker(@PathVariable int id,@RequestBody Title title) throws SQLException {
		return service.addTitle(title);
	}
	
	@DeleteMapping("/worker/{id}/demote")
	public boolean demoteWorker(@PathVariable int id) throws SQLException {
		return service.deleteTitleById(id);
	}
	
	
}

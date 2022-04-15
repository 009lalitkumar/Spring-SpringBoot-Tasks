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

import com.springboot.workers.crudapi.model.Bonus;
import com.springboot.workers.crudapi.service.BonusService;

@RestController
public class BonusController {
	@Autowired
	private BonusService service;
	
	@GetMapping("/worker/bonus/{id}")
	public List<Bonus> getBonusById(@PathVariable int id) throws SQLException {
		return service.getBonusById(id);
	}
	
	@GetMapping("dept/{dept}/bonuses")
	public List<Bonus> getBonusByDept(@PathVariable String dept) throws SQLException{
		return service.getBonusByDept(dept);
	}
	
	@PostMapping("worker/{id}/bonus/new")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean addBonusById(@RequestBody Bonus bonus) throws SQLException {
		return service.addBonus(bonus);
	}
	
	@DeleteMapping("/worker/{id}/bonus/latest")
	public boolean deleteLatestBonus(@PathVariable int id) throws SQLException {
		return service.deleteBonusById(id);
	}
	
}

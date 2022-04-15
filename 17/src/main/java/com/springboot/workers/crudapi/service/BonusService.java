package com.springboot.workers.crudapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.workers.crudapi.model.Bonus;
import com.springboot.workers.crudapi.repository.BonusRepository;

@Service
public class BonusService {
	
	@Autowired
	private BonusRepository bonusRepository;

	public boolean addBonus(Bonus bonus) throws SQLException {
			return bonusRepository.addBonus(bonus);
	}
	
	public List<Bonus> getBonusById(int id) throws SQLException {
		return  bonusRepository.getBonusById(id);
	}

	public List<Bonus> getAllBonus() throws SQLException {
			return bonusRepository.getAllBonus();
	}
	
	public boolean updateBonus(Bonus bonus) throws SQLException {
		return bonusRepository.updateBonus(bonus);
	}
	
	public boolean deleteBonusById(int workerRefId) throws SQLException {
		return bonusRepository.deleteBonusById(workerRefId);
	}

	public List<Bonus> getBonusByDept(String dept) throws SQLException {
		return bonusRepository.getAllBonusByDeptId(dept);
	}
}

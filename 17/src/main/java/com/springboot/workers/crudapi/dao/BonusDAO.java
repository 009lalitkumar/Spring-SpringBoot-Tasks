package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Bonus;

public interface BonusDAO {
	public boolean addBonus(Bonus bonus)
            throws SQLException;

	public List<Bonus> getBonusById(int workerRefId)
            throws SQLException;

	public List<Bonus> getAllBonus()
            throws SQLException;

	public boolean updateBonus(Bonus bonus)
            throws SQLException;
	public boolean deleteBonusById(int workerRefId)
            throws SQLException;

	List<Bonus> getAllBonusByDeptId(String dept)throws SQLException;

}

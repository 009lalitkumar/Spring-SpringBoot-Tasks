package com.springboot.workers.crudapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.BonusDAO;
import com.springboot.workers.crudapi.model.Bonus;
import com.springboot.workers.crudapi.util.DatabaseConnection;

@Repository
public class BonusRepository implements BonusDAO {
	private Connection connection;


    public BonusRepository() throws Exception {
        this.connection = DatabaseConnection.getConnection();
    }
	@Override
	public boolean addBonus(Bonus bonus) throws SQLException {
		String addQuery = "insert into Bonus values(?,?,?)";
		PreparedStatement statement = connection.prepareStatement(addQuery);
		statement.setInt(1, bonus.getWorkerRefId());
		statement.setInt(2, bonus.getBonusAmount());
		statement.setDate(3, bonus.getBonusDate());
		int row = statement.executeUpdate();
		if(row>0)
			return true;
		return false;
	}

	@Override
	public List<Bonus> getBonusById(int workerRefId) throws SQLException {
		List<Bonus> list = new ArrayList<>();
		String query = "select * from bonus where worker_ref_id="+workerRefId;
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			list.add(new Bonus(rs.getInt(1),rs.getInt(2),rs.getDate(3)));
		}
		return list;
	}

	@Override
	public List<Bonus> getAllBonus() throws SQLException {
		List<Bonus> list = new ArrayList<>();
		String query = "select * from bonus";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			list.add(new Bonus(rs.getInt(1),rs.getInt(2),rs.getDate(3)));
		}
		return list;
	}

	@Override
	public boolean updateBonus(Bonus bonus) throws SQLException {
		String updateQuery = "update bonus set bonus_amount=?, bonus_date=? where worker_ref_id=?";
		PreparedStatement statement = connection.prepareStatement(updateQuery);
		statement.setInt(1, bonus.getBonusAmount());
		statement.setDate(2, bonus.getBonusDate());
		statement.setInt(3, bonus.getWorkerRefId());
		return statement.executeUpdate()>0;
		
	}

	@Override
	public boolean deleteBonusById(int workerRefId) throws SQLException {
		String deleteQuery = "delete from bonus where worker_ref_id=" + workerRefId + " order by bonus_date desc limit 1";
		Statement st = connection.createStatement();
		return st.executeUpdate(deleteQuery)>0;
	}
	
	@Override
	public List<Bonus> getAllBonusByDeptId(String dept)throws SQLException {
		List<Bonus> list = new ArrayList<>();
		String query = "select * from bonus b inner join worker w on w.worker_id=b.worker_ref_id where department=\""+dept+"\"";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			list.add(new Bonus(rs.getInt(1),rs.getInt(2),rs.getDate(3)));
		}
		return list;
	}

}

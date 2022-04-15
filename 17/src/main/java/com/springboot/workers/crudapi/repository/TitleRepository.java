package com.springboot.workers.crudapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.TitleDAO;
import com.springboot.workers.crudapi.model.Title;
import com.springboot.workers.crudapi.util.DatabaseConnection;

@Repository
public class TitleRepository implements TitleDAO {
	private Connection connection;


    public TitleRepository() throws Exception {
        this.connection = DatabaseConnection.getConnection();
    }
	@Override
	public boolean addTitle(Title title) throws SQLException {
		String addQuery = "Insert into title values(?,?,?)";
		PreparedStatement statement = connection.prepareStatement(addQuery);
		statement.setInt(1, title.getWorkerRefId());
		statement.setString(2, title.getWorkerTitle());
		statement.setDate(3, title.getAffectedFrom());
		return statement.executeUpdate()>0;
	}

	@Override
	public Title getTitleById(int workerRefId) throws SQLException {
		String query = "Select * from title where worker_ref_id = \""+workerRefId+"\"order by affected_from desc limit 1";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		
		return new Title(rs.getInt(1),rs.getString(2),rs.getDate(3));
	}

	@Override
	public List<Title> getAllTitle() throws SQLException {
		List<Title> list = new ArrayList<>();
		String query = "Select * from title";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			list.add(new Title(rs.getInt(1),rs.getString(2),rs.getDate(3)));
		}
		return list;
	}

	@Override
	public boolean updateTitle(Title title) throws SQLException {
		String updateQuery = "Update title set worker_title = ?,affected_from=? where worker_ref_id = ?";
		PreparedStatement statement = connection.prepareStatement(updateQuery);
		statement.setString(1, title.getWorkerTitle());
		statement.setDate(2, title.getAffectedFrom());
		statement.setInt(3, title.getWorkerRefId());
		return statement.executeUpdate()>0;
	}

	@Override
	public boolean deleteTitleById(int workerRefId) throws SQLException {
		String deleteQuery = "delete from title where worker_ref_id = \""+workerRefId+"\" order by affected_from desc limit 1";
		Statement st = connection.createStatement();
		return st.executeUpdate(deleteQuery)>0;
	}
	
	@Override
	public List<Title> getTitleByDept(String dept) throws SQLException {
		List<Title> list = new ArrayList<>();
		String query = "select * from title t inner join worker w on w.worker_id=t.worker_ref_id where department=\""+dept+"\"";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			list.add(new Title(rs.getInt(1),rs.getString(2),rs.getDate(3)));
		}
		return list;
	}

}

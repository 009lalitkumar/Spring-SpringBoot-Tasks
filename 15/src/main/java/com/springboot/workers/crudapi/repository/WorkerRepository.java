package com.springboot.workers.crudapi.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.util.DatabaseConnection;
@Repository
public class WorkerRepository implements WorkerDAO {

	Connection conn;

    public WorkerRepository() throws Exception {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public int addWorker(Worker worker) throws SQLException {
        String insertQuery = "INSERT INTO Worker VALUES(?,?,?,?,?,?,? )";

        PreparedStatement pstmt = conn.prepareStatement(insertQuery);
        pstmt.setInt(1, worker.getWorkerId());
        pstmt.setString(2, worker.getFirstName());
        pstmt.setString(3, worker.getLastName());
        pstmt.setInt(4, worker.getSalary());
        pstmt.setDate(5, worker.getJoiningDate());
        pstmt.setString(6, worker.getDepartment());
        pstmt.setString(7, worker.getEmail());
        return pstmt.executeUpdate();

    }

    @Override
    public int deleteWorkerById(int workerId) throws SQLException {
        String deleteQuery = "DELETE FROM worker WHERE worker_id = " + workerId;
        try (Statement statement = conn.createStatement()) {
            return statement.executeUpdate(deleteQuery);
        }
    }

    @Override
    public Worker getWorkerById(int workerId) throws SQLException {
    	String query = "SELECT * FROM worker Where worker_id = ?";
    	PreparedStatement st = conn.prepareStatement(query);
    	st.setInt(1, workerId);
    	ResultSet rs = st.executeQuery();
    	rs.next();
    	return new Worker(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getString(6),rs.getString(7));
    }

    @Override
    public List<Worker> getAllWorkers() throws SQLException {
        String query = "SELECT * FROM worker";
        List<Worker> list = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                int workerId = result.getInt("worker_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                int salary = result.getInt("salary");
                Date date = result.getDate("joining_date");
                String department = result.getString("department");
                String email = result.getString("email");

                list.add(new Worker(workerId, firstName, lastName, salary, date, department, email));
            }
        }

        return list;
    }

	@Override
	public int updateWorkerEmailById(String email,int id) throws SQLException{
		String updateQuery = "UPDATE Worker SET email = ? WHERE worker_id = ?";

        PreparedStatement pstmt = conn.prepareStatement(updateQuery);
        pstmt.setString(1, email);
        pstmt.setInt(2, id);
        return pstmt.executeUpdate();
	}
}

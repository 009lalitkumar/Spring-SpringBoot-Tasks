package com.springboot.workers.jdbcexample.repository;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.springboot.workers.jdbcexample.dao.WorkerDAO;
import com.springboot.workers.jdbcexample.model.Worker;
import com.springboot.workers.jdbcexample.util.DatabaseConnection;

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
    public int updateWorker(Worker emp) throws SQLException {
        String updateQuery = "UPDATE Worker SET worker_id =?,first_name = ?, last_name =?, salary =?, joining_date = ?, department = ?, email = ? WHERE worker_id = ?";

        PreparedStatement pstmt = conn.prepareStatement(updateQuery);
        pstmt.setInt(1, emp.getWorkerId());
        pstmt.setString(2, emp.getFirstName());
        pstmt.setString(3, emp.getLastName());
        pstmt.setInt(4, emp.getSalary());
        pstmt.setDate(5, emp.getJoiningDate());
        pstmt.setString(6, emp.getDepartment());
        pstmt.setString(7, emp.getEmail());
        pstmt.setInt(8, emp.getWorkerId());
        return pstmt.executeUpdate();

    }

}


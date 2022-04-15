package com.springboot.workers.springjdbcexample.repository;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.springjdbcexample.dao.WorkerDAO;
import com.springboot.workers.springjdbcexample.mapper.WorkerMapper;
import com.springboot.workers.springjdbcexample.model.Worker;


@Repository
public class WorkerRepository implements WorkerDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

    @Override
    public String addWorker(Worker worker) throws SQLException {
        String insertQuery = "INSERT INTO Worker VALUES(?,?,?,?,?,?,? )";

        jdbcTemplate.update(insertQuery, worker.getWorkerId(), worker.getFirstName(), worker.getLastName(),
				worker.getSalary(), worker.getJoiningDate(), worker.getDepartment(), worker.getEmail());

		return("new Record created");

    }

    @Override
    public void deleteWorkerById(int workerId) throws SQLException {
        String deleteQuery = "DELETE FROM worker WHERE worker_id = ?";
        jdbcTemplate.update(deleteQuery, workerId);
		System.out.println("Record deleted");
    }

    @SuppressWarnings("deprecation")
	@Override
    public Worker getWorkerById(int workerId) throws SQLException {
    	String query = "SELECT * FROM worker Where worker_id = ?";
    	return jdbcTemplate.queryForObject(query, new Object[] { workerId }, new WorkerMapper());
    }

    @Override
    public List<Worker> getAllWorkers() throws SQLException {
        String query = "SELECT * FROM worker";
        List<Worker> list = jdbcTemplate.query(query, new WorkerMapper());
		return list;
    }

    @Override
    public String updateWorker(Worker emp) throws SQLException {
        String updateQuery = "UPDATE Worker SET worker_id =?,first_name = ?, last_name =?, salary =?, joining_date = ?, department = ?, email = ? WHERE worker_id = ?";

        jdbcTemplate.update(updateQuery, emp.getWorkerId(), emp.getFirstName(), emp.getLastName(), emp.getSalary(),
				emp.getJoiningDate(), emp.getDepartment(), emp.getEmail(), emp.getWorkerId());
		return("Record Updated");

    }

}
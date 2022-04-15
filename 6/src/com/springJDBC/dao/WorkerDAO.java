package com.springJDBC.dao;


import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.springJDBC.model.Worker;

public interface WorkerDAO {
	
	public void setDataSource(DataSource dataSource);
	
	void updateWorker(Worker emp) throws SQLException;

	List<Worker> getAllWorkers() throws SQLException;

	void addWorker(Worker worker) throws SQLException;

	void deleteWorkerById(int workerId) throws SQLException;

	Worker getWorkerById(int workerId) throws SQLException;
}

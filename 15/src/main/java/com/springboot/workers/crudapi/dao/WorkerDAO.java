package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Worker;

public interface WorkerDAO {
	public int updateWorkerEmailById(String email,int id)
			throws SQLException;;
	
    public int addWorker(Worker worker)
            throws SQLException;

    public int deleteWorkerById(int workerId)
            throws SQLException;

    public Worker getWorkerById(int workerId)
            throws SQLException;

    public List<Worker> getAllWorkers()
            throws SQLException;

}
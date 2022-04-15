package com.springboot.workers.springjdbcexample.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.springjdbcexample.model.Worker;


public interface WorkerDAO {
    public String addWorker(Worker worker)
            throws SQLException;

    public void deleteWorkerById(int workerId)
            throws SQLException;

    public Worker getWorkerById(int workerId)
            throws SQLException;

    public List<Worker> getAllWorkers()
            throws SQLException;

    public String updateWorker(Worker emp)
            throws SQLException;
}
package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.springboot.workers.crudapi.model.Worker;


public interface WorkerDAO {
        public boolean add(Worker worker)
                        throws SQLException;

        public boolean delete(int workerId)
                        throws SQLException;

        public Worker getWorker(int workerId)
                        throws SQLException;

        public List<Worker> getWorkers()
                        throws SQLException;

        public boolean update(int id,String email)
                        throws SQLException;

		List<Map<String, String>> getFullWorkerInfo() throws SQLException;
}

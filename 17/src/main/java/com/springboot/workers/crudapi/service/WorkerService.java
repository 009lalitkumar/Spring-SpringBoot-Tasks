package com.springboot.workers.crudapi.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {
	@Autowired
	private WorkerRepository workerRepository;

	public Worker getWorker(int id) {

		try {
			return workerRepository.getWorker(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Worker> getAllWorkers() {
		try {
			return workerRepository.getWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
			return List.of();
		}
	}

	public boolean addWorker(Worker worker) {
		try {
			return workerRepository.add(worker);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEmailById(int id, String email) {
		try {
			return workerRepository.update(id, email);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteById(int id) {
		try {
			return workerRepository.delete(id);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Map<String,String>> fullWorkerInfo() throws SQLException {
		return workerRepository.getFullWorkerInfo();
	}
}

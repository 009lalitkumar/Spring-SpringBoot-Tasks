package com.springboot.workers.crudapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.workers.crudapi.model.Title;
import com.springboot.workers.crudapi.repository.TitleRepository;

@Service
public class TitleService {
	@Autowired
	private TitleRepository titleRepository;
	
	public boolean addTitle(Title title) throws SQLException {
		return titleRepository.addTitle(title);
	}
	public Title getTitleById(int workerRefId) throws SQLException {
		return titleRepository.getTitleById(workerRefId);
	}
	public List<Title> getAllTitle() throws SQLException {
		return titleRepository.getAllTitle();
	}
	public boolean updateTitle(Title title) throws SQLException {
		return titleRepository.updateTitle(title);
	}
	public boolean deleteTitleById(int workerRefId) throws SQLException {
		return titleRepository.deleteTitleById(workerRefId);
	}
	public List<Title> getTitleByDept(String dept) throws SQLException {
		return titleRepository.getTitleByDept(dept);
	}

}

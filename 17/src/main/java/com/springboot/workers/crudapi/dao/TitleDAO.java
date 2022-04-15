package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Title;

public interface TitleDAO {
	public boolean addTitle(Title title)
            throws SQLException;

	public Title getTitleById(int workerRefId)
            throws SQLException;

	public List<Title> getAllTitle()
            throws SQLException;

	public boolean updateTitle(Title title)
            throws SQLException;
	public boolean deleteTitleById(int workerRefId)
            throws SQLException;

	List<Title> getTitleByDept(String dept) throws SQLException;
}

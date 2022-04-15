package com.springJDBC.dao;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.springJDBC.mappers.WorkerMapper;
import com.springJDBC.model.Worker;

public class WorkerJDBCTemplate implements WorkerDAO{
	 
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
			
	}
		@Override
	   public void addWorker(Worker worker) throws SQLException {
	        String format = """
	                INSERT INTO Worker VALUES (?, ?, ?, ?, ?, ?, ?)
	                """;
	        jdbcTemplateObject.update(format, worker.getWorkerId(), worker.getFirstName(), worker.getLastName(), worker.getSalary(), worker.getJoiningDate(), worker.getDepartment(), worker.getEmail());
	      
	        System.out.println("new Record created");
	    }

		@Override
	    public void deleteWorkerById(int workerId) throws SQLException {
	        String format = """
	                DELETE FROM Worker where worker_id = ?
	                """;
	        jdbcTemplateObject.update(format, workerId);
	        System.out.println("Record deleted");
	    }

	    @Override
	    public Worker getWorkerById(int workerId) throws SQLException {
	        String format = """
	                SELECT * FROM Worker
	                    WHERE Worker_id = ?
	                """;
	        return jdbcTemplateObject.queryForObject(format, new Object[] {workerId}, new WorkerMapper());
	    }

		@Override
	    public List<Worker> getAllWorkers() throws SQLException {
	        String format = """
	                SELECT * FROM Worker
	                """;
	        List<Worker> list = jdbcTemplateObject.query(format, new WorkerMapper());
	        return list;
	    }

	    @Override
	    public void updateWorker(Worker emp) throws SQLException {
	        String format = """
	                UPDATE Worker
	                    SET
	                        worker_id = ?,
	                        first_name = ?,
	                        last_name = ?,
	                        salary = ?,
	                        joining_date = ?,
	                        department = ?,
	                        email = ?
	                    WHERE worker_id = ?
	                """;
	        jdbcTemplateObject.update(format, emp.getWorkerId(), emp.getFirstName(), emp.getLastName(), emp.getSalary(), emp.getJoiningDate(), emp.getDepartment(), emp.getEmail(), emp.getWorkerId());
	        System.out.println("Record Updated");
	    }

		
}

package com.springboot.workers.crudapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.util.DatabaseConnection;

@Repository
public class WorkerRepository implements WorkerDAO {
	private Connection connection;
	private static final Logger log = LoggerFactory.getLogger(WorkerRepository.class);


    public WorkerRepository() throws Exception {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean add(Worker worker) throws SQLException {
        String addQuery = "insert into worker values(?,?,?,?,?,?,?)";
        int row = 0;
        boolean res=false;
        try (PreparedStatement statement = connection.prepareStatement(addQuery)) {
            statement.setInt(1, worker.getworkerId());
            statement.setString(2, worker.getfirstName());
            statement.setString(3, worker.getlastName());
            statement.setInt(4, worker.getSalary());
            statement.setDate(5, worker.getjoiningDate());
            statement.setString(6, worker.getDepartment());
            statement.setString(7, worker.getEmail());
            row = statement.executeUpdate();
            if(row==1) res=true;
        } catch (SQLException e) {
            log.error(e.toString());
        }
        return res;
    }

    @Override
    public boolean delete(int workerId) throws SQLException {
        String delQuery = "delete from worker where WORKER_ID=?";
        try (PreparedStatement statement = connection.prepareStatement(delQuery)) {
            statement.setInt(1, workerId);
            int rows = statement.executeUpdate();
            log.info(rows + "worker deleted");
            return true;
          
        } catch (SQLException e) {
        	log.error(e.toString());
        	return false;
        }

    }

    @Override
    public Worker getWorker(int workerId) throws SQLException {
        Worker worker = null;
        String getQuery = "select * from worker where WORKER_ID=?";
        try (PreparedStatement statement = connection.prepareStatement(getQuery)) {
            statement.setInt(1, workerId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                worker = new Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),
                        rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
        	log.error(e.toString());
        }
        log.info("Retrieved a worker record");
        return worker;
    }

    @Override
    public List<Worker> getWorkers() throws SQLException {
        List<Worker> list = new ArrayList<>();
        String getQuery = "select * from worker";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                list.add(new Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),
                        rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) {
        	log.error(e.toString());
        }

        return list;
    }

    @Override
    public boolean update(int id,String email) throws SQLException {
    	log.info(id+" "+email);
        String updateQuery = "update worker set email=? where worker_id=?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, email.trim());
            statement.setInt(2, id);
       

            int rows = statement.executeUpdate();
            log.info(rows + "worker updated");
            return true;

        } catch (SQLException e) {
        	log.error(e.toString());
        	return false;
        }

    }
}

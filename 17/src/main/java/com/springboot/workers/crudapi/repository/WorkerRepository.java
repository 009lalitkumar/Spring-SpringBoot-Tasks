package com.springboot.workers.crudapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.util.DatabaseConnection;

@Repository
public class WorkerRepository implements WorkerDAO {
	private Connection connection;


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
            statement.setString(4, worker.getSalary());
            statement.setDate(5, worker.getjoiningDate());
            statement.setString(6, worker.getDepartment());
            statement.setString(7, worker.getEmail());
            row = statement.executeUpdate();
            if(row==1) res=true;
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(int workerId) throws SQLException {
        String delQuery = "delete from worker where WORKER_ID=?";
        try (PreparedStatement statement = connection.prepareStatement(delQuery)) {
            statement.setInt(1, workerId);
            return statement.executeUpdate()>0;          
        } catch (SQLException e) {
        	e.printStackTrace();
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
                worker = new Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
                        rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return worker;
    }

    @Override
    public List<Worker> getWorkers() throws SQLException {
        List<Worker> list = new ArrayList<>();
        String getQuery = "select * from worker";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                list.add(new Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
                        rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean update(int id,String email) throws SQLException {
        String updateQuery = "update worker set email=? where worker_id=?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, email.trim());
            statement.setInt(2, id);
            return statement.executeUpdate()>0;

        } catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        }

    }
    @Override
	public List<Map<String,String>> getFullWorkerInfo() throws SQLException {
    	List<Map<String,String>> list = new ArrayList<>();
		String query = "select * from Worker w Left join bonus b on w.worker_id = b.worker_ref_id inner join title t on w.worker_id = t.worker_ref_id";
		Statement st = connection.createStatement();
		ResultSet res = st.executeQuery(query);
		while(res.next()) {
			Map<String,String> map=new HashMap<>();
			map.put("workerId", ""+res.getInt("worker_id"));
			map.put("firstName", res.getString("first_name"));
			map.put("lastName", res.getString("last_name"));
			map.put("salary",""+res.getInt("salary"));
			map.put("joiningDate", res.getDate("joining_date")+"");
			map.put("dept", res.getString("department"));
			map.put("email", res.getString("email"));
			map.put("workerTitle", res.getString("worker_title"));
			map.put("affectedFrom",res.getDate("affected_from")+"");
			map.put("bonusAmount", res.getInt("bonus_amount")+"");
			map.put("bonusDate", res.getDate("bonus_date")+"");
			list.add(map);
		}
		return list;
	}
}

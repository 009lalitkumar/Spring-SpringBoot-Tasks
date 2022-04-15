package com.springJDBC;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springJDBC.dao.WorkerJDBCTemplate;
import com.springJDBC.model.Worker;

public class App {
    public static void main(String[] args) throws Exception {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        WorkerJDBCTemplate workderDaoImplemenation = context.getBean("workerJDBCTemplate", WorkerJDBCTemplate.class);

        Worker worker = new Worker(9, "Naruto", "Uzumaki", 1520512.0, new java.sql.Date(new Date().getTime()),
                "Software",
                "Naruto@gmail.com");

        workderDaoImplemenation.deleteWorkerById(9);
        workderDaoImplemenation.addWorker(worker);

        Worker worker2 = workderDaoImplemenation.getWorkerById(1);
        System.out.println(worker2);

        List<Worker> list = workderDaoImplemenation.getAllWorkers();
        for (Worker worker3 : list) {
            System.out.println(worker3);

        }

        workderDaoImplemenation
                .updateWorker(new Worker(9, "Sasuke", "Uchiha", 1520512.0, new java.sql.Date(new Date().getTime()),
                        "Software",
                        "sasuke@gmail.com"));
        System.out.println(workderDaoImplemenation.getWorkerById(9));
        workderDaoImplemenation.deleteWorkerById(9);
        context.close();
    }
}

package com.eventsDemo;

import java.sql.Timestamp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class CSRefreshedEvent implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent context) {
		System.out.println("Content Refreshed at: "+new Timestamp(System.currentTimeMillis()));
		
	}

}

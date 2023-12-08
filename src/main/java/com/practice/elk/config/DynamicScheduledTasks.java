package com.practice.elk.config;

import java.util.Date;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

@Component
public class DynamicScheduledTasks implements SchedulingConfigurer{

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		Date startTime = new Date(System.currentTimeMillis() + 600000);
		
	}

	
}

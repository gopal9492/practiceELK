package com.practice.elk.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practice.elk.controller.ELKController;

@Configuration
public class CronJobConfiguration {

    @Bean
    JobDetail sampleJobDetail() {
		return JobBuilder.newJob(ELKController.class).withIdentity("sampleJob").storeDurably().build();
	}

    @Bean
    Trigger sampleJobTrigger() {
		SimpleScheduleBuilder schdulerbuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(10)
				.withRepeatCount(2);
		return TriggerBuilder.newTrigger().forJob(sampleJobDetail()).withIdentity("SampleSchduleTrigger")
				.withSchedule(schdulerbuilder).build();
	}

}

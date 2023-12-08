package com.practice.elk.controller;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ELKController implements Job{

	Logger logger = LoggerFactory.getLogger(ELKController.class);

	@GetMapping("/")
	public String home() {
		logger.info("enterd into the home page");
		return "index";
	}
	
	@PostMapping("/form-submitted")
	@ResponseBody
	public String loggersAdded(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		logger.info("The form is submitted. The Enterd values are "+num1+" , "+num2);
		try {
		int divisionValue=num1/num2;
		logger.info("The division value is: " +divisionValue);
		return "The The division value is "+divisionValue;
		}
		catch(Exception e) {
			logger.error("The division value is getting exception");
		return "Exception occured becasue of given values are "+num1+" , "+num2;
		}
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		int executioncount=context.getMergedJobDataMap().getInt("executioncount");
		
	}

}

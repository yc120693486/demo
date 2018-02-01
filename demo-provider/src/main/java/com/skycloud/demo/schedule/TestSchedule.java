package com.skycloud.demo.schedule;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component(value="testSchedule")
@PropertySource("classpath:config.properties")	
public class TestSchedule {
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Scheduled(cron="${schedule.test.interval}") 
	public void runTest(){
		logger.info("schedule working ......");
	}

}

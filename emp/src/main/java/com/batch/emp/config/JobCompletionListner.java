package com.batch.emp.config;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionListner extends JobExecutionListenerSupport implements JobExecutionListener {
@Override
public void afterJob(JobExecution jobExecution) {
	if(jobExecution.getStatus()==BatchStatus.COMPLETED)
	{
		System.out.println("Batch Job Completed Successfully");
	}
}
}

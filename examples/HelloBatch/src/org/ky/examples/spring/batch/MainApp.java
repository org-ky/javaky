package org.ky.examples.spring.batch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *args[0] -> file CSV path (obbligatorio)
 *args[1] -> cartella log (opzionale, di default "C:\ccs\batch\logs")
*/

public class MainApp{
		
	//Logging
	private static Log m_log = LogFactory.getLog(MainApp.class);
	
	public static void main(String[] args) {
		
		/*Definizione del file di configurazione dei JOBS*/
		String[] springConfig  = 
			{	
				"spring/batch/job/job.xml" 
			};
		
		//Instanzio il context
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
		
		//Ottengo gli oggetti bean del context
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		
		JobParametersBuilder builder = new JobParametersBuilder();
		
		//if(args!=null && args.length >=1){
			
			//builder.addString("filename", args[0]);
			Job job = (Job) context.getBean("myJob");
			try {
				JobExecution execution = jobLauncher.run(job, builder.toJobParameters());
			} catch (JobExecutionAlreadyRunningException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobRestartException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobInstanceAlreadyCompleteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobParametersInvalidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//} else {
		//	System.out.println("-------Attenzione, inserire il nome del file da elaborare------");
		//}
	}

}

package com.UmbrellaCorp.UmbrellaCorporation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UmbrellaCorporationApplication {

	public static void main(String[] args) {
		MonitoringTool.printThreadInfo();
		DataProcessor processor = new DataProcessor();
		processor.processData();
		SpringApplication.run(UmbrellaCorporationApplication.class, args);
	}
}

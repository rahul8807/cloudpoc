package com.app.kinesis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KinesisApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinesisApplication.class, args);
	}


}

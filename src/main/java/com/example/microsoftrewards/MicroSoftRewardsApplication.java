package com.example.microsoftrewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@RestController
public class MicroSoftRewardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroSoftRewardsApplication.class, args);
	}

}

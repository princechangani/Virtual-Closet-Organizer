package com.virtual_closet_organizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VirtualClosetOrganizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualClosetOrganizerApplication.class, args);
	}

}

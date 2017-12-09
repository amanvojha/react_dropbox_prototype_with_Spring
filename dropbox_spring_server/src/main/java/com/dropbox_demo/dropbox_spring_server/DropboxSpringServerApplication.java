package com.dropbox_demo.dropbox_spring_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = { DataSourceAutoConfiguration.class })
public class DropboxSpringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DropboxSpringServerApplication.class, args);
	}
}

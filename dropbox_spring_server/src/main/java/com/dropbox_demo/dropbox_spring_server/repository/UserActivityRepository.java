package com.dropbox_demo.dropbox_spring_server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dropbox_demo.dropbox_spring_server.entity.dropbox_useractivity;



public interface UserActivityRepository extends MongoRepository<dropbox_useractivity, Long>{

	List<dropbox_useractivity> findByUsername(String username);
	
}

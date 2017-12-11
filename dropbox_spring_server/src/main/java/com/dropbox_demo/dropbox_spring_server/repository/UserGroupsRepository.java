package com.dropbox_demo.dropbox_spring_server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dropbox_demo.dropbox_spring_server.entity.dropbox_usergroups;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userinfo;


public interface UserGroupsRepository extends MongoRepository<dropbox_usergroups, Long>{
	
	List<dropbox_usergroups> findByUsername(String username);

}

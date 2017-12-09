package com.dropbox_demo.dropbox_spring_server.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userinfo;


public interface UserInfoRepository extends MongoRepository<dropbox_userinfo, Long>{
	
	List<dropbox_userinfo> findByUsername(String username);
}

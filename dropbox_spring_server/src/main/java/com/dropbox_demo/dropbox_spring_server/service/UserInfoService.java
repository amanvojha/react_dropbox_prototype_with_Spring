package com.dropbox_demo.dropbox_spring_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Service;

import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userfiles;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userinfo;
import com.dropbox_demo.dropbox_spring_server.repository.FilesFoldersRepository;
import com.dropbox_demo.dropbox_spring_server.repository.UserInfoRepository;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<dropbox_userinfo> getProfile(String username){
        return userInfoRepository.findByUsername(username);
    }
	
	public void addUser(dropbox_userinfo user){
		userInfoRepository.save(user);
    }
	
	public void updateUser(dropbox_userinfo user){
		
		Query query = new Query(Criteria.where("username").is(user.getUsername()));
        Update update = new Update();
        //update.set("isdeleted", 1);
        
        update.set("education",user.getEducation());
    	update.set("interest",user.getInterest());
    	update.set("work",user.getWork());
    	update.set("mobile",user.getMobile());
    	update.set("bio",user.getBio());
    	
        mongoTemplate.updateMulti(query, update , dropbox_userinfo.class);
		
    }


}

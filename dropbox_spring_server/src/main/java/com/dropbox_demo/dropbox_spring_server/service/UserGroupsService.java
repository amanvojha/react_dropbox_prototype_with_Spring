package com.dropbox_demo.dropbox_spring_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropbox_demo.dropbox_spring_server.entity.dropbox_useractivity;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userfiles;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_usergroups;
import com.dropbox_demo.dropbox_spring_server.repository.UserActivityRepository;
import com.dropbox_demo.dropbox_spring_server.repository.UserGroupsRepository;

@Service
public class UserGroupsService {
	
	@Autowired
	private UserGroupsRepository userGroupsRepository;
	
	public List<dropbox_usergroups> getGroup(String username){
        return userGroupsRepository.findByUsername(username);
    }
	
	public void addUserGroup(dropbox_usergroups group){
		userGroupsRepository.save(group);
    }

}

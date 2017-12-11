package com.dropbox_demo.dropbox_spring_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropbox_demo.dropbox_spring_server.entity.dropbox_useractivity;

import com.dropbox_demo.dropbox_spring_server.repository.UserActivityRepository;


@Service
public class UserActivityService {
	
	@Autowired
	private UserActivityRepository userActivityRepository;
	
	public List<dropbox_useractivity> getActivity(String username){
        return userActivityRepository.findByUsername(username);
    }

}

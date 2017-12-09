package com.dropbox_demo.dropbox_spring_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userfiles;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userinfo;
import com.dropbox_demo.dropbox_spring_server.repository.FilesFoldersRepository;
import com.dropbox_demo.dropbox_spring_server.repository.UserInfoRepository;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public List<dropbox_userinfo> getProfile(String username){
        return userInfoRepository.findByUsername(username);
    }

}

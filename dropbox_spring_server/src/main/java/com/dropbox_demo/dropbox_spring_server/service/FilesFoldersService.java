package com.dropbox_demo.dropbox_spring_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userfiles;
import com.dropbox_demo.dropbox_spring_server.repository.FilesFoldersRepository;

@Service
public class FilesFoldersService {
	
	@Autowired
	private FilesFoldersRepository filesFoldersRepository;
	
	public List<dropbox_userfiles> setFiles(String parentId){
        return filesFoldersRepository.findByParentId(parentId);
    }
	

}

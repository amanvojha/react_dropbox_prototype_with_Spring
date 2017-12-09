package com.dropbox_demo.dropbox_spring_server.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userfiles;
import com.dropbox_demo.dropbox_spring_server.service.FilesFoldersService;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/api")
public class FilesFoldersController {
	
	@Autowired
	private FilesFoldersService filesFoldersService;
	
    @PostMapping(path="/setFiles")
    public @ResponseBody List<dropbox_userfiles> setFiles(@RequestBody String parentId) {
        // This returns a JSON with the users
    	System.out.println("-----------Request Received from " + parentId);
    	
    	List<dropbox_userfiles> files = filesFoldersService.setFiles(parentId);
    	
    	for(dropbox_userfiles file : files) {
            System.out.println(file.getFile_name());
        }
    	return files;
    }
    
	

}
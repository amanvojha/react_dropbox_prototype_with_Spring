package com.dropbox_demo.dropbox_spring_server.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
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
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userinfo;
import com.dropbox_demo.dropbox_spring_server.repository.UserInfoRepository;
import com.dropbox_demo.dropbox_spring_server.service.FilesFoldersService;
import com.dropbox_demo.dropbox_spring_server.service.UserInfoService;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/api")
public class FilesFoldersController {
	
	@Autowired
	private FilesFoldersService filesFoldersService;
	@Autowired
	private UserInfoService userInfoService;
	
    
	
	@PostMapping(path="/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> signup(@RequestBody String userDetails) throws JSONException {
        // This returns a JSON with the users
		
		JSONObject jsonObject = new JSONObject(userDetails);
    	System.out.println("-----------Request Received from " + jsonObject);
    	
    	String username = jsonObject.getString("username");
    	String password = jsonObject.getString("password");
    	String first_name = jsonObject.getString("first_name");
    	String last_name = jsonObject.getString("last_name");
    	
    	dropbox_userinfo user = new dropbox_userinfo();
    	user.setUsername(username);
    	user.setPassword(password);
    	user.setFirst_name(first_name);
    	user.setLast_name(last_name);
    	
    	userInfoService.addUser(user);
    	
    	
    	return new ResponseEntity("true",HttpStatus.OK);
    }
	
	
	
	@PostMapping(path="/setFiles")
    public @ResponseBody List<dropbox_userfiles> setFiles(@RequestBody String parentId) {
        // This returns a JSON with the users
    	System.out.println("-----------Request Received from " + parentId);
    	
    	List<dropbox_userfiles> files = filesFoldersService.setFiles(parentId);

    	return files;
    }
   
    
    @PostMapping(path="/getProfile")
    public @ResponseBody List<dropbox_userinfo> getProfile(@RequestBody String username) {
        // This returns a JSON with the users
    	System.out.println("-----------Profile request Received from " + username);
    	
    	List<dropbox_userinfo> info = userInfoService.getProfile(username);
    	
    	for(dropbox_userinfo inf : info) {
            System.out.println(inf.getFirst_name());
        }
    	return info;
    }
    
    
    @PostMapping(path="/uploadFolder",consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> uploadFolder(@RequestBody String userDetails) throws JSONException {
        // This returns a JSON with the users
		
		JSONObject jsonObject = new JSONObject(userDetails);
    	System.out.println("-----------Request Received from " + jsonObject);
    	
    	String username = jsonObject.getString("username");
    	String isFile = jsonObject.getString("isFile");
    	String file_name = jsonObject.getString("file_name");
    	String parentId = jsonObject.getString("parentId");
    	
    	dropbox_userfiles files = new dropbox_userfiles();
    	//String id = Double.toString(Calendar.getInstance().getTimeInMillis());
    	
    	Long l = new Long(Calendar.getInstance().getTimeInMillis());
        double id = (double)l;
        System.out.println(id);
    	
    	files.setUsername(username);
    	files.setFile_name(file_name);
    	files.setIsFile(isFile);
    	files.setParentId(parentId);
    	files.setFileId(id);
    	files.setIsStarred(false);
    	files.setIsOwner(true);
    	files.setSharedWith(new ArrayList<>());
    	
    	filesFoldersService.addFileFolder(files);

    	/*dropbox_userinfo user = new dropbox_userinfo();
    	user.setUsername(username);
    	user.setPassword(password);
    	user.setFirst_name(first_name);
    	user.setLast_name(last_name);
    	
    	userInfoService.addUser(user);*/
    	
    	List<dropbox_userfiles> files1 = filesFoldersService.setFiles(parentId);
    	
    	
    	return new ResponseEntity(files1,HttpStatus.OK);
    }
    
	

}

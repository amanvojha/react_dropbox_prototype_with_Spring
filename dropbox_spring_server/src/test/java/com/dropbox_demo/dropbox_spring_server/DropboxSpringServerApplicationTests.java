package com.dropbox_demo.dropbox_spring_server;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.dropbox_demo.dropbox_spring_server.entity.dropbox_useractivity;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userfiles;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_usergroups;
import com.dropbox_demo.dropbox_spring_server.entity.dropbox_userinfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DropboxSpringServerApplication.class)
@SpringBootTest
public class DropboxSpringServerApplicationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	
	@Bean
	public static RestTemplate restTemplate(){
		return new RestTemplate();
	}
	

    @Test
    public void getActivity() {
    	String params = "amano";
        ResponseEntity<dropbox_useractivity[]> res = restTemplate().postForEntity("http://localhost:8082/api/getActivity", params, dropbox_useractivity[].class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    @Test
    public void setFiles() {
    	String params = "amano";
        ResponseEntity<dropbox_userfiles[]> res = restTemplate().postForEntity("http://localhost:8082/api/setFiles", params, dropbox_userfiles[].class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    @Test
    public void getProfile() {
    	String params = "amano";
        ResponseEntity<dropbox_userinfo[]> res = restTemplate().postForEntity("http://localhost:8082/api/getProfile", params, dropbox_userinfo[].class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    @Test
    public void getGroup() {
    	String params = "amano";
        ResponseEntity<dropbox_usergroups[]> res = restTemplate().postForEntity("http://localhost:8082/api/getGroup", params, dropbox_usergroups[].class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    @Test
    public void signup() {
    	dropbox_userinfo user = new dropbox_userinfo();
    	
    	double random = Math.random();
    	String username = random + "@gmail.com";
    	
    	user.setUsername(username);
    	user.setPassword("root");
    	user.setFirst_name("Sample");
    	user.setLast_name("Sample");
        ResponseEntity<String> res = restTemplate().postForEntity("http://localhost:8082/api/signup", user, String.class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    @Test
    public void uploadFolder() {
    	
    	dropbox_userfiles files = new dropbox_userfiles();
    	
    	double random = Math.random();
    	String file_name = random + "file";
    	
    	files.setUsername("amano");
    	files.setFile_name(file_name);
    	files.setIsFile("0");
    	files.setParentId("amano");
    	ResponseEntity<dropbox_userfiles[]> res = restTemplate().postForEntity("http://localhost:8082/api/uploadFolder", files, dropbox_userfiles[].class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    @Test
    public void getAct() {
    	String params = "amano";
        ResponseEntity<dropbox_userinfo[]> res = restTemplate().postForEntity("http://localhost:8082/api/getProfile", params, dropbox_userinfo[].class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    @Test
    public void getStar() {
    	String params = "amano";
        ResponseEntity<dropbox_usergroups[]> res = restTemplate().postForEntity("http://localhost:8082/api/getGroup", params, dropbox_usergroups[].class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    @Test
    public void star() {
    	dropbox_userinfo user = new dropbox_userinfo();
    	
    	double random = Math.random();
    	String username = random + "@gmail.com";
    	
    	user.setUsername(username);
    	user.setPassword("root");
    	user.setFirst_name("Sample");
    	user.setLast_name("Sample");
        ResponseEntity<String> res = restTemplate().postForEntity("http://localhost:8082/api/signup", user, String.class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    @Test
    public void uploadFile() {
    	
    	dropbox_userfiles files = new dropbox_userfiles();
    	
    	double random = Math.random();
    	String file_name = random + "file";
    	
    	files.setUsername("amano");
    	files.setFile_name(file_name);
    	files.setIsFile("0");
    	files.setParentId("amano");
    	ResponseEntity<dropbox_userfiles[]> res = restTemplate().postForEntity("http://localhost:8082/api/uploadFolder", files, dropbox_userfiles[].class);

        assertEquals(200, res.getStatusCodeValue());
    }
    
    
    
    
    
    
    
    

}

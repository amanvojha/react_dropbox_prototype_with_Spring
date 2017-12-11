package com.dropbox_demo.dropbox_spring_server;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

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

	/*@Test
	public void contextLoads() {
	}*/
	
	private MockMvc mockMvc;

	
	private String attribute = "amano";
	private String attribute2 = "{\"email\":\"palash\"}";
	private String attribute3 = "{\"email\":\"palash\",\"groupname\":\"palash\" }";
	private String attribute4 = "{\"email\":\"palash\",\"directory\":\"palash\" }";
	private String attribute5 = "{\"email\":\"palash\",\"directory\":\"palash\"  , \"foldername\" : \"palash\" }";
	
	
	@Autowired
    private WebApplicationContext wac;
	
	/*@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}*/
	
	
	
	/*@Test
	public void getActivity() throws Exception {
		mockMvc.perform(post("/getActivity")
				.content(attribute)
				.contentType(MediaType.TEXT_HTML))				
				.andExpect(status().isOk()) ; 
	}*/
	
	
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

}

package com.example.easynotes.consumeapi;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.easynotes.model.Register;

@Controller
public class LoginController {
	@RequestMapping("/loginpage")
	private String logindata()
	{
		return "login";
	}
	@RequestMapping("/loginpost")
	 @ResponseBody
	 private String getUser(@ModelAttribute(name="loginForm") Register login) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	 String uri = "http://127.0.0.1:8080/reg/login";
	  RestTemplate restTemplate = new RestTemplate();
	  String uname = login.getUsername();
	  String pass = login.getPassword();
	  Register r = new Register();
	//  r.setId(1L);
	  r.setUsername(uname);
	  r.setPassword(pass);
	  HttpEntity<Register> httpEntity = new HttpEntity<Register>(r,headers);

	
		Register res = restTemplate.postForObject(uri,httpEntity,Register.class);
	  //String s = restTemplate.postForObject(uri,r);
	//  System.out.println("User: " + user.getId() + ","+user.getTitle());
	 String s="";
	 if(res!=null)
	  {
		  s = "login success";
	  }
	 else
	 {
		 s = "login fail";
	 }
	  return s;
	 }
}

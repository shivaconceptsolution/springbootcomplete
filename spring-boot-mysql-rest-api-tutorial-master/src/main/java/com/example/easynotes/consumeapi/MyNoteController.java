package com.example.easynotes.consumeapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyNoteController {
	@RequestMapping("/hello/{id}")
    private ModelAndView hello(@PathVariable Integer id,Model model) {
		 String uri = "http://127.0.0.1:8080/api/notes/" + id;
		 RestTemplate restTemplate = new RestTemplate();
		 MyNotes user = restTemplate.getForObject(uri, MyNotes.class);
	     ModelAndView obj= new ModelAndView("hello");
	     obj.addObject("key1",user.getId());
	     obj.addObject("key2",user.getTitle());
	     obj.addObject("key3",user.getContent());
	     System.out.println("User: " + user.getId() + ","+user.getTitle());
	     return obj;
	 }
	@RequestMapping("/myhello")
	 @ResponseBody
	 private String getUser() {
	  String uri = "http://127.0.0.1:8080/api/notes/1";
	  RestTemplate restTemplate = new RestTemplate();
	  
	  MyNotes user = restTemplate.getForObject(uri, MyNotes.class);
	  System.out.println("User: " + user.getId() + ","+user.getTitle());
	  
	  return "User detail page.";
	 }
}

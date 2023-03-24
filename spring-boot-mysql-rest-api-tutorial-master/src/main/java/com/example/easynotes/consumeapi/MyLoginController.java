package com.example.easynotes.consumeapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyLoginController {
	@RequestMapping("/logindata")
	private String logindata()
	{
		return "logindata";
	}
}

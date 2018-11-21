package br.com.palazzo.jobsystem.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private String message = "Bem vindo!";

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("message", message);
    	return "home";
    }

}

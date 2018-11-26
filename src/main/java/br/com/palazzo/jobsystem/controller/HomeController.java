package br.com.palazzo.jobsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.palazzo.jobsystem.model.Incident;
import br.com.palazzo.jobsystem.model.IncidentStatus;
import br.com.palazzo.jobsystem.service.IncidentService;

@Controller
public class HomeController {
	
	IncidentService service;
	
	@Autowired
    public HomeController(IncidentService service) {
		this.service = service;
	}

	@RequestMapping("/")
    public ModelAndView index() {
    	int qtySolved = 0;
    	int qtyOpened = 0;
    	
    	for(Incident incident : service.findAll()) {
    		if(incident.getStatus() == IncidentStatus.OPENED) {
    			qtyOpened++;
    		}else if(incident.getStatus() == IncidentStatus.SOLVED) {
    			qtySolved++;
    		}
    	}
    	
    	ModelAndView mv = new ModelAndView("home");
    	mv.addObject("qtySolved", qtySolved);
    	mv.addObject("qtyOpened", qtyOpened);
    	return mv;
    }
    
    

}

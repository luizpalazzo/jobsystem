package br.com.palazzo.jobsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.palazzo.jobsystem.model.Incident;
import br.com.palazzo.jobsystem.model.IncidentStatus;
import br.com.palazzo.jobsystem.model.Job;
import br.com.palazzo.jobsystem.service.IncidentService;

@Controller
@RequestMapping("/ticket")
public class IncidentController {
	
	IncidentService service;

	@Autowired
	public IncidentController(IncidentService service) {
		this.service = service;
	}

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ModelAndView list() {
    	ModelAndView mv = new ModelAndView("ticket/list", "tickets", service.findAll());
    	return mv;
    }
    
    @RequestMapping(value = {"/log"}, method = RequestMethod.POST)
    public @ResponseBody String getLog(@RequestBody Job job){
		String log = service.getLog(job.getId());
		return log;
    }
    
    @RequestMapping(value = {"/close"}, method = RequestMethod.POST)
    public @ResponseBody String closeTicket(@RequestBody Incident incident){
		Long number = incident.getTicketNumber();
		String closure = incident.getClosure();
		
		Incident dbIncident = service.findById(number);
		
		dbIncident.setClosure(closure);
		dbIncident.setStatus(IncidentStatus.SOLVED);
		
		service.save(dbIncident);
		
		return "Chamado encerrado";
    }
    
    @RequestMapping(value = {"/solution"}, method = RequestMethod.POST)
    public @ResponseBody String getSolution(@RequestBody Incident incident){
		String solution = service.findById(Long.valueOf(incident.getTicketNumber())).getClosure();
		return solution;
    }
	

}

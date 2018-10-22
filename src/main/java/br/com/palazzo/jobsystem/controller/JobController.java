package br.com.palazzo.jobsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.palazzo.jobsystem.model.form.FormScript;
import br.com.palazzo.jobsystem.service.TeamService;

@Controller
@RequestMapping("/job")
public class JobController {
	
	TeamService teamService;
	
	@Autowired
	public JobController(TeamService teamService) {
		this.teamService = teamService;
	}

    @RequestMapping(value = "/insert" , method = RequestMethod.GET)
    public ModelAndView insert() {
    	ModelAndView mv = new ModelAndView("job/insert_job");
    	mv.addObject("teams",teamService.findAll());
    	return mv;
    }
    
    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<FormScript> saveJob(@RequestBody FormScript form) {

        System.out.println(form);
        //TODO: efetuar o cadastro
        return new ResponseEntity<FormScript>(form, HttpStatus.OK);
    }

}

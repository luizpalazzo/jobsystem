package br.com.palazzo.jobsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.palazzo.jobsystem.service.JobHistoryService;

@Controller
@RequestMapping("/execution")
public class ExecutionsController {
	
	JobHistoryService executionService;

	@Autowired
	public ExecutionsController(JobHistoryService executionService) {
		this.executionService = executionService;
	}

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ModelAndView insert() {
    	ModelAndView mv = new ModelAndView("execution/list", "executions", executionService.findAll());
    	return mv;
    }
	

}

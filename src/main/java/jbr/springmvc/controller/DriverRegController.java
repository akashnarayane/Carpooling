package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Driver;

import jbr.springmvc.service.DriverService;


@Controller
public class DriverRegController 
{
	  @Autowired
	  public DriverService driverService;
	  
	  @RequestMapping(value = "/driverRegister", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) 
	  {
	  ModelAndView mav = new ModelAndView("register");
	  mav.addObject("driver", new Driver());
	  return mav;
}
	  
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("driver") Driver driver) 
	  {
		  driverService.driverRegister(driver);
		  	
		  return new ModelAndView("welcome","firstname",driver.getFname());
	   

	  
	  }
}

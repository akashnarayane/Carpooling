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
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.DriverService;
import jbr.springmvc.service.UserService;

@Controller
public class LoginController {

	/*
	 * @Autowired UserService userService;
	 */

	@Autowired 
	
	DriverService driverService;
	
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("driverlogin", new Driver());

    return mav;
  }

  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("driverlogin") Driver driverlogin) {
    ModelAndView mav = null;

    Driver driver = driverService.validateDriver(driverlogin);
   
    if (null != driver) {
      mav = new ModelAndView("welcome");
      mav.addObject("fname", driver.getFname());
      mav.addObject("dlicence", driver.getDlicence());
    }
    else
    {
      mav = new ModelAndView("login");
      mav.addObject("message", "Username or Password is wrong!!");
    }

    return mav;
  }

}

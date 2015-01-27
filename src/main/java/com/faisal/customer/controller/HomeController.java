/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faisal.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author faisal
 */
@Controller
public class HomeController {
    
  @RequestMapping(value = "/", method = RequestMethod.GET)
      public ModelAndView getdata() {
        return new ModelAndView("home");
    
    }
}

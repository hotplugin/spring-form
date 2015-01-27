/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faisal.customer.validator;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author faisal
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e){
    
         
        ModelAndView mav = new ModelAndView("exception");
        mav.addObject("name", e.getClass().getSimpleName());
        mav.addObject("message", e.getMessage());
 
        return mav;
//        return new ModelAndView("exception",new ModelMap(e.getMessage()));
    }
}

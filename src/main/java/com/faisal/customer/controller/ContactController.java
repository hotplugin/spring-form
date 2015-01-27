/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faisal.customer.controller;

import com.faisal.customer.model.Contact;
import com.faisal.customer.validator.ContactValidator;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author faisal
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactValidator contactValidator;

    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView showContactsPage() {

        return new ModelAndView("contact", "contact", new Contact());

    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("contact") Contact contact, BindingResult result,Model map) {
        System.out.println("Submitted");
        contactValidator.validate(contact, result);
        if (result.hasErrors()) {
            System.out.println("ERRORS");
        } else {
            System.out.println("Name: " + contact.getName() + " email: " + contact.getEmail() + " Msg: " + contact.getMessage());
        }

//        Errors errors = result;
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Name is empty");
//        errors.reject("name");
        map.addAttribute("contactinfo", contact);
        return "success";
    }

    @RequestMapping(value = "/sendSms", method = RequestMethod.POST)
    public ModelAndView sendsms(@ModelAttribute("contact") Contact contact, BindingResult result) {
        System.out.println("sendsms " + contact.getMobile());
        ModelMap map = new ModelMap();
        map.addAttribute("message", contact.getMobile());
        return new ModelAndView("success", map);
    }

    @ModelAttribute("previousNumbers")
    public List<String> populateNumbers() {
        List<String> l = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            l.add(String.valueOf(i));
        }
        return l;

    }

    @ModelAttribute("countryList")
    public Map<String, String> populateCountryList() {

        //Data referencing for java skills list box
        Map<String, String> country = new LinkedHashMap<String, String>();
        country.put("US", "United Stated");
        country.put("CHINA", "China");
        country.put("SG", "Singapore");
        country.put("MY", "Malaysia");

        return country;
    }

    @RequestMapping(value = "/test")
    public String test() throws IOException {

        System.out.println("called test");
        //just throw exception to test the exceptionhandler mapping
        if (true) {
            throw new IOException("this is io exception");
        }

        // render hello.jsp page
        return "contact";
    }
    @RequestMapping("/cookie")
    public String mycookie(@CookieValue(value="hits",defaultValue ="0")Long hits,HttpServletResponse response){
        
        hits++;
       Cookie cookie= new Cookie("hits",hits.toString());
       response.addCookie(cookie);
        
        
        return "home";
    }

//    @ExceptionHandler(IOException.class)
//    public ModelAndView exception(Exception e){
//    
//         
//        ModelAndView mav = new ModelAndView("exception");
//        mav.addObject("name", e.getClass().getSimpleName());
//        mav.addObject("message", e.getMessage());
// 
//        return mav;
//    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

    }
}

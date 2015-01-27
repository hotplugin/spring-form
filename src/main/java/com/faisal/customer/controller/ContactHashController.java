/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faisal.customer.controller;

import com.faisal.customer.model.ContactHash;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author faisal
 */
@Controller
@RequestMapping("/contactHash")
public class ContactHashController {

    private static Map<String, String> contactMap = new HashMap<String, String>();

    static {
        contactMap.put("name", "John");
        contactMap.put("lastname", "Lennon");
        contactMap.put("genres", "Rock, Pop");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model) {
        ContactHash ch = new ContactHash();
        ch.setContactMap(contactMap);
        model.addAttribute("chMap", ch);
        return "contactHash";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("chMapjpt") ContactHash contactHash) {
         
        return new ModelAndView("success", "chMapjpt", contactHash);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faisal.customer.validator;

import com.faisal.customer.model.Contact;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author faisal
 */
public class ContactValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
            return Contact.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "Name required","Name required");
        Contact c =(Contact)o;
        if(c.getName().length()==0){
            errors.reject("name");
        }
    }
    
    
}

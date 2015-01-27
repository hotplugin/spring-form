/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faisal.customer.model;

/**
 *
 * @author faisal
 */
public class Contact {
    
    String name;
    String email;
    String message;
    String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}

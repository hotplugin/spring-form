/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faisal.customer.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author faisal
 */
public class ContactHash {
    private Map<String, String> contactMap = new HashMap<String, String>();
 
    public Map<String, String> getContactMap() {
        return contactMap;
    }
 
    public void setContactMap(Map<String, String> contactMap) {
        this.contactMap = contactMap;
    }
 
}

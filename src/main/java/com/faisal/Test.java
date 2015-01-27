/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faisal;

import com.faisal.jdbc.dao.CustomerDAOImpl;
import com.faisal.jdbc.model.Address;
import com.faisal.jdbc.model.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author hotplugin
 */
public class Test {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("mytest-spring.xml");
        CustomerDAOImpl impl = cpac.getBean("customerDAO",CustomerDAOImpl.class);
        Customer customer = createDummyCustomer();
        impl.create(customer);
    }
    
    private static Customer createDummyCustomer() {
		Customer customer = new Customer();
//		customer.setId(1);
		customer.setName("faisal");
		Address address = new Address();
//		address.setId(1);
		address.setCountry("Nepal");
		// setting value more than 20 chars, so that SQLException occurs
		address.setAddress("newroad asdfasdfasdfasdfasdfsadfsadf");
		customer.setAddress(address);
		return customer;
	}
}

/*
*  (C) Copyright 2010-2013 hSenid Mobile Solutions (Pvt) Limited.
*  All Rights Reserved.
*
*  These materials are unpublished, proprietary, confidential source code of
*  hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
*  of hSenid Mobile Solutions (Pvt) Limited.
*
*  hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
*  property rights in these materials.
*/
package diya.dahara.service;

import diya.dahara.domain.impl.CustomerImpl;
import diya.dahara.form.CheckInForm;
import diya.dahara.repositories.CustomerRepository;

/**
 * Created by amila on 9/19/15.
 */
public class CheckInService {
    private CustomerRepository customerRepository;

    public void checkIn(CheckInForm checkInForm) throws Exception {
        CustomerImpl customer = new CustomerImpl();
        customer.setNic(checkInForm.getNic());
        customer.setCountry(checkInForm.getCountry());
        customer.setEmail(checkInForm.getEmail());
        customer.setName(checkInForm.getName());
        customer.setTelephone(checkInForm.getTelephone());
        customerRepository.insert(customer);
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}

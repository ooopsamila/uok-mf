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
package diya.dahara.repositories.impl;


import diya.dahara.domain.Customer;
import diya.dahara.repositories.CustomerRepository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class CustomerRepositoryImpl extends JdbcDaoSupport implements CustomerRepository {
    @Override
    public void insert(Customer customer) throws Exception {
        String createSql = "INSERT INTO customer (name, email, nic, telephone, country) VALUES (?, ?, ?, ?, ?)";
        Object[] params = new Object[]{customer.getName(), customer.getEmail(), customer.getNic(), customer.getTelephone(), customer.getCountry()};
        try {
            getJdbcTemplate().update(createSql, params);
        } catch (Exception e) {
            throw new Exception("Error occurred in creating a customer ", e);
        }
    }
}

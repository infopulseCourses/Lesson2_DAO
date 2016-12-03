package com.com.dao;

import com.entity.Employee;

/**
 * Created by Stepan on 03.12.2016.
 */
public interface DAOUser {

    Employee findEmployeeByName(String name);

    void close();
}

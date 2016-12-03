package com.com.dao;

import com.entity.Employee;

/**
 * Created by Stepan on 03.12.2016.
 */
public class Main {
    public static void main(String[] args) throws ConnectionRefusedException {

        DAOFactory daoFactory = DAOFactory.getInstance();
        DAOUser daoUser = daoFactory.getDAOUser();

        Employee employee = daoUser.findEmployeeByName("Vasya");
        System.out.println("Name : "+employee.getName());
        daoUser.close();
    }
}

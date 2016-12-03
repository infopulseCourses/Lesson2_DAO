package com.com.dao;

import com.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Stepan on 03.12.2016.
 */
public class DAOUserImpl implements DAOUser {
    Connection conn;

    public DAOUserImpl(Connection conn) {
        this.conn = conn;
    }

    public Employee findEmployeeByName(String name) {
        String sql = "SELECT * FROM emp WHERE name = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next() ;
            Employee employee = new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            return employee;
        } catch (SQLException e) {
           return null;

        }
    }

    public void close()  {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

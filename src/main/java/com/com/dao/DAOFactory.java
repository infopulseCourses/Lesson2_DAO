package com.com.dao;

import com.entity.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Stepan on 03.12.2016.
 */

public class DAOFactory {

    private Connection conn;
    private DAOUser daoUser;
    private static DAOFactory instance;

    public DAOUser getDAOUser() {
        if (daoUser == null) {
            daoUser = new DAOUserImpl(conn);
        }
        return daoUser;
    }

    private DAOFactory(Connection conn) {
        this.conn = conn;
    }

    public static DAOFactory getInstance() throws ConnectionRefusedException {
        if (instance == null) {
            String url = "jdbc:postgresql://localhost/myfirstjavadb";

            try {
                Connection conn = DriverManager.getConnection(url, "postgres", "1q2w3e4r");
                instance = new DAOFactory(conn);

            } catch (SQLException e) {
                throw new ConnectionRefusedException();
            }
        }
        return instance;
    }
}

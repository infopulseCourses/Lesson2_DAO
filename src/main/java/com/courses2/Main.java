package com.courses2;

import java.sql.*;

/**
 * Created by Stepan on 03.12.2016.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost/myfirstjavadb";
            conn = DriverManager.getConnection(url, "postgres", "1q2w3e4r");

            if (conn != null) {
                String sql = "SELECT * FROM emp";
                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(sql);
                ResultSetMetaData metaData = res.getMetaData();
                System.out.println("Columns = "+metaData.getColumnCount());
                DatabaseMetaData databaseMetaData = conn.getMetaData();
                ResultSet resultSet = databaseMetaData.getTables(null,null,null,null);
                ResultSetMetaData metaData1 = resultSet.getMetaData();
                int columns = metaData1.getColumnCount();
                while (resultSet.next())
                {
                   for(int i=1;i < columns;i++){
                       System.out.print(resultSet.getString(i) + " ");
                   }
                    System.out.println("");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conn.close();
        }
    }
}

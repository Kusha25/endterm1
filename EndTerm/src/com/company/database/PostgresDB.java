package com.company.database;

import com.company.database.interfaces.IDB;

import java.sql.*;

/**
 * @author Kuanyshbek
 */

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/end";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "postgres");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
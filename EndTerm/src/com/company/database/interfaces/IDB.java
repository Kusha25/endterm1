package com.company.database.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Kuanyshbek
 */

public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}


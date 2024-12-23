package com.gcs.account.common.db;

import com.gcs.account.common.exception.DBException;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Slf4j
public class DBConnection {

    private DBConnection() {
    }

    public static synchronized Connection getConnection(String dbUrl, String user, String password) throws DBException {
        try {
            return DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            log.error("", e);
            throw new DBException("", e);
        }
    }

}

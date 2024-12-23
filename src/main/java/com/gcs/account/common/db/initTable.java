package com.gcs.account.common.db;

import com.gcs.account.common.util.PropertiesConfigReader;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@Slf4j
public class initTable {
    public static void initTablesSql(String dbUrl, String user, String password) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DBConnection.getConnection(dbUrl, user, password);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            // for testing connection enable or disable.
            stmt.executeUpdate(" create table test(id serial primary key NOT NULL);");
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            log.error("", e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        String fileName = "jdbc.properties";
        String url = PropertiesConfigReader.getStringValue(fileName, "jdbc.url");
        String user = PropertiesConfigReader.getStringValue(fileName, "jdbc.username");
        String password = PropertiesConfigReader.getStringValue(fileName, "jdbc.password");
        initTablesSql(url, user, password);
    }
}

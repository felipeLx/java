package com.felipelisboa.test.java8;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgreSqlVersion {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String user = "root";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT VERSION()")) {
            if(rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(JavaPostgreSqlVersion.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}

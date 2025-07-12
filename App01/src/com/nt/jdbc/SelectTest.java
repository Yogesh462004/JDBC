package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

    public static void main(String[] args) {
        
        try (
        	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student1");
        ) {
            while (rs.next()) {
                System.out.println( rs.getInt(1) + " " +rs.getString(2) + " " +rs.getFloat(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}

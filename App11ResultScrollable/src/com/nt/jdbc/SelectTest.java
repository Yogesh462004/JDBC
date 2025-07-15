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
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM student1");
        ) {
        	System.out.println("From Bottom to top");
            while (rs.next()) {
                System.out.println( rs.getInt(1) + " " +rs.getString(2) + " " +rs.getFloat(3));
            }
            rs.afterLast();
            System.out.println("From bottom to top");
            while (rs.previous()) {
                System.out.println( rs.getInt(1) + " " +rs.getString(2) + " " +rs.getFloat(3));
            }
            System.out.println("Randomly");
            rs.first();
            System.out.println( rs.getInt(1) + " " +rs.getString(2) + " " +rs.getFloat(3));
             rs.last();
             System.out.println( rs.getInt(1) + " " +rs.getString(2) + " " +rs.getFloat(3));
             rs.absolute(2);
             System.out.println( rs.getInt(1) + " " +rs.getString(2) + " " +rs.getFloat(3));

             rs.relative(1);
             System.out.println( rs.getInt(1) + " " +rs.getString(2) + " " +rs.getFloat(3));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}

package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SelectTest {

    public static void main(String[] args) {
        
        try (
        	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
            
        ) {
        	DatabaseMetaData dmd=con.getMetaData();
        	System.out.println(dmd.getDatabaseProductName());
        	System.out.println(dmd.getDatabaseProductVersion());
        	System.out.println(dmd.getDriverName());
            }
            
        catch(SQLException e) {
            e.printStackTrace();
        }
    }  
    
}

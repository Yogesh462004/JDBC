package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

    public static void main(String[] args) {
        
        try (
        	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student1");
        		
        ) {
        	ResultSetMetaData rm=rs.getMetaData();
        	int colcount=rm.getColumnCount();
                 for (int i=1;i<=colcount;i++) {
             		System.out.print(rm.getColumnName(i)+"\t\t");
             		

        	}
             System.out.println();
             for (int i=1;i<=colcount;i++) {
          		System.out.print("("+rm.getColumnTypeName(i)+")"+"\t");
     	}
             System.out.println();

        	while(rs.next()) {
        		for (int i=1;i<=colcount;i++) {
            		System.out.print(rs.getString(i)+"\t\t");
            	}
        		System.out.println();
        	}
            while (rs.next()) {
                System.out.println( rs.getInt(1) + " " +rs.getString(2) + " " +rs.getFloat(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}

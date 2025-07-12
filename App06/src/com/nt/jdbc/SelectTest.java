package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

    public static void main(String[] args) {
        
       try(
    		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2025","root","8105");
            Statement st=con.createStatement();
    		 ResultSet rs=st.executeQuery("select * from product");
    		 
    		   ){
    	   while(rs.next()!=false) {
    		   System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"    "+rs.getFloat(3));
    	   }
    	   
       }catch(Exception e) {
    	   e.printStackTrace();       }
       
    }
}

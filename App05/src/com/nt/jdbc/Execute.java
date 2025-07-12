package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute {

    public static void main(String[] args) {
        
       try(
           	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
            Statement st=con.createStatement();
    		 
    		   ){
    	   boolean flag=st.execute("update student1 set avg=9 where sno=2");
    	   if(flag) {
    		   ResultSet rs=st.getResultSet();
    		   while(rs.next()) {
    			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
    			   
    		   }
    	   }else {
    		   int count=st.getUpdateCount();
    		   System.out.println("affected are:"+count);
    	   }
    	   
       }catch(Exception e) {
    	   e.printStackTrace();       }
       
    }
}

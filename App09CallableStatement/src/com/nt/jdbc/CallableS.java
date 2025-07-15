package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallableS {
	private final static String query="{call emp_sal(?,?,?)}";
	private static int uno;
	
    public static void main(String[] args) {
               
       try(
           	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
            Scanner sc=new Scanner(System.in);
    		CallableStatement cs=con.prepareCall(query);
    		 
    		   ){
    	   System.out.println("Enter user number::");
    	   uno=sc.nextInt();
    	   
    	   cs.registerOutParameter(1, Types.INTEGER);
    	   cs.registerOutParameter(2, Types.VARCHAR);
    	   cs.setInt(3, uno);
    	   cs.execute();
    	   System.out.println(cs.getInt(1));
    	   System.out.println(cs.getString(2));
       }catch(Exception e) {
    	   e.printStackTrace();       }
       
    }
}

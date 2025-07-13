package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
	private final static String query="select count(*) from user2 where userid=? and uname=?";
	private static int uno;
	private static String uname;

    public static void main(String[] args) {
               
       try(
           	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
            Scanner sc=new Scanner(System.in);
    		PreparedStatement ps=con.prepareStatement(query);   
    		   
    		 
    		   ){
    	   System.out.println("Enter user number::");
    	   uno=sc.nextInt();
    	   System.out.println("Enter user name");
    	   uname=sc.next();
    	   ps.setInt(1, uno);
    	   ps.setString(2, uname);
    	   ResultSet rs=ps.executeQuery();
    	   rs.next();
    	   int count=rs.getInt(1);
    	   if(count==1) {
    		   System.out.println("Valid credentials");
    	   }else {
    		   System.out.println("Invalid Credentials");
    	   }
    	   
       }catch(Exception e) {
    	   e.printStackTrace();       }
       
    }
}

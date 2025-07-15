package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CallableS {
	private final static String query="{call P_GET_EMP_DETAILS_ENAME_CHARS(?,?)}";
	private static String initchar;
	
    public static void main(String[] args) {
               
       try(
           	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
            Scanner sc=new Scanner(System.in);
    		CallableStatement cs=con.prepareCall(query);
    		 
    		   ){
    	   System.out.println("Enter user starting letter::");
    	   initchar=sc.next();
    	   
    	   cs.registerOutParameter(2, OracleTypes.CURSOR);
    	   
    	   cs.setString(1, initchar+"%");
    	   cs.execute();
    	   ResultSet res=(ResultSet)cs.getObject(2);
    	   while(res.next()) {
    		   System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3));
    	   }
    	          }catch(Exception e) {
    	   e.printStackTrace();       }
       
    }
}

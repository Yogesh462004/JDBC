package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class NoSelectTest {
	private static final String query="insert into student1 values(?,?,?)";
	private static int cno;
	private static String cname;
	private static float avg;
	

    public static void main(String[] args) {
        
       try(
              	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
    		   PreparedStatement ps=con.prepareStatement(query);
            Scanner sc=new Scanner(System.in);
    		   ){
    	   System.out.println("Enter Student count::");
    	   int count=sc.nextInt();
    	   for(int i=0;i<count;i++) {
    		   System.out.println("Enter student details of student "+(i+1));
    		   System.out.println("Enter Student No::");
    		   cno=sc.nextInt();
    		   System.out.println("Enter Student Name::");
    		   cname=sc.next();
    		   System.out.println("Enter Avg::");
    		   avg=sc.nextFloat();
    		   ps.setInt(1, cno);
    		   ps.setString(2, cname);
    		   ps.setFloat(3, avg);
    		   int count1=ps.executeUpdate();
    		   if(count1>0) {
    			   System.out.println("Record Inserted");
    		   }
    		   
    		   
    	   }
    	   
       }catch(Exception e) {
    	   e.printStackTrace();       }
       
    }
}

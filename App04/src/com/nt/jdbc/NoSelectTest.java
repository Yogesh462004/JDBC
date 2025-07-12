package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NoSelectTest {

    public static void main(String[] args) {
        int no;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter student number to delete: ");
            no = sc.nextInt();
        }
       try(
           	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
            Statement st=con.createStatement();
    		 
    		   
    		 
    		   ){
    	   int count=st.executeUpdate("delete from student1 where sno="+no);
    	   System.out.println("Records deleted are::"+count);
    	   
       }catch(Exception e) {
    	   e.printStackTrace();       }
       
    }
}

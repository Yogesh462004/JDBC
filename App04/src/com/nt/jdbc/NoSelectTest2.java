package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NoSelectTest2 {

    public static void main(String[] args) {
        int no;
        String name;
        float sal;
        try (Scanner sc = new Scanner(System.in)) {
        	System.out.print("Enter student number: ");
            no = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            System.out.print("Enter student name: ");
            name = sc.nextLine();

            System.out.print("Enter student average: ");
            sal = sc.nextFloat();
        }
       try(
           	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
            Statement st=con.createStatement();
    		 
    		   
    		 
    		   ){
    	   int count=st.executeUpdate("insert into student1 values("+no+",'"+ name+"',"+sal+")");
    	   System.out.println(count+"::Records inserted");
    	   
       }catch(Exception e) {
    	   e.printStackTrace();       }
       
    }
}

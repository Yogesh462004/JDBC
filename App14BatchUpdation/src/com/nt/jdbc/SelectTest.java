package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

    public static void main(String[] args) {
        
        try (
        	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system","2025");
            Statement st = con.createStatement();
            
        ) {
           st.addBatch("insert into student1 values(71,'Yo',9.55)");
           st.addBatch("update student1 set avg=8 where avg<8");
           st.addBatch("delete from student1 where sno=2");
           int results[]=st.executeBatch();
           int sum=0;
           for(int i=0;i<results.length;i++) {
        	   System.out.println(results[i]);
        	   sum=sum+results[i];
           }
           System.out.println(sum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}

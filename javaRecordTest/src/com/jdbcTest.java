package com;

import java.sql.Driver;

public class jdbcTest {
    public static void main(String[] args){
        try{
        Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println(driver);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

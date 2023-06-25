package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Accessing_Database_via_Simple_Java_Application {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "**********");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT salary, first_name, last_name FROM employees WHERE salary >= ?");

        System.out.print("Insert salary: ");
        String salary = scanner.nextLine();
        System.out.println();

        preparedStatement.setDouble(1, Double.parseDouble(salary));

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString("salary") + " " +
                    resultSet.getString("first_name") + " " +
                    resultSet.getString("last_name"));
        }

    }
}

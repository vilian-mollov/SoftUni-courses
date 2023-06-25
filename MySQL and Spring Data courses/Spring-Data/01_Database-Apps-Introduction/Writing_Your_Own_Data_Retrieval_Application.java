package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Writing_Your_Own_Data_Retrieval_Application {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "**********");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);

        PreparedStatement preparedStatement =
                connection
                        .prepareStatement("SELECT count(*) AS games, user_name, first_name, last_name " +
                                "FROM users_games " +
                                "join users on user_id = users.id " +
                                "where user_name = ? " +
                                "group by users.id;");


        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println();

        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(!resultSet.next()){
            System.out.println("No such user exists");
            return;
        }

        do {

            System.out.println("User: " + resultSet.getString("user_name") + "\n"
                    + resultSet.getString("first_name") + " " + resultSet.getString("last_name")
                    + " has played " + resultSet.getInt("games") + " games");

            System.out.println();

        } while (resultSet.next());

    }
}

package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DiabloDB_JOIN_Selection {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "***********");


        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", properties);


        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM users_games AS ug\n " +
                        "JOIN users AS u ON u.id = ug.user_id\n " +
                        "JOIN characters AS c ON c.id = ug.character_id\n " +
                        "JOIN user_game_items AS ugi ON ugi.user_game_id = ug.id\n " +
                        "JOIN items AS i ON i.id = ugi.item_id\n " +
                        "JOIN statistics AS s ON s.id = i.statistics_id\n " +
                        "WHERE u.id = ?;");

        System.out.print("Enter id: ");
        String id = sc.nextLine();
        System.out.println();
        preparedStatement.setInt(1, Integer.parseInt(id));

        ResultSet resultSet = preparedStatement.executeQuery();


        if (!resultSet.next()) {
            System.out.println("ResultSet is empty");
        } else {

            do {

                System.out.println(resultSet.getString(9) + " " + resultSet.getString(10) + " " +
                        resultSet.getString(11) + " " + resultSet.getString(17) + " " +
                        resultSet.getString(22) + " " + resultSet.getString(25));

            }
            while (resultSet.next());


            connection.close();
        }
    }

}
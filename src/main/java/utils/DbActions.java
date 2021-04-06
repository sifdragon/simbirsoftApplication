package utils;

import data.Word;

import java.sql.*;

import java.time.LocalDate;
import java.util.List;

public class DbActions {
    public static void insertData(List<Word> countList, String url) throws SQLException {
        LocalDate localDate = LocalDate.now();
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "grand229")) {
            for (int i = 0; i < countList.size(); i++) {
                try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"frequency_schema\".\"frequency_table\" (body, count, date, url) " +
                        "VALUES (?, ?, ?, ?) on conflict do nothing ")) {
                    {
                        preparedStatement.setString(1, countList.get(i).getBody());
                        preparedStatement.setInt(2, countList.get(i).getCount());
                        preparedStatement.setObject(3, localDate);
                        preparedStatement.setString(4, url);
                        preparedStatement.executeUpdate();
                    }
                }
            }
        }
        System.out.println("Data has been inserted!");
    }
}

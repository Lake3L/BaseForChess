package com.company;

import java.sql.*;

public class ConnectorToBase {
    public static Connection connect;
    public static Statement statmt;
    public static ResultSet resSet;

    // -----ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ-----
    public static void Conn() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection("jdbc:sqlite:Base.s3db");
        statmt = connect.createStatement();
        System.out.println("База Подключена!");
    }

    // -----Создание таблицы-----
    public static void CreateDB() throws ClassNotFoundException, SQLException {
        statmt.execute("CREATE TABLE if not exists 'part id' (" +
                "'part ID' INTEGER PRIMARY KEY UNIQUE NOT NULL, " +
                "'part name' STRING)");
        statmt.execute("CREATE TABLE if not exists 'base' (" +
                "'part id' INTEGER PRIMARY KEY UNIQUE NOT NULL, " +
                "'player' TEXT NOT NULL, " +
                "'part name' TEXT NOT NULL REFERENCES part_id, " +
                "'matches' INTEGER, " +
                "'score' DOUBLE)");
        System.out.println("Таблица создана или уже существует.");
    }

    // -----Заполнение таблицы-----
    public static void WriteDB() throws SQLException {
        statmt.execute("INSERT INTO 'part_id' ('partName', 'player'," +
                " 'matches', 'score') VALUES ('game1', 'player1', 1, 2:2); ");
        statmt.execute("INSERT INTO 'part_id' ('partName', 'player'," +
                " 'matches', 'score') VALUES ('game2', 'player2', 2, 1:2); ");
        statmt.execute("INSERT INTO 'part_id' ('partName', 'player'," +
                " 'matches', 'score') VALUES ('game3', 'player3', 1, 1:0); ");

        System.out.println("Таблица заполнена");
    }
    // -----Закрытие-----
    public static void CloseDB() throws ClassNotFoundException, SQLException {
        connect.close();
        statmt.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }

}

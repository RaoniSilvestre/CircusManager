package br.ufrn.imd.circusmanager.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:circus.db";

    public static Connection connect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Conexão com banco de dados estabelecida!");
            return connection;
        }  catch (SQLException e) {
            System.out.println("Erro ao conectar com Sqlite!");
            throw new RuntimeException(e);
        }
    }
}

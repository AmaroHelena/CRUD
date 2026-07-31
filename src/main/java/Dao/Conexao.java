package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    // Altere 'NOME_DO_SEU_BANCO' para o banco que você criou no XAMPP (phpMyAdmin)
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro_de_produtos";
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 
    
    public static Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao XAMPP: " + e.getMessage());
        }
        return conn;
    }
}
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:keuangan.db"; // SQLite file lokal
    private static Connection conn;

    // Method untuk mendapatkan koneksi database.
    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL);
            }
        } catch (SQLException e) {
            //Menampilkan error jika koneksi gagal dibuat
            e.printStackTrace();
        }
        return conn;
    }
}

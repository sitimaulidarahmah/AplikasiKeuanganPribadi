package database;
import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        
        //Query SQL untuk membuat tabel "transaksi" jika belum ada.
        // IF NOT EXISTS digunakan agar tidak error jika tabel sudah tersedia.
        String sql = "CREATE TABLE IF NOT EXISTS transaksi ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "tanggal DATE,"
                + "tipe TEXT,"
                + "kategori TEXT,"
                + "jumlah DOUBLE,"
                + "deskripsi TEXT"
                + ");";

        // Try-with-resources: memastikan koneksi & statement otomatis ditutup
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            // Menjalankan perintah SQL untuk membuat tabel
            stmt.execute(sql);
            System.out.println("Tabel 'transaksi' berhasil dibuat atau sudah ada.");

        } catch (SQLException e) {
            
            // Menampilkan pesan error jika terjadi masalah saat membuat tabel
            System.out.println("Error: " + e.getMessage());
        }
    }
}

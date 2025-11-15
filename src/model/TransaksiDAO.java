package model;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiDAO {

    // Tambah transaksi
    public void insert(Transaksi t) throws SQLException {
        String sql = "INSERT INTO transaksi (tanggal, tipe, kategori, jumlah, deskripsi) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(t.getTanggal().getTime()));
            ps.setString(2, t.getTipe());
            ps.setString(3, t.getKategori());
            ps.setDouble(4, t.getJumlah());
            ps.setString(5, t.getDeskripsi());
            ps.executeUpdate();
        }
    }

    // Ambil semua transaksi
    public List<Transaksi> getAll() throws SQLException {
        List<Transaksi> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi ORDER BY tanggal DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Transaksi t = new Transaksi();
                t.setId(rs.getInt("id"));
                t.setTanggal(rs.getDate("tanggal"));
                t.setTipe(rs.getString("tipe"));
                t.setKategori(rs.getString("kategori"));
                t.setJumlah(rs.getDouble("jumlah"));
                t.setDeskripsi(rs.getString("deskripsi"));
                list.add(t);
            }
        }
        return list;
    }

    // Update transaksi
    public void update(Transaksi t) throws SQLException {
        String sql = "UPDATE transaksi SET tanggal=?, tipe=?, kategori=?, jumlah=?, deskripsi=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(t.getTanggal().getTime()));
            ps.setString(2, t.getTipe());
            ps.setString(3, t.getKategori());
            ps.setDouble(4, t.getJumlah());
            ps.setString(5, t.getDeskripsi());
            ps.setInt(6, t.getId());
            ps.executeUpdate();
        }
    }

    // DELETE ALL / Hapus Semua Transaksi
    public void deleteAll() throws SQLException {
    String sql = "DELETE FROM transaksi";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.executeUpdate();
    }
}

    //  DELETE BY ID / Hapus Satu Transaksi
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM transaksi WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

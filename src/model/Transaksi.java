package model;

import java.util.Date;

public class Transaksi {

    private int id;               
    private Date tanggal;
    private String tipe;
    private String kategori;
    private double jumlah;
    private String deskripsi;

    public Transaksi() {
        // Constructor kosong untuk keperluan DAO (saat load dari database)
    }

    // 🔹 Constructor tanpa id (untuk tambah data baru)
    public Transaksi(Date tanggal, String tipe, String kategori, double jumlah, String deskripsi) {
        this.tanggal = tanggal;
        this.tipe = tipe;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.deskripsi = deskripsi;
    }

    // 🔹 Constructor dengan id (untuk data dari database)
    public Transaksi(int id, Date tanggal, String tipe, String kategori, double jumlah, String deskripsi) {
        this.id = id;
        this.tanggal = tanggal;
        this.tipe = tipe;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.deskripsi = deskripsi;
    }

    // 🔹 Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getTipe() {
        return tipe;
    }

    public String getKategori() {
        return kategori;
    }

    public double getJumlah() {
        return jumlah;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}

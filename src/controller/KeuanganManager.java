package controller;

import java.util.List;
import java.util.ArrayList;
import model.Transaksi;

public class KeuanganManager {
    //// Menyimpan semua transaksi di dalam list
    private List<Transaksi> daftarTransaksi = new ArrayList<>();

    //Menambahkan transaksi baru ke dalam list.
    public void tambahTransaksi(Transaksi t) {
        daftarTransaksi.add(t);
    }

    //Menghapus transaksi berdasarkan index (posisi dalam list).
    public void hapusTransaksi(int index) {
        if (index >= 0 && index < daftarTransaksi.size()) {
            daftarTransaksi.remove(index);
        }
    }
    
    //Mengubah transaksi pada posisi tertentu dengan data yang baru.
    public void ubahTransaksi(int index, Transaksi baru) {
        if (index >= 0 && index < daftarTransaksi.size()) {
            daftarTransaksi.set(index, baru);
        }
    }

    //Mengganti seluruh isi list transaksi dengan list baru.
    //Digunakan saat memuat data dari database atau import.
    public void setDaftarTransaksi(List<Transaksi> daftarBaru) {
        this.daftarTransaksi = daftarBaru;
    }

    //Mengambil seluruh daftar transaksi.
    public List<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }

    //Menghitung total pemasukan
    public double getTotalPemasukan() {
        return daftarTransaksi.stream()
                .filter(t -> t.getTipe().equals("Pemasukan"))
                .mapToDouble(Transaksi::getJumlah)
                .sum();
    }

    //Menghitung total pengeluaran
    public double getTotalPengeluaran() {
        return daftarTransaksi.stream()
                .filter(t -> t.getTipe().equals("Pengeluaran"))
                .mapToDouble(Transaksi::getJumlah)
                .sum();
    }

    //Menghitung total pemasukan secara manual
    public double hitungTotalPemasukan() {
        double total = 0;
        for (Transaksi t : daftarTransaksi) {
            if (t.getTipe().equalsIgnoreCase("Pemasukan")) {
                total += t.getJumlah();
            }
        }
        return total;
    }

    //Menghitung total pengeluaran secara manual
    public double hitungTotalPengeluaran() {
        double total = 0;
        for (Transaksi t : daftarTransaksi) {
            if (t.getTipe().equalsIgnoreCase("Pengeluaran")) {
                total += t.getJumlah();
            }
        }
        return total;
    }

    //Menghitung saldo (pemasukan - pengeluaran)
    public double getSaldo() {
        return getTotalPemasukan() - getTotalPengeluaran();
    }
}

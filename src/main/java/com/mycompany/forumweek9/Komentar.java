/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.forumweek9;

/**
 *
 * @author ASUS
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Komentar implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idKomentar;
    private String teks;
    private Pengguna pengirim;
    private Date timestamp;

    private static List<Komentar> daftarKomentar = new ArrayList<>();

    public Komentar(String idKomentar, String teks, Pengguna pengirim, Date timestamp) {
        this.idKomentar = idKomentar;
        this.teks = teks;
        this.pengirim = pengirim;
        this.timestamp = timestamp;
    }

    public String getIdKomentar() {
        return idKomentar;
    }

    public void setIdKomentar(String idKomentar) {
        this.idKomentar = idKomentar;
    }

    public String getTeks() {
        return teks;
    }

    public void setTeks(String teks) {
        this.teks = teks;
    }

    public Pengguna getPengirim() {
        return pengirim;
    }

    public void setPengirim(Pengguna pengirim) {
        this.pengirim = pengirim;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    // Method untuk menampilkan informasi komentar
    public void displayKomentar() {
        System.out.println("ID Komentar: " + idKomentar);
        System.out.println("Teks: " + teks);
        System.out.println("Pengirim: " + pengirim.getUsername());
        System.out.println("Timestamp: " + timestamp);
    }

    // Method tambahKomentar
    public static void tambahKomentar(String teks, Pengguna pengirim) {
        // Generate ID komentar unik
        String idKomentar = "K" + (daftarKomentar.size() + 1);
        Date timestamp = new Date(); // Waktu saat komentar dibuat

        Komentar komentarBaru = new Komentar(idKomentar, teks, pengirim, timestamp);

        daftarKomentar.add(komentarBaru);

        System.out.println("Komentar berhasil ditambahkan!");
    }

    public static void displayAllKomentar() {
        if (daftarKomentar.isEmpty()) {
            System.out.println("Belum ada komentar.");
        } else {
            for (Komentar komentar : daftarKomentar) {
                komentar.displayKomentar();
                System.out.println();
            }
        }
    }
}

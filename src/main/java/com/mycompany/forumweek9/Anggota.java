/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.forumweek9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Anggota extends Pengguna implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String idAnggota;
    protected List<String> keahlian;
    protected int totalTugasSelesai;
    protected List<Proyek> proyekList;

    public Anggota(String username, String email, String password, String idAnggota) {
        super(username, email, password);
        this.idAnggota = idAnggota;
        this.keahlian = new ArrayList<>();
        this.totalTugasSelesai = 0;
        this.proyekList = new ArrayList<>();
    }

    public void tambahAnggota(Pengguna anggota) {
        System.out.println("Anggota baru telah ditambahkan: " + anggota.getUsername());
    }

    public void buatLaporan(Proyek proyek) {
        if (proyek != null) {
            System.out.println("Laporan proyek \"" + proyek.getNamaProyek() + "\" oleh anggota \"" + this.getUsername() + "\".");
        } else {
            System.out.println("Proyek tidak valid!");
        }
    }

    public void tambahProyek(Proyek proyek) {
        if (proyek != null) {
            proyekList.add(proyek);
            System.out.println("Proyek \"" + proyek.getNamaProyek() + "\" berhasil ditambahkan ke anggota \"" + this.getUsername() + "\".");
        } else {
            System.out.println("Proyek tidak valid!");
        }
    }

    public void hapusProyek(Proyek proyek) {
        if (proyekList.remove(proyek)) {
            System.out.println("Proyek \"" + proyek.getNamaProyek() + "\" berhasil dihapus dari anggota \"" + this.getUsername() + "\".");
        } else {
            System.out.println("Proyek tidak ditemukan pada anggota \"" + this.getUsername() + "\".");
        }
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
    }

    public List<String> getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(List<String> keahlian) {
        this.keahlian = keahlian;
    }

    public int getTotalTugasSelesai() {
        return totalTugasSelesai;
    }

    public void setTotalTugasSelesai(int totalTugasSelesai) {
        this.totalTugasSelesai = totalTugasSelesai;
    }

    public List<Proyek> getProyekList() {
        return proyekList;
    }

    public void setProyekList(List<Proyek> proyekList) {
        this.proyekList = proyekList;
    }

    @Override
    public String toString() {
        return "Member{" +
                "idAnggota='" + idAnggota + '\'' +
                ", keahlian=" + keahlian +
                ", totalTugasSelesai=" + totalTugasSelesai +
                ", proyekList=" + proyekList +
                ", username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}

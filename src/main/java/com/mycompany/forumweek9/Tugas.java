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

public class Tugas implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idTugas;
    private String namaTugas;
    private String deskripsi;
    private Date deadline;
    private String status; 
    private String prioritas; 
    private List<Komentar> komentarList;

    public Tugas(String idTugas, String namaTugas, String deskripsi, Date deadline, String status, String prioritas) {
        this.idTugas = idTugas;
        this.namaTugas = namaTugas;
        this.deskripsi = deskripsi;
        this.deadline = deadline;
        this.status = status;
        this.prioritas = prioritas;
        this.komentarList = new ArrayList<>();
    }

    public String getIdTugas() {
        return idTugas;
    }

    public void setIdTugas(String idTugas) {
        this.idTugas = idTugas;
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(String prioritas) {
        this.prioritas = prioritas;
    }

    public List<Komentar> getKomentarList() {
        return komentarList;
    }

    // Method ubahStatus
    public void ubahStatus(String status) {
        this.status = status;
        System.out.println("Status tugas berhasil diubah menjadi: " + status);
    }

    public void tambahKomentar(Komentar komentar) {
        komentarList.add(komentar);
        System.out.println("Komentar berhasil ditambahkan: " + komentar.getTeks());
    }

    public void displayDetailTugas() {
        System.out.println("ID Tugas: " + idTugas);
        System.out.println("Nama Tugas: " + namaTugas);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Deadline: " + deadline);
        System.out.println("Status: " + status);
        System.out.println("Prioritas: " + prioritas);
        System.out.println("Daftar Komentar:");
        for (Komentar komentar : komentarList) {
            System.out.println("- " + komentar.getTeks() + " (oleh: " + komentar.getPengirim().getUsername() + ")");
        }
    }
}

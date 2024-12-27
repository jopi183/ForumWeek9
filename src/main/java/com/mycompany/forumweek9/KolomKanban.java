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
import java.util.List;

public class KolomKanban implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idKolomKanban;
    private String namaKolom;
    private List<Tugas> tugasList;

    public KolomKanban(String idKolomKanban, String namaKolom) {
        this.idKolomKanban = idKolomKanban;
        this.namaKolom = namaKolom;
        this.tugasList = new ArrayList<>();
    }

    public String getIdKolomKanban() {
        return idKolomKanban;
    }

    public void setIdKolomKanban(String idKolomKanban) {
        this.idKolomKanban = idKolomKanban;
    }

    public String getNamaKolom() {
        return namaKolom;
    }

    public void setNamaKolom(String namaKolom) {
        this.namaKolom = namaKolom;
    }

    public List<Tugas> getTugasList() {
        return tugasList;
    }

    public void tambahTugas(Tugas tugas) {
        tugasList.add(tugas);
        System.out.println("Tugas berhasil ditambahkan ke kolom: " + namaKolom);
    }

    public boolean hapusTugas(String idTugas) {
        for (Tugas tugas : tugasList) {
            if (tugas.getIdTugas().equals(idTugas)) {
                tugasList.remove(tugas);
                System.out.println("Tugas dengan ID " + idTugas + " berhasil dihapus dari kolom: " + namaKolom);
                return true;
            }
        }
        System.out.println("Tugas dengan ID " + idTugas + " tidak ditemukan di kolom: " + namaKolom);
        return false;
    }
    
       public Tugas findTugasById(KolomKanban kolom, String idTugas) {
        for (Tugas tugas : kolom.getTugasList()) {
            if (tugas.getIdTugas().equals(idTugas)) {
                return tugas;
            }
        }
        return null;
    }



    public void displayTugasDalamKolom() {
        System.out.println("Kolom: " + namaKolom + " (ID: " + idKolomKanban + ")");
        if (tugasList.isEmpty()) {
            System.out.println("Tidak ada tugas dalam kolom ini.");
        } else {
            for (Tugas tugas : tugasList) {
                System.out.println("- " + tugas.getNamaTugas() + " (ID: " + tugas.getIdTugas() + ")");
            }
        }
    }
}

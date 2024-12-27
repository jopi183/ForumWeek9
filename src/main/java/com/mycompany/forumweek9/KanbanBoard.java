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

public class KanbanBoard implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String idKanban;
    protected String namaBoard;
    protected List<KolomKanban> kolomList;

    public KanbanBoard(String idKanban, String namaBoard) {
        this.idKanban = idKanban;
        this.namaBoard = namaBoard;
        this.kolomList = new ArrayList<>();
    }

    public String getIdKanban() {
        return idKanban;
    }

    public void setIdKanban(String idKanban) {
        this.idKanban = idKanban;
    }

    public String getNamaBoard() {
        return namaBoard;
    }

    public void setNamaBoard(String namaBoard) {
        this.namaBoard = namaBoard;
    }

    public List<KolomKanban> getKolomList() {
        return kolomList;
    }

    public void tambahKolom(KolomKanban kolom) {
        kolomList.add(kolom);
        System.out.println("Kolom '" + kolom.getNamaKolom() + "' berhasil ditambahkan ke board '" + namaBoard + "'.");
    }

    public boolean pindahTugas(Tugas tugas, KolomKanban dariKolom, KolomKanban keKolom) {
        if (!kolomList.contains(dariKolom)) {
            System.out.println("Kolom asal tidak ditemukan di board.");
            return false;
        }
        if (!kolomList.contains(keKolom)) {
            System.out.println("Kolom tujuan tidak ditemukan di board.");
            return false;
        }

        if (!dariKolom.getTugasList().contains(tugas)) {
            System.out.println("Tugas tidak ditemukan di kolom asal.");
            return false;
        }

        dariKolom.hapusTugas(tugas.getIdTugas());
        keKolom.tambahTugas(tugas);
        System.out.println("Tugas '" + tugas.getNamaTugas() + "' berhasil dipindahkan dari kolom '" 
                            + dariKolom.getNamaKolom() + "' ke kolom '" + keKolom.getNamaKolom() + "'.");
        return true;
    }
        public KolomKanban findKolomById(KanbanBoard board, String idKolom) {
        for (KolomKanban kolom : board.getKolomList()) {
            if (kolom.getIdKolomKanban().equals(idKolom)) {
                return kolom;
            }
        }
        return null;
    }


    public void displayBoard() {
        System.out.println("Kanban Board: " + namaBoard + " (ID: " + idKanban + ")");
        for (KolomKanban kolom : kolomList) {
            kolom.displayTugasDalamKolom();
        }
    }
}

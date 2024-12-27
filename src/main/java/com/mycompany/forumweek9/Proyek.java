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
import java.util.List;

public class Proyek implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idProyek;
    private String namaProyek;
    private String deskripsi;
    private KanbanBoard kanBanBoard;
    private List<Pengguna> anggota;

    // Constructor
    public Proyek(String idProyek, String namaProyek, String deskripsi, List<Pengguna> anggota) {
        this.idProyek = idProyek;
        this.namaProyek = namaProyek;
        this.deskripsi = deskripsi;
        this.anggota = anggota;
        this.kanBanBoard = new KanbanBoard(idProyek + "-Board", "Kanban for " + namaProyek);
    }

    // Getter dan Setter
    public String getIdProyek() {
        return idProyek;
    }

    public void setIdProyek(String idProyek) {
        this.idProyek = idProyek;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public KanbanBoard getKanBanBoard() {
        return kanBanBoard;
    }

    public List<Pengguna> getAnggota() {
        return anggota;
    }

    public void setAnggota(List<Pengguna> anggota) {
        this.anggota = anggota;
    }

    // Method untuk melihat progres proyek
    public void lihatProgres() {
        System.out.println("Progres Proyek: " + namaProyek + " (ID: " + idProyek + ")");
        kanBanBoard.displayBoard();
    }

}

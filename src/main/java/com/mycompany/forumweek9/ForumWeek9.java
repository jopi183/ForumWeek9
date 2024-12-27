/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.forumweek9;

/**
 *
 * @author ASUS
 */
import java.io.*;
import java.util.*;

public class ForumWeek9 {
    private static final String FILE_PATH = "data.ser";
    private static List<Proyek> proyekList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadFromFile();

        while (true) {
            System.out.println("\n=== Aplikasi Kanban Board ===");
            System.out.println("1. Buat Proyek Baru");
            System.out.println("2. Tampilkan Daftar Proyek");
            System.out.println("3. Tambah Anggota ke Proyek");
            System.out.println("4. Kelola Kanban Board Proyek");
            System.out.println("5. Simpan dan Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    buatProyek(scanner);
                    break;
                case 2:
                    tampilkanProyek();
                    break;
                case 3:
                    tambahAnggota(scanner);
                    break;
                case 4:
                    kelolaKanbanBoard(scanner);
                    break;
                case 5:
                    saveToFile();
                    System.out.println("Data disimpan. Keluar dari aplikasi.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void buatProyek(Scanner scanner) {
        System.out.print("Masukkan ID Proyek: ");
        String idProyek = scanner.nextLine();
        System.out.print("Masukkan Nama Proyek: ");
        String namaProyek = scanner.nextLine();
        System.out.print("Masukkan Deskripsi Proyek: ");
        String deskripsi = scanner.nextLine();

        Proyek proyek = new Proyek(idProyek, namaProyek, deskripsi, new ArrayList<>());
        proyekList.add(proyek);

        System.out.println("Proyek berhasil dibuat.");
    }

    private static void tampilkanProyek() {
        if (proyekList.isEmpty()) {
            System.out.println("Tidak ada proyek yang tersedia.");
        } else {
            System.out.println("\nDaftar Proyek:");
            for (int i = 0; i < proyekList.size(); i++) {
                Proyek proyek = proyekList.get(i);
                System.out.println((i + 1) + ". " + proyek.getNamaProyek() + " (ID: " + proyek.getIdProyek() + ")");
            }
        }
    }

    private static void tambahAnggota(Scanner scanner) {
        tampilkanProyek();
        System.out.print("Pilih proyek (nomor): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index >= 0 && index < proyekList.size()) {
            Proyek proyek = proyekList.get(index);
            System.out.print("Masukkan Username Anggota: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan Email Anggota: ");
            String email = scanner.nextLine();
            System.out.print("Masukkan Password Anggota: ");
            String password = scanner.nextLine();
            System.out.print("Masukkan ID Anggota: ");
            String idAnggota = scanner.nextLine();

            Anggota anggota = new Anggota(username, email, password, idAnggota);
            proyek.getAnggota().add(anggota);

            System.out.println("Anggota berhasil ditambahkan ke proyek.");
        } else {
            System.out.println("Proyek tidak valid.");
        }
    }

    private static void kelolaKanbanBoard(Scanner scanner) {
        tampilkanProyek();
        System.out.print("Pilih proyek (nomor): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 
        if (index >= 0 && index < proyekList.size()) {
            Proyek proyek = proyekList.get(index);
            KanbanBoard board = proyek.getKanBanBoard();

            while (true) {
                System.out.println("\n=== Kelola Kanban Board ===");
                System.out.println("1. Tambah Kolom");
                System.out.println("2. Tambah Tugas ke Kolom");
                System.out.println("3. Pindahkan Tugas Antar Kolom");
                System.out.println("4. Tampilkan Board");
                System.out.println("5. Kembali ke Menu Utama");
                System.out.print("Pilih menu: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan ID Kolom: ");
                        String idKolom = scanner.nextLine();
                        System.out.print("Masukkan Nama Kolom: ");
                        String namaKolom = scanner.nextLine();

                        KolomKanban kolom = new KolomKanban(idKolom, namaKolom);
                        board.tambahKolom(kolom);
                        break;
                    case 2:
                        tambahTugasKeKolom(scanner, board);
                        break;
                    case 3:
                        pindahkanTugas(scanner, board);
                        break;
                    case 4:
                        board.displayBoard();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        } else {
            System.out.println("Proyek tidak valid.");
        }
    }

    private static void tambahTugasKeKolom(Scanner scanner, KanbanBoard board) {
        System.out.print("Masukkan ID Kolom: ");
        String idKolom = scanner.nextLine();
        KolomKanban kolom = board.findKolomById(board, idKolom);

        if (kolom != null) {
            System.out.print("Masukkan ID Tugas: ");
            String idTugas = scanner.nextLine();
            System.out.print("Masukkan Nama Tugas: ");
            String namaTugas = scanner.nextLine();
            System.out.print("Masukkan Deskripsi Tugas: ");
            String deskripsi = scanner.nextLine();
            System.out.print("Masukkan Prioritas Tugas: ");
            String prioritas = scanner.nextLine();
            System.out.print("Masukkan Status Tugas: ");
            String status = scanner.nextLine();

            Tugas tugas = new Tugas(idTugas, namaTugas, deskripsi, new Date(), status, prioritas);
            kolom.tambahTugas(tugas);

            System.out.println("Tugas berhasil ditambahkan.");
        } else {
            System.out.println("Kolom tidak ditemukan.");
        }
    }

    private static void pindahkanTugas(Scanner scanner, KanbanBoard board) {
        System.out.print("Masukkan ID Kolom Asal: ");
        String idKolomAsal = scanner.nextLine();
        KolomKanban kolomAsal = board.findKolomById(board, idKolomAsal);

        System.out.print("Masukkan ID Kolom Tujuan: ");
        String idKolomTujuan = scanner.nextLine();
        KolomKanban kolomTujuan = board.findKolomById(board, idKolomTujuan);

        if (kolomAsal != null && kolomTujuan != null) {
            System.out.print("Masukkan ID Tugas: ");
            String idTugas = scanner.nextLine();
            Tugas tugas = kolomAsal.findTugasById(kolomAsal, idTugas);

            if (tugas != null) {
                board.pindahTugas(tugas, kolomAsal, kolomTujuan);
            } else {
                System.out.println("Tugas tidak ditemukan.");
            }
        } else {
            System.out.println("Kolom asal atau tujuan tidak ditemukan.");
        }
    }


    private static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(proyekList);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            proyekList = (List<Proyek>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Tidak ada data yang ditemukan.");
        }
    }
}

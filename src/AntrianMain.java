import java.util.Scanner;

public class AntrianMain {

    public static void main(String[] args) throws Exception {
        SistemAntrian antrian = new SistemAntrian();
        Scanner input = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\nSistem Antrian Klinik");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Antrian");
            System.out.println("4. Cek Sisa Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Input Nama Pasien: ");
                    String nama = input.nextLine();
                    System.out.print("Input NIK Pasien: ");
                    String nik = input.nextLine();
                    System.out.print("Input Keluhan Pasien: ");
                    String keluhan = input.nextLine();

                    Pasien pasien = new Pasien(nama, nik, keluhan);
                    antrian.tambahPasien(pasien);
                    System.out.println("Pasien " + nama + " telah ditambahkan ke dalam antrian.");
                    break;

                case 2:
                    antrian.lihatAntrian();
                    break;
                case 3:
                    antrian.layaniPasien();
                    break;
                case 4:
                    System.out.println("Sisa antrian: " + antrian.sisaAntrian());
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem antrian.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    break;
            }
        } while (pilihan != 0);
        input.close();
    }
}

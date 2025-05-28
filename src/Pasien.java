public class Pasien {
    String nama, nik, keluhan;

    Pasien(String nama, String nik, String keluhan) {
        this.nama = nama;
        this.nik = nik;
        this.keluhan = keluhan;
    }

    void tampil() {
        System.out.println(nama + " | " + nik + " | " + keluhan);
    }
}

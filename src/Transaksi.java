public class Transaksi {
    Pasien pasien;
    Dokter dokter;
    int durasi, biaya;

    Transaksi(Pasien pasien, Dokter dokter, int durasi) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasi = durasi;
        this.biaya = durasi * 50000;
    }

    void tampil() {
        System.out.println(pasien.nama + " - " + dokter.nama +
                " | " + durasi + " jam | Rp" + biaya);
    }
}

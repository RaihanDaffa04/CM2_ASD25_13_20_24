public class TransaksiLayanan {
    Pasien pasien;
    Dokter dokter;
    int durasi, biaya;

    TransaksiLayanan(Pasien pasien, Dokter dokter, int durasi) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasi = durasi;
        this.biaya = hitungBiaya();
    }

    int hitungBiaya(){
        return durasi*50000;
    }

    void tampilkanTransaksi() {
        System.out.println(pasien.nama + "\t" + dokter.nama + "\t" + durasi + "\t" + biaya);
    }
}

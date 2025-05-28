import java.util.Scanner;

public class SistemAntrian {
    NodePasien headPasien, tailPasien;
    NodeDokter headDokter = null;
    NodeTransaksi headTransaksi, tailTransaksi;
    int size;
    
    public boolean isEmpty(){
        return size == 0;
    }

    public void tambahPasien(Pasien pasien) {
        NodePasien newNode = new NodePasien(headPasien, pasien, null);
            if (headPasien == null) {  
                headPasien = newNode;  
            } else {
                NodePasien temp = headPasien;
                while (temp.next != null) {  
                    temp = temp.next;
                }
                temp.next = newNode; 
            size++; 
        }
    }

    public void lihatAntrian() {
        if (headPasien == null) {
            System.out.println("Tidak ada pasien dalam antrian.");
        } else {
            NodePasien temp = headPasien;
            System.out.println("-- Antrian Pasien --");
            while (temp != null) {
                System.out.println("Nama: " + temp.data.nama + " | NIK: " + temp.data.nik + " | Keluhan: " + temp.data.keluhan);
                temp = temp.next;  
            }
        }
    }
    
    public SistemAntrian() {
        tambahDokter(new Dokter("dr01", "Wike Ratanca"));
        tambahDokter(new Dokter("dr02", "Santi Runica"));
        tambahDokter(new Dokter("dr03", "Aam Antanica"));
        tambahDokter(new Dokter("dr04", "Slamet Sugito"));
    }

    void tambahDokter(Dokter d) {
        NodeDokter baru = new NodeDokter(d);
        if (headDokter == null) {
            headDokter = baru;
        } else {
            NodeDokter current = headDokter;
            while (current.next != null) {
                current = current.next;
            }
            current.next = baru;
        }
    }

    public Pasien layaniPasien() throws Exception {
    if (headPasien == null) {
        throw new Exception("Antrian kosong, tidak ada pasien yang bisa dilayani!");
    }

    Pasien p = headPasien.data;
    if (headPasien == tailPasien) {
        headPasien = tailPasien = null;
    } else {
        headPasien = headPasien.next;
        headPasien.prev = null;
    }
    size--;

    System.out.println("Pasien " + p.nama + " dipanggil");
    System.out.println("Daftar dokter jaga :");
    System.out.println("Kode\tNama");
    NodeDokter current = headDokter;
    while (current != null) {
        System.out.println(current.data.id + "\t" + current.data.nama);
        current = current.next;
    }
    Scanner sc = new Scanner(System.in);
    System.out.print("\ninput kode dokter: ");
    String kode = sc.nextLine();
    Dokter dipilih = null;
    current = headDokter;
    while (current != null) {
        if (current.data.id.equalsIgnoreCase(kode)) {
            dipilih = current.data;
            break;
        }
        current = current.next;
    }

    if (dipilih == null) {
        System.out.println("Dokter tidak ditemukan.");
        return null;
    }

    System.out.print("input durasi layanan(jam): ");
    int durasi = sc.nextInt();

    TransaksiLayanan trx = new TransaksiLayanan(p, dipilih, durasi);

    NodeTransaksi newTrx = new NodeTransaksi(trx);

    if (headTransaksi == null) {
        headTransaksi = tailTransaksi = newTrx;
    } else {
        tailTransaksi.next = newTrx;
        tailTransaksi = newTrx;
    }

    System.out.println(">> Pasien telah dilayani, transaksi berhasil dicatat");
    return p;
}
}

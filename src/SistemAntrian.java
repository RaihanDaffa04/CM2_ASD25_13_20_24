public class SistemAntrian {
    NodePasien headPasien=null;
    NodeTransaksi headTransaksi=null;
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

    public void tampilkanRiwayat() {
        NodeTransaksi current = headTransaksi;
        while (current != null) {
            current.data.tampilkanTransaksi(); 
        }
    }

    public void sortRiwayatDESC(){
        if (headTransaksi==null || headTransaksi.next==null) {
            return;
        }
        boolean tukar;
        do {
            tukar=false;
            NodeTransaksi current = headTransaksi;

            while (current.next != null) {
                String nama1 = current.data.pasien.nama.toLowerCase();
                String nama2 = current.next.data.pasien.nama.toLowerCase();
                if (nama1.compareTo(nama2) < 0) {
                    TransaksiLayanan temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    tukar = true;
                }
                current = current.next;
            }
        } while (tukar);
    }
}

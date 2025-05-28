public class SistemAntrian {
    NodePasien headPasien=null;
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
}

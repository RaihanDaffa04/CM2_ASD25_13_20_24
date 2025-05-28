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
}

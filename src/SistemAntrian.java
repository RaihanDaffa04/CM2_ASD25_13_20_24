public class SistemAntrian {
    NodePasien head = null;
    NodeDokter headDokter = null;

    
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

    Dokter cariDokter(String kode) {
        NodeDokter current = headDokter;
        while (current != null) {
            if (current.data.id.equalsIgnoreCase(kode)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    
}

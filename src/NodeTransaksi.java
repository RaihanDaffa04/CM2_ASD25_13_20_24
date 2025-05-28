public class NodeTransaksi {
    Transaksi data;
    NodeTransaksi prev, next;

    NodeTransaksi(NodeTransaksi prev, Transaksi data, NodeTransaksi next) {
        this.prev=null;
        this.data = data;
        this.next=null;
    }
}

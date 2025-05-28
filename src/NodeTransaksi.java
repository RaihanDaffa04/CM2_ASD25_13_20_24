public class NodeTransaksi {
    TransaksiLayanan data;
    NodeTransaksi prev, next;

    NodeTransaksi(NodeTransaksi prev, TransaksiLayanan data, NodeTransaksi next) {
        this.prev=null;
        this.data = data;
        this.next=null;
    }
    NodeTransaksi(TransaksiLayanan data){
        this.data = data;
    }
}

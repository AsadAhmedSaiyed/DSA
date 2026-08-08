import java.util.LinkedList;

public class DesignHM {
    class MyHashMap {

    private class Node{
        int key;
        int value;
        public Node(int k, int v){
            this.key = k;
            this.value =v;
        }
    }

    private int n;
    private int N;
    private LinkedList<Node> buckets[];

    public MyHashMap() {
        this.N = 16;
        this.buckets = new LinkedList[N];
        for(int i=0;i<N;i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

        private void rehash(){
            LinkedList<Node> old[] = this.buckets;
            this.N = 2*N;
            this.buckets = new LinkedList[this.N];
            for(int i=0;i<this.N;i++){
                this.buckets[i] = new LinkedList<>();
            }
            this.n = 0;
            for(int i=0;i<old.length;i++){
                LinkedList<Node> ll = old[i];
                int size = ll.size();
                for(int j=0;j<size;j++){
                    Node node = ll.remove();
                    this.put(node.key,node.value);
                }
            }
        }
    
    private int hash(int key){
        return key % N;
    }

    private int searchInLL(int key, int bi){
        LinkedList<Node> ll = this.buckets[bi];
        int di =0;
        for(Node node : ll){
           if(node.key == key){
             return di;
           }
           di++;
        }
        return -1;
    }

    public void put(int key, int value) {
        int bi = hash(key);
        int di = searchInLL(key,bi);
        if(di != -1){
            Node node = this.buckets[bi].get(di);
            node.value = value;
        }else{
            this.buckets[bi].add(new Node(key,value));
            n++;
        }
        double lambda = (double) n/N;
        if(lambda > 0.75){
            rehash();
        }
    }
    
    public int get(int key) {
        int bi = hash(key);
        int di = searchInLL(key,bi);
        if(di != -1){
            Node node = this.buckets[bi].get(di);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void remove(int key) {
        int bi = hash(key);
        int di = searchInLL(key,bi);
        if(di != -1){
            Node node = this.buckets[bi].remove(di);
            n--;
        }
    }
}

}

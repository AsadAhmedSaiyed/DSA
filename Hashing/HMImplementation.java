import java.util.*;

public class HMImplementation {
    static class HashMap<K, V> {// generic -> K,V can be of any type
        private class Node {
            K key;
            V val;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[]; // N

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // add nodes in new bucket
            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.val);

                }
            }

        }

        private int hashFxn(K key) {
            int hc = key.hashCode(); // it can +ve or -ve
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (Node node : ll) {
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        public void put(K key, V val) {
            int bi = hashFxn(key); // 0-> size-1
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.val = val;
            } else {
                buckets[bi].add(new Node(key, val));
                n++;
            }
            double lamda = (double) n / N;
            if (lamda > 2) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFxn(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) {
            int bi = hashFxn(key); // 0-> size-1
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.val;
                
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFxn(key); // 0-> size-1
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.val;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 250);
        hm.put("china", 150);
        hm.put("Iran", 50);
        ArrayList<String> keys = hm.keySet();
        for (String string : keys) {
            System.out.println(string);
        }
    }
}

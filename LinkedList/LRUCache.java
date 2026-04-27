import java.util.*;
class LRUCache {
    private class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            next = prev = null;
        }
    }
    HashMap<Integer, Node> m;
    int n;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.n = capacity;
        this.m = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!m.containsKey(key)) return -1;
        Node node = m.get(key);
        remove(node);
        insertAtFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node node = m.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
        }else{
            if(m.size() == n){
                Node lru = tail.prev;
                remove(lru);
                m.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            m.put(key, newNode);
            insertAtFront(newNode);

        }
        
    }
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev; 
    }
    private void insertAtFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
class LRUCache {    
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int size;
    int capacity;

    private void addNode(int key, int value){
        Node n = new Node(key, value);
        n.next = head.next;
        n.prev = head;
        n.next.prev = n;
        head.next = n;
        map.put(key, n);        
        size++;
    }
    private void removeNode(int key){
        if(!map.containsKey(key)) return;
        Node n = map.get(key);
        map.remove(key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.prev = null;
        n.next = null;
        size--;
    }
    private void removeLast(){
        if(tail == null || tail.prev == null) return;
        Node n = tail.prev;
        map.remove(n.key);
        tail.prev = n.prev;
        n.prev.next = tail;
        n.prev = null;
        n.next = null;
        size--;
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>(capacity);
        // printList();
    }
    
    public int get(int key) {
       if(!map.containsKey(key)) return -1;
       Node n = map.get(key);
       removeNode(key);
       addNode(key, n.value);
    //    printList();
       return n.value;       
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            removeNode(key);
        }
        addNode(key, value);
        if(size > capacity){
            removeLast();
        }
        // printList();
    }

    public void printList()
    {
        Node n = head.next;
        System.out.print("[");
        while(n.next != null){
            System.out.print(n.key + " -> " + n.value + ", ");
            n = n.next;
        }
        System.out.println("] , size : "+ size);
    }
}

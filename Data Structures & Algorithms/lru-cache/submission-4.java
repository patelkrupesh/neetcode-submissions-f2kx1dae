class LRUCache {
    int size;
    int capacity;
    Node head;
    Node tail;
    Map<Integer , Node> internalMap;
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }        
    }
    private void addNode(int key, int val){
        if(internalMap.containsKey(key)){
            System.out.println("Override alert !!!");                      
        }
        Node n = new Node(key, val);
        n.next = head.next;
        n.next.prev = n;        
        n.prev = head;
        head.next = n;
        internalMap.put(key, n);
        size++;
    }
    private void removeNode(int key){
        if(!internalMap.containsKey(key)){
            System.out.println("Not found !!!");            
            return;
        }
        Node n = internalMap.get(key);
        n.next.prev = n.prev;
        n.prev.next = n.next;
        n.next = null;
        n.prev = null;
        internalMap.remove(key);
        size--;
    }
    private void removeLast(){
        if(internalMap.isEmpty() || this.tail.prev == null){
            System.out.println("No data in cache !!!");            
            return;
        }   
        removeNode(tail.prev.key);
    }
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.internalMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!internalMap.containsKey(key)){
            return -1;    
        }
        Node n = internalMap.get(key);
        removeNode(key);
        addNode(key, n.val);
        return n.val;
    }
    
    public void put(int key, int val) {        
        if(internalMap.containsKey(key)){
            removeNode(key);       
        }
        addNode(key, val);
        if(this.size > this.capacity){
            removeLast();
        }     
    }
}

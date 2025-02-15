class LRUCache {

    class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
        
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        } else{
            if(cache.size() == capacity){
                Node node = tail.prev;
                cache.remove(node.key);
                deleteNode(node);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insertAfterHead(newNode);
        }
    }
    void insertAfterHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
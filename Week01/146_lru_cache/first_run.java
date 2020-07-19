class LRUCache {
    class DLinedNode {
        int val;
        int key;
        DLinedNode prev,next;
    }
    int size, capacity;
    DLinedNode head,tail;
    Map<Integer, DLinedNode>map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinedNode();
        tail = new DLinedNode();
        size = 0;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinedNode node = map.get(key);
        if(node == null) {
            return -1;
        } else{
            moveToHead(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        DLinedNode node = map.get(key);
        if(node != null) {
            node.val = value;
            moveToHead(node);
        } else {
            node = new DLinedNode();
            node.val = value;
            node.key = key;
            addToHead(node);
            size++;
            if(size > capacity) {
                DLinedNode tailNode = removeTail();
                size--;
                map.remove(tailNode.key);
            }
            map.put(key, node);
        }
    }

    private void moveToHead(DLinedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinedNode node) {
        node.prev = head;
        node.next=head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DLinedNode removeTail() {
        DLinedNode temp = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return temp;
    }

    private void removeNode(DLinedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
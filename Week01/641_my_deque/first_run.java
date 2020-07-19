class MyCircularDeque {
    class DlinkedNode{
        int val;
        DlinkedNode prev;
        DlinkedNode next;
    }

    DlinkedNode head, tail;
    int capacity;
    int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if (k<0) {
            throw new RuntimeException();
        }
        this.capacity = k;
        size = 0;
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size>=capacity){
            return false;
        }
        DlinkedNode node = new DlinkedNode();
        node.val = value;
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size>=capacity){
            return false;
        }
        DlinkedNode node = new DlinkedNode();
        node.val = value;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev=node;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size<=0) {
            return false;
        }
        head.next.next.prev = head;
        head.next = head.next.next;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size<=0) {
            return false;
        }
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(size<=0) {
            return -1;
        }
        return head.next.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(size<=0) {
            return -1;
        }
        return tail.prev.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size<=0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size>=capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
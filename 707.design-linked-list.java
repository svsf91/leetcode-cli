/*
 * [838] Design Linked List
 *
 * https://leetcode.com/problems/design-linked-list/description/
 *
 * algorithms
 * Easy (17.52%)
 * Total Accepted:    7.5K
 * Total Submissions: 42.8K
 * Testcase Example:  '["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]\n[[],[1],[3],[1,2],[1],[1],[1]]'
 *
 * Design your implementation of the linked list. You can choose to use the
 * singly linked list or the doubly linked list. A node in a singly linked list
 * should have two attributes: val and next. val is the value of the current
 * node, and next is a pointer/reference to the next node. If you want to use
 * the doubly linked list, you will need one more attribute prev to indicate
 * the previous node in the linked list. Assume all nodes in the linked list
 * are 0-indexed.
 * 
 * Implement these functions in your linked list class:
 * 
 * 
 * get(index) : Get the value of the index-th node in the linked list. If the
 * index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the
 * linked list. After the insertion, the new node will be the first node of the
 * linked list.
 * addAtTail(val) : Append a node of value val to the last element of the
 * linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in
 * the linked list. If index equals to the length of linked list, the node will
 * be appended to the end of linked list. If index is greater than the length,
 * the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the
 * index is valid.
 * 
 * 
 * Example:
 * 
 * 
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * 
 * 
 * Note:
 * 
 * 
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 * 
 */
class MyLinkedList {
    class DDL {
        int val;
        DDL prev;
        DDL next;
        DDL(int _val) {
            val = _val;
        }
    }
    DDL head;
    DDL tail;
    int len;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new DDL(0);
        tail = new DDL(0);
        head.next = tail;
        tail.prev = head;
        len = 0;
    }
    
    private DDL getDDL(int index) {
        if(index >= len || index < 0) {
            return null;
        }
        DDL cur = head;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.next;
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        DDL target = getDDL(index);
        return target == null ? -1 : target.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        DDL toAdd = new DDL(val);
        toAdd.next = head.next;
        head.next.prev = toAdd;
        head.next = toAdd;
        toAdd.prev = head;
        len++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        DDL toAdd = new DDL(val);
        tail.prev.next = toAdd;
        toAdd.prev = tail.prev;
        toAdd.next = tail;
        tail.prev = toAdd;
        len++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        DDL target;
        if(index == len) {
            target = tail;
        } else {
            target = getDDL(index);
        }
        if(target == null) {
            return;
        }
        DDL toAdd = new DDL(val);
        DDL prev = target.prev;
        prev.next = toAdd;
        toAdd.prev = prev;
        toAdd.next = target;
        target.prev = toAdd;
        len++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        DDL target = getDDL(index);
        if(target == null) {
            return;
        }
        target.prev.next = target.next;
        target.next.prev = target.prev;
        len--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

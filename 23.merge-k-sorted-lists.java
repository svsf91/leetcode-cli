import java.util.PriorityQueue;

/*
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (30.47%)
 * Total Accepted:    276.3K
 * Total Submissions: 906.9K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode head = null;
        ListNode pre = null;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            if (head == null) {
                head = cur;
            } else {
                pre.next = cur;
            }
            if (cur.next != null) {
                pq.offer(cur.next);
            }
            pre = cur;
            cur.next = null;
        }
        return head;
    }
}

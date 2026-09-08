/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        ListNode dummy = new ListNode(0);
        ListNode curr=dummy;
        for(ListNode list:lists){
            if(list!=null){
                minheap.offer(list);
            }
        }
        while(!minheap.isEmpty()){
            ListNode smallest=minheap.poll();
            curr.next=smallest;
            curr=curr.next;
            if(smallest.next!=null){
                minheap.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}

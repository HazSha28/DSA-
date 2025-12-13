//Leetcode Problem Link: https://leetcode.com/problems/merge-k-sorted-lists/description/
package BinaryHeap;
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
import java.util.PriorityQueue;
import java.util.ArrayList;
public class MergeMsortedLists{
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> p=new PriorityQueue<>((a,b)->a.val-b.val);
       for(ListNode head:lists){
            if(head!=null)
                p.add(head);
        }
       ListNode headAns=null;
       ListNode temp=null;
    while (!p.isEmpty()) {
            ListNode top = p.poll(); 
            if (headAns == null) {
                headAns = top;  
                temp = top;
            } else {
                temp.next = top; 
                temp = top;
            }
            if (top.next != null)
                p.add(top.next);
        }
        return headAns;
    }
}

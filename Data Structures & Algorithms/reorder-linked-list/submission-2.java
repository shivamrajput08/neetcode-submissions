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
    public void reorderList(ListNode head) {
      if(head == null || head.next == null) return;  

      // find middle of list using tortise and hare algo
      ListNode slow = head;
      ListNode fast = head;
      while(fast.next != null && fast.next.next != null){
         slow = slow.next;
         fast = fast.next.next;
      }

      //reverse second half list after middle
      ListNode preMiddle = slow ;
      ListNode preCurrent = slow.next;
      while(preCurrent.next != null){
         ListNode current = preCurrent.next;
         preCurrent.next = current.next;
         current.next = preMiddle.next;
         preMiddle.next = current;
      }

      //start reordering
      slow = head;
      fast = preMiddle.next;
      while(slow != preMiddle){
         preMiddle.next = fast.next;
         fast.next = slow.next;
         slow.next = fast;
         slow = fast.next;
         fast = preMiddle.next;
      }
    }

}

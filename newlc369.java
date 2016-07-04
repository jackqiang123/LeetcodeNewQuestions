// Given a non-negative number represented as a singly linked list of digits, plus one to the number.
//
// The digits are stored such that the most significant digit is at the head of the list.
//
// Example:
// Input:
// 1->2->3
//
// Output:
// 1->2->4
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
      return reverse(plus(reverse(head)));
    }
    private ListNode plus(ListNode head){
      int carry = 1;
      ListNode res = head;
      while(head != null){
        int sum = (head.val + carry)%10;
        carry = (head.val + carry)/10;
        head.val = sum;
        if (head.next == null){
          if (carry == 0) return res;
          head.next = new ListNode(carry);
          return res;
        }
        head = head.next;
      }
      return res;
      }

    private ListNode reverse(ListNode head){
      ListNode dummy = new ListNode(0);
      ListNode res = dummy;
      while(head != null){
        ListNode t = head.next;
        head.next = dummy.next;
        dummy.next = head;
        head = t;
      }
      return res.next;
    }
}

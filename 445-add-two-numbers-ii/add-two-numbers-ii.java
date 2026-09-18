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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead =reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next=null;
        return newHead;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null )return l2;
        if(l2 == null)return l1;
        ListNode dummy = new ListNode(-1);
        ListNode ans=dummy;

        l1=reverseList(l1);
        l2=reverseList(l2);

        ListNode t1=l1;
        ListNode t2=l2;

        int carry=0;

        while(t1 != null || t2 != null || carry != 0){
            if(t1 != null){
                carry += t1.val;
                t1=t1.next;
            }
            if(t2 != null){
                carry += t2.val;
                t2=t2.next;
            }
            ListNode nn= new ListNode(carry%10);
            ans.next=nn;
            ans=nn;
            carry = carry/10;
        }
        return reverseList(dummy.next);
    }
}
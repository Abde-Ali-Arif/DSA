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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)return head;
        ListNode smaller=new ListNode(-1000);
        ListNode s=smaller;
        ListNode greater=new ListNode(-1000);
        ListNode g=greater;
        ListNode temp=head;

        while(temp != null){
            if(temp.val < x) {
                s.next=temp;
                s=temp;
            }else{
                g.next = temp;
                g=temp;
            }
            temp =temp.next;
        }
        g.next=null;
        if(s.val == -1000)return greater.next;
        s.next=greater.next;
        return smaller.next;
    }
}
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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null)return head;
        ListNode temp=head;
        int size=0;
        int val=0;    //hash the value of node k from starting
        while(temp != null){
            size++;
            if(size == k)val=temp.val;
            temp =temp.next;
        }
        int ind=size-k+1;
        temp=head;
        for(int i=1;i<ind;i++){
            temp=temp.next;
        }
        int nval=temp.val;
        temp.val=val;
        temp=head;
        for(int i=1;i<k;i++){
            temp=temp.next;
        }
        temp.val=nval;
        return head;
    }
}
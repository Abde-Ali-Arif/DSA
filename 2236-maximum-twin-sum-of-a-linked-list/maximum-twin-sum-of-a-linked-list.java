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
    public int pairSum(ListNode head) {
        if(head == null)return 0;

        Stack<Integer> st= new Stack<>();
        ListNode fast=head;
        ListNode slow=head;

        // half traversal done
        while(fast != null && fast.next != null){
            st.push(slow.val);
            slow = slow.next;
            fast=fast.next.next;
        }

        // now try to find answer
        int sum=Integer.MIN_VALUE;
        while(slow != null){
            sum=Math.max(sum,st.pop()+slow.val);
            slow=slow.next;
        }
        return sum;
    }
}
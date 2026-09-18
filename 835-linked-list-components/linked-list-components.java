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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> hash= new HashSet<>();
        for(int it:nums)hash.add(it);

        int count=0;
        boolean flag=false;
        ListNode temp = head;
        while(temp != null){
            if(hash.contains(temp.val)){
                if(!flag){
                    flag = true;
                    count++;
                }
            }else{
                flag = false;

            }
            temp = temp.next;
        }
        return count;
    }
}
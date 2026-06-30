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
    class Pair{
        int val;
        int row;
        Pair(int v,int r){
            val= v;
            row=r;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        ListNode head=null;
        ListNode temp=null;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return a.val-b.val;});
        for(int i=0;i<n;i++){
            if(lists[i]!=null){
                pq.offer(new Pair(lists[i].val,i));
                lists[i]=lists[i].next;
            }
        }
        
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int row=p.row;
            ListNode nn=new ListNode(p.val);
            if(temp == null){
                head=nn;
                temp=nn;
            }else{
                temp.next=nn;
                temp=temp.next;
            }
            if(lists[row]!=null){
                pq.offer(new Pair(lists[row].val,row));
                lists[row]=lists[row].next;
            }
        }
        return head;
    }
}
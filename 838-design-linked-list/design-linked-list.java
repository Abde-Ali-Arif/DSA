
class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
        ListNode(){
            this.val=0;
            this.next=null;
        }
    }


    ListNode head;
    ListNode tail;
    int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size=0;
    }
    
    public int get(int index) {
        if(index >= size)return -1;
        ListNode temp=head;
        for(int i=1;i<=index;i++){
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        ListNode nn= new ListNode(val);
        size++;
        nn.next=head;
        head=nn;
        if(tail == null)tail=nn;
    }
    
    public void addAtTail(int val) {
        ListNode nn= new ListNode(val);
        size++;
        if(tail != null)tail.next=nn;
        else head=nn;
        tail=nn;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size)return;
        if(index == size){
            addAtTail(val);
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        ListNode nn=new ListNode(val);
        size++;
        ListNode temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        nn.next=temp.next;
        temp.next=nn;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size)return;
        size--;
        if(index == 0){
            if(tail == head){ // if single node
                tail=null;
            }
            head=head.next;
            return;
        }
        ListNode temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        if(tail == temp.next)tail=temp;
        temp.next=temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
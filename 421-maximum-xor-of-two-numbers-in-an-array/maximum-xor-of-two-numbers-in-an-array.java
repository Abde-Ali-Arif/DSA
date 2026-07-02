class Node {
    Node[] links;
    Node(){
        links=new Node[2];
    }
    
    void set(int bit){
        links[bit]=new Node();
    }
    
    boolean containsKey(int bit){
        return links[bit] != null;
    }
    
    Node get(int bit){
        return links[bit];
    }   
}

class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }

    public void insert(int num) {
        Node temp=root;
        for(int i=31;i>=0;i--){
            int bit=(num >> i) & 1;
            if(!temp.containsKey(bit)){
                temp.set(bit);
            }
            temp=temp.get(bit);
        }
    }

    public int getMax(int num) {
        Node temp=root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit=(num >> i) & 1;
            if(temp.containsKey(1-bit)){
                max=(1 << i) | max;
                temp=temp.get(1-bit);
            }else{
                temp=temp.get(bit);
            }
        }
        return max;
    }

}
class Solution {

    // O(n^2) will give TLE
    // public int findMaximumXOR(int[] nums) {
    //     int max=Integer.MIN_VALUE;

    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i;j<nums.length;j++){
    //             int xor=nums[i]^nums[j];
    //             max=Math.max(max,xor);
    //         }
    //     }
    //     return max;
    // }

    public int findMaximumXOR(int[] nums) {

        Trie trie= new Trie();
        int n=nums.length;

        for(int i=0;i<n;i++){
            trie.insert(nums[i]);
        }

        int maxi=0;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,trie.getMax(nums[i]));
        }
        return maxi;
    }
}
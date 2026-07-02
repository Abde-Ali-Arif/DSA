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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;
        Arrays.sort(nums);
        int[][] OQ=new int[m][3];
        for(int i=0;i<m;i++){
            OQ[i][0]=queries[i][0]; 
            OQ[i][1]=queries[i][1];
            OQ[i][2]=i; // index
        }
        Arrays.sort(OQ,(a,b)->Integer.compare(a[1],b[1]));
        int[] ans= new int[m];
        Arrays.fill(ans,-1);
        Trie trie= new Trie();
        int ind=0;


        for(int i=0;i<m;i++){
            while(ind < n && nums[ind] <= OQ[i][1]){
                trie.insert(nums[ind]);
                ind++;
            }
            int queryInd=OQ[i][2];
            if(ind != 0)ans[queryInd]=trie.getMax(OQ[i][0]);
        }
        return ans;
    }
}
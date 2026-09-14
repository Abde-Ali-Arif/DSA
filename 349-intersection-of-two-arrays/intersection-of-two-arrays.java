class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hash=new HashSet<>();
        HashSet<Integer> ans=new HashSet<>();
        for(int it : nums1){
            hash.add(it);
        }
        for(int it:nums2){
            if(hash.contains(it))ans.add(it);
        }
        int[] res= new int[ans.size()];
        int i=0;
        for(int it:ans){
            res[i]=it;
            i++;
        }
        return res;
    }
}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> hash= new HashMap<>();

        for(int it:nums1)hash.put(it,hash.getOrDefault(it,0)+1);

        for(int it:nums2){
            if(hash.containsKey(it)){
                ans.add(it);
                int freq = hash.get(it);
                if(freq > 1){
                    hash.put(it,freq-1);
                }else hash.remove(it);
            }
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}
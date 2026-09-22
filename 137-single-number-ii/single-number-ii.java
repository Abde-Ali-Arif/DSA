class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hash= new HashMap<>();
        int n= nums.length;

        for(int i:nums){
            hash.put(i,hash.getOrDefault(i,0)+1);
        }

        for(int i:hash.keySet()){
            if(hash.get(i) == 1)return i;
        }
        return -1;
    }
}
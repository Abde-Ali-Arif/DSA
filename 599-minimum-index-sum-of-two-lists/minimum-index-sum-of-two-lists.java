class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map =new HashMap<>();
        HashSet<String> ans = new HashSet<>();
        int len=Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }

        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int j=map.get(list2[i]);
                if(i+j == len)ans.add(list2[i]);
                else if (i+j < len){
                    ans.clear();
                    len=i+j;
                    ans.add(list2[i]);
                }
            }
        }
        String[] res =new String[ans.size()];
        int i=0;
        for(String s:ans){
            res[i]=s;
            i++;
        }
        return res;
    }
}
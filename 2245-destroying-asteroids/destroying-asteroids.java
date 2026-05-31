class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long curr_mass= mass;
        for(int it:asteroids){
            if(curr_mass >= it){
                curr_mass += it;
            }else return false;
        }
        return true;
    }
}
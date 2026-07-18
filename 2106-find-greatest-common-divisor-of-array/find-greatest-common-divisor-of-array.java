import java.math.BigInteger;
class Solution {
    public int findGCD(int[] nums) {
        int small=Integer.MAX_VALUE;
        int large=Integer.MIN_VALUE;
        for(int it:nums){
            small=Math.min(small,it);
            large=Math.max(large,it);
        }
        BigInteger b1 = BigInteger.valueOf(small);
        BigInteger b2 = BigInteger.valueOf(large);
        return b1.gcd(b2).intValue();
    }
}
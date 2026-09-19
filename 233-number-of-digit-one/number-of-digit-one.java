public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int count = 0;
        // Use long for factor to prevent potential integer overflow when multiplying by 10
        long factor = 1; 
        
        while (factor <= n) {
            long higher = n / (factor * 10);
            long current = (n / factor) % 10;
            long lower = n % factor;
            
            // 1. Count '1's contributed by the fully completed cycles of higher digits
            count += higher * factor;
            
            // 2. Count '1's contributed by the current digit position based on its value
            if (current == 1) {
                count += lower + 1;
            } else if (current > 1) {
                count += factor;
            }
            
            // Move to the next digit position (tens, hundreds, etc.)
            factor *= 10;
        }
        return count;
    }
}

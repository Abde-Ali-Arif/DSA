import java.util.Arrays;

public class Solution {
    public int minimumPushes(String word) {
        // Step 1: Count the frequency of each character
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Step 2: Sort frequencies in ascending order
        Arrays.sort(freq);
        
        int totalPushes = 0;
        
        // Step 3: Calculate pushes starting from the highest frequency
        // Since Arrays.sort sorts in ascending order, we iterate backwards
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                break; // No more characters left
            }
            
            // Map the current index to its placement multiplier (1, 2, 3, or 4)
            int rank = 25 - i;
            int multiplier = (rank / 8) + 1;
            
            totalPushes += freq[i] * multiplier;
        }
        
        return totalPushes;
    }
}

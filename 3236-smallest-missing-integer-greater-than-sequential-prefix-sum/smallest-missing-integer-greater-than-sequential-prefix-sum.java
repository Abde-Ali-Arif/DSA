class Solution {
    public int missingInteger(int[] nums) {
        // Find the longest sequential prefix
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Put all elements into a set for O(1) average lookup
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Find the smallest missing integer >= sum
        int x = sum;

        while (set.contains(x)) {
            x++;
        }

        return x;
    }
}
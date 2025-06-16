public class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int maxLength = 0;
        int zerosCount = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zerosCount++;
            }
            while (zerosCount > k) {
                if (nums[l] == 0) {
                    zerosCount--;
                }
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}

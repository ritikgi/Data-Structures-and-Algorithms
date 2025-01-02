class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
        for (int num : nums){
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;   
    }
}
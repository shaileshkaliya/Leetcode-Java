class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int i:nums){
            maxOr = maxOr|i;
        }
        Integer[][] dp = new Integer[nums.length][maxOr+1];
        return helper(nums, 0, maxOr, 0, dp);
    }
    private int helper(int[] nums, int idx, int max, int or, Integer[][] dp){
        if(idx == nums.length){
            return max==or ? 1:0;
        }
        if(dp[idx][or] != null){
            return dp[idx][or];
        }
        int take = helper(nums, idx+1, max, (or|nums[idx]), dp);
        int skip = helper(nums, idx+1, max, or, dp);
        return dp[idx][or] = take+skip;
    }
}
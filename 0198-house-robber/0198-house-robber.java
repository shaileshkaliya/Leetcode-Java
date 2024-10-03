class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            for(int robbed=0;robbed<=1;robbed++){
                int take=0, skip=0;
                if(robbed==1){
                    skip = dp[i+1][0];
                }else{
                    take = nums[i]+dp[i+1][1];
                    skip = dp[i+1][0];
                }
                dp[i][robbed] = Math.max(take, skip);
            }
        }
        return dp[0][0];
    }
}
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0]=1;
        int i=0,j=0,k=0;
        for(int a=1;a<n;a++){
            int i2 = 2*(dp[i]);
            int j3 = 3*(dp[j]);
            int k5 = 5*(dp[k]);
            dp[a] = Math.min(i2, Math.min(j3, k5));
            if(dp[a]==i2) i++;
            if(dp[a]==j3) j++;
            if(dp[a]==k5) k++;
        }
        return dp[n-1];
    }
}
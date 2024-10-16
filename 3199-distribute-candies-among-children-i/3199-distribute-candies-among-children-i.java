class Solution {
    public int distributeCandies(int n, int limit) {
        int[][] dp = new int[n+1][4];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return helper(n, limit, 0, dp);
    }

    private int helper(int n, int limit, int size, int[][] dp){
        if(size==3){
            if(n==0) return 1;
            else return 0;
        }
        if(dp[n][size]!=-1) return dp[n][size];
        int ans=0;
        for(int i=0;i<=limit;i++){
            if(n>=i){
                size+=1;
                ans += helper(n-i, limit, size, dp);
                size-=1;
            }
        }
        return dp[n][size]=ans;
    }
}
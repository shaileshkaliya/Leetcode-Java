class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int j=1;j<=n;j++){
            dp[0][j] = Integer.MAX_VALUE;
        }
        dp[1][1] = grid[0][0];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 && j==1) continue;
                dp[i][j] = grid[i-1][j-1]+Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
    private int helper(int[][] grid, int i, int j, int[][] dp){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right=Integer.MAX_VALUE, down=Integer.MAX_VALUE;
        if(j+1<grid[0].length){
            down = helper(grid, i, j+1, dp);
        }
        if(i+1<grid.length){
            right = helper(grid, i+1, j, dp);
        }
        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
}
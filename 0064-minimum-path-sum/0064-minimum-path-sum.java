class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return helper(grid, 0, 0, dp);
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
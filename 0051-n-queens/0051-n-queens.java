class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] grid = new int[n][n];
        solve(n, grid, ans, 0);
        return ans;
    }

    private void solve(int n, int[][] grid, List<List<String>> ans, int col){
        if(col == n){
            addSolutionToAns(grid, ans);
            return ;
        }

        for(int row=0;row<n;row++){
            if(isSafe(grid, row, col)){
                grid[row][col] = 1;
                solve(n, grid, ans, col+1);
                grid[row][col] = 0;
            }
        }
    }

    private void addSolutionToAns(int[][] grid, List<List<String>> ans){
        List<String> temp = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<grid.length;j++){
                char ch = grid[i][j]==1 ? 'Q' : '.';
                sb.append(ch);
            }
            temp.add(sb.toString());
        }
        ans.add(temp);
    }

    private boolean isSafe(int[][] grid, int row, int col){
        int n=grid.length;
        for(int i=col-1;i>=0;i--){
            if(grid[row][i]==1) return false;
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--) {
            if(grid[i][j] == 1) return false;
        }
        for(int i=row+1, j=col-1; i<n && j>=0; i++,j--) {
            if(grid[i][j] == 1) return false;
        }
        return true;
    }
}
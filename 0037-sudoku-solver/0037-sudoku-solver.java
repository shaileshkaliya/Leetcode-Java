class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    private boolean helper(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char num='1'; num<='9'; num++){
                        if(isSafe(board, row, col, num)){
                            board[row][col] = num;
                            if(helper(board)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val || board[i][col] == val) {
                return false;
            }
        }
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
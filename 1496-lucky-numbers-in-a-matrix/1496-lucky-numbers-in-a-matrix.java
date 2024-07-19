class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            int minCol=-1, min=Integer.MAX_VALUE;
            for(int j=0;j<matrix[0].length;j++){
                if(min>matrix[i][j]){
                    minCol=j;
                    min=matrix[i][j];
                }
            }
            if(isLucky(matrix, minCol, min)){
                ans.add(matrix[i][minCol]);
            }
        }
        return ans;
    }
    private boolean isLucky(int[][] matrix, int col, int min){
        for(int i=0;i<matrix.length;i++){
            if(min<matrix[i][col]) return false;
        }
        return true;
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] hor = new boolean[m];
        boolean[] ver = new boolean[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    hor[i]=true;
                    ver[j]=true;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(hor[i] || ver[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
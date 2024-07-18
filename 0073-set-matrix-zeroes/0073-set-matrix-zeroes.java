class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> hor = new HashSet<>();
        Set<Integer> ver = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    hor.add(i);
                    ver.add(j);
                }
            }
        }

        for(int j:hor){
            for(int i=0;i<matrix[0].length;i++){
                matrix[j][i]=0;
            }
        }
        for(int j:ver){
            for(int i=0;i<matrix.length;i++){
                matrix[i][j]=0;
            }
        }
    }
}
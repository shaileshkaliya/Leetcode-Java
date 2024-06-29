class Solution {
    Integer dp[][];
    public int solve(String s1,String s2,int i,int j){
        if(i>=s1.length() && j>=s2.length()){
            return 0;
        }
        if(i>=s1.length()){
            return s2.length()-j;
            //append these characeters
        }
        if(j>=s2.length()){
            return s1.length()-i;
            //extra chars should delete
        }
        if(dp[i][j]!=null)return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=solve(s1,s2,i+1,j+1);
        }
        else{
            int insert=1+solve(s1,s2,i,j+1);
            int delete=1+solve(s1,s2,i+1,j);
            int replace=1+solve(s1,s2,i+1,j+1);
           return dp[i][j]=Math.min(insert,Math.min(delete,replace));
        }
    }
    public int minDistance(String word1, String word2) {
        dp=new Integer[word1.length()][word2.length()];
        return solve(word1,word2,0,0);
    }
}
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0, ans=0;
        for(int i=0;i<k;i++){
            sum += cardPoints[i];
        }
        ans = sum;
        for(int left=k-1, right=cardPoints.length-1; left>=0; left--, right--){
            sum -= cardPoints[left];
            sum += cardPoints[right];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

// 1 3 6 10 15 21 22 
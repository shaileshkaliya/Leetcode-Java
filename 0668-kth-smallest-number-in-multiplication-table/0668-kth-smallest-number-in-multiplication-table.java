class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low=1, high=m*n;
        while(low<=high){
            int mid = (low+high)/2;

            if(helper(m, n, mid)<k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private int helper(int m, int n, int mid){
        int cnt=0;
        for(int i=1;i<=m;i++){
            cnt += Math.min(mid/i, n);
        }
        return cnt;
    }
}
class Solution {
    int[] sum;
    public Solution(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for(int i=1;i<w.length;i++){
            sum[i] = sum[i-1]+w[i];
        }
    }
    
    public int pickIndex() {
        int n = (int) (Math.random() * sum[sum.length-1]) + 1;
        int l=0, r=sum.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(sum[mid]==n){
                return mid;
            }
            else if(sum[mid]>n){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans=0;
        int[] rem = new int[k+1];
        rem[0]=1;
        int sum=0;
        for(int i:nums){
            sum+=i;
            int mod = sum%k;
            if(mod<0) mod+=k;
            ans += rem[mod];
            rem[mod]++;
        }
        return ans;
    }
}
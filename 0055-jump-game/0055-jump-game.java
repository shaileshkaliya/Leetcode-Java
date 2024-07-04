class Solution {
    public boolean canJump(int[] nums) {
        int ans=0;
        for(int i:nums){
            if(ans<0) return false;
            if(i>ans){
                ans = i;
            }
            ans -= 1;
        }
        return true;
    }
}
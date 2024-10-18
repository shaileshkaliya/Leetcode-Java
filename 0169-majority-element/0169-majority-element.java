class Solution {
    public int majorityElement(int[] nums) {
        int max=0,majority=0;
        for(int i:nums){
            if(max==0) majority = i;
            max += majority==i ? 1:-1 ;
        }
        return majority;
    }
}
class Solution {
    public int maxArea(int[] height) {
       int water=0, left=0, right=height.length-1;
       while(left<=right){
            int curr = (right-left)*Math.min(height[left], height[right]);
            water = Math.max(water, curr);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
       }
       return water; 
    }
}
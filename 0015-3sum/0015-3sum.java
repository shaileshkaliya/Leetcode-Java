class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            List<Integer> ls = new ArrayList<>();
            int left = i+1, right=nums.length-1;
            while(left<right){
                int curr = nums[i]+nums[left]+nums[right];
                // System.out.println(nums[i]+" "+nums[left]+" "+nums[right]);
                if(curr==0){
                    ls.add(nums[i]);
                    ls.add(nums[left]);
                    ls.add(nums[right]);
                    ans.add(new ArrayList<>(ls));
                    ls.clear();
                    left++;
                    while(left<nums.length && left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }
                if(curr<0){
                    left++;
                }else if(curr>0){
                    right--;
                }
            }
        }
        return ans;
    }
}
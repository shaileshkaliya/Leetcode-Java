class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[nums.length+1];
        for(int i:nums) arr[i]++;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>1){
                ans.add(i);
            }
        }
        return ans;
    }
}
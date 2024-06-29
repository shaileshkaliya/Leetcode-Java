class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteRec(nums, 0, result);
        return result;
    }
    private void permuteRec(int[] nums, int currentIndex, List<List<Integer>> result) {
        if (currentIndex == nums.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int index = currentIndex; index < nums.length; index++) {
            if(!set.contains(nums[index])){
                set.add(nums[index]);
                swap(nums, currentIndex, index);
                permuteRec(nums, currentIndex + 1, result);
                swap(nums, currentIndex, index);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
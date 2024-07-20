class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;  // Early return for invalid input
        }

        Arrays.sort(nums);  // Sort the array

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // Skip duplicates for the first number

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  // Skip duplicates for the second number

                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for the third number
                        while (left < right && nums[left] == nums[left + 1]) left++;

                        // Skip duplicates for the fourth number
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return ans;
    }
}
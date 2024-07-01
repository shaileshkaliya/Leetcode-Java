class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m=nums2.length;
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(nums2[i], i);
        }
        for(int i=0;i<n;i++){
            int idx = map.get(nums1[i]);
            int flag=0;
            for(int j=idx+1;j<m;j++){
                if(nums2[j]>nums2[idx]){
                    ans[i] = nums2[j];
                    flag=1;
                    break;
                }
            }
            if(flag==0)ans[i]=-1;
        }
        return ans;
    }
}
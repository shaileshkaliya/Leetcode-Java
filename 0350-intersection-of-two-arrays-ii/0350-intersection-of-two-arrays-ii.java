class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        int[] ans = new int[1001];
        int k=0;
        for(int i:nums1){
            arr[i]++;
        }
        for(int i:nums2){
            if(arr[i]>0){
                ans[k++]=i;
                arr[i]--;
            }
        }
        return Arrays.copyOfRange(ans, 0, k);
    }
}
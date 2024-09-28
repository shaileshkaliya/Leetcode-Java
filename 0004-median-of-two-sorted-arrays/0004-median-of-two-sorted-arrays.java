class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> ls = new ArrayList<>();
        int m = nums1.length, n=nums2.length, i=0, j=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                ls.add(nums1[i]);
                i++;
            }else{
                ls.add(nums2[j]);
                j++;
            }
        }
        while(i<m){
            ls.add(nums1[i++]);
        }
        while(j<n){
            ls.add(nums2[j++]);
        }
        if(ls.size()%2 != 0){
            return (double)ls.get(ls.size()/2);
        }
        return (double)(ls.get(ls.size()/2-1)+ls.get(ls.size()/2))/2;
    }
}
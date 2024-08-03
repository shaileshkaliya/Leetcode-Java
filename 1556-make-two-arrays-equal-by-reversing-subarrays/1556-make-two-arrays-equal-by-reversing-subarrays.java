class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cnt = new int[1001];
        for(int i : target) cnt[i]++;
        for(int i:arr){
            if(cnt[i]==0) return false;
            cnt[i]--;
        }
        return true;
    }
}
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt=0;
        for(int i:arr){
            if(i%2==1){
                if(cnt<2) cnt++;
                else return true;
            }else{
                cnt=0;
            }
        }
        return false;
    }
}
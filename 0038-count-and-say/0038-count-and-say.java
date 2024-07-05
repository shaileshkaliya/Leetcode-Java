class Solution {
    public String countAndSay(int n) {
            if(n == 1){
            return "1";
        }
        String str = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        for(int i=0;i<str.length();i++){
            cnt++;
            if(i==str.length()-1 || str.charAt(i)!=str.charAt(i+1)){
                sb.append(cnt).append(str.charAt(i));
                cnt=0;
            }
        }
        return sb.toString();
    }
}
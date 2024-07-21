class Solution {
    public int maxOperations(String s) {
        // char[] arr = s.toCharArray();
        int ans=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                sb.append('1');
            }else if(i>0 && s.charAt(i)=='0' && s.charAt(i-1)=='1'){
                sb.append('0');
            }
        }
        int temp=0;
        // System.out.println(sb);
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1'){
                temp++;
            }else{
                ans += temp;
            }
        }
        return ans;
    }
}
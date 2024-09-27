class Solution {
    public String fractionToDecimal(int num, int deno) {
        long numerator = (long)num;
        long denominator = (long)deno;
        boolean flag = false;
        if((numerator<=0 && denominator<=0) || (numerator>=0 && denominator>=0)){
            flag = true;
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        StringBuilder ans = new StringBuilder();
        long quotient = numerator/denominator, rem = numerator%denominator;
        ans.append(quotient);
        if(!flag){
            ans.insert(0,"-");
        }
        if(rem == 0){
            return ans.toString();
        }else{
            ans.append('.');
            HashMap<Long, Integer> map = new HashMap<>();
            while(rem != 0){
                if(map.containsKey(rem)){
                    ans.insert(map.get(rem), "(");
                    ans.append(')');
                    break;
                }else{
                    map.put(rem, ans.length());
                    rem *= 10;
                    quotient = rem/denominator;
                    ans.append(quotient);
                    rem = rem%denominator;
                }
            }
        }
        return ans.toString();
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0], sell=0, ans=0;
        for(int i=1; i<prices.length-1; i++){
            if(prices[i]<buy){
                buy = prices[i];
                sell = prices[i];
            }else if(prices[i]>=sell) {
                sell = prices[i];
                ans = Math.max(ans, sell-buy);
            }
        }
        sell = prices[prices.length-1];
        return Math.max(ans, sell-buy);
    }
}
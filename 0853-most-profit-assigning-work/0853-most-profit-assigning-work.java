class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int result = 0;
        int max = Integer.MIN_VALUE;
        int length = profit.length;
        for(int i = 0; i < length; i++) {
            max = Math.max(max, difficulty[i]);
        }
        int[] maxProfits = new int[max + 1];

        for(int i = 0; i < length; i++) {
            maxProfits[difficulty[i]] = Math.max(maxProfits[difficulty[i]], profit[i]);
        }
        int runningMax = Integer.MIN_VALUE;
        for(int i = 1; i <= max; i++) {
            runningMax = Math.max(runningMax, maxProfits[i]);
            maxProfits[i] = runningMax;
        }
        for(int d : worker) {
            if(d > max) {
             result += maxProfits[max];
            } else {
                result += maxProfits[d];
            }
           
        }

        return result;

    }
}
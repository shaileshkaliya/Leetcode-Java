class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++) arr[i][0] = i;
        for(int[] road:roads){
            arr[road[0]][1]++;
            arr[road[1]][1]++;
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[]a1, int[] a2){
                return Integer.compare(a2[1], a1[1]);
            }
        });
        int[] val = new int[n];
        int t = n;
        for(int i=0;i<n;i++){
            val[arr[i][0]] = t;
            t--;
        }
        long ans=0;
        for(int[] road:roads){
            long temp = val[road[0]]+val[road[1]];
            ans+=temp;
        }
        return ans;
    }
}
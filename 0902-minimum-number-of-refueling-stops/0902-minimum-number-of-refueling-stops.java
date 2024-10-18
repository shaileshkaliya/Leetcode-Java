class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel > target) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int stops=0, currDist=startFuel, idx=0, n=stations.length;
        while(currDist<target){
            while(idx<n && currDist >= stations[idx][0]){
                pq.add(stations[idx][1]);
                idx++;
            }
            if(pq.isEmpty()){
                return -1;
            }
            stops++;
            currDist += pq.poll();
        }
        return stops;
    }
}
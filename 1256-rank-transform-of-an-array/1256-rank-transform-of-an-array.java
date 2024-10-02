class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:arr) pq.add(i);
        Map<Integer, Integer> map = new HashMap<>();
        int last  = -1, k=1;
        while(!pq.isEmpty()){
            int p = pq.poll();
            if(last != p){
                map.put(p, k);
                k++;
                last = p;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
class Solution {
    class Pair{
        int height;
        String name;
        Pair(int height, String name){
            this.height = height;
            this.name = name;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        String[] ans = new String[names.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p2.height-p1.height;
            }
        });
        for(int i=0;i<names.length;i++){
            pq.add(new Pair(heights[i], names[i]));
        }
        int k=0;
        while(!pq.isEmpty()){
            ans[k++] = pq.poll().name;
        }
        return ans;
    }
}
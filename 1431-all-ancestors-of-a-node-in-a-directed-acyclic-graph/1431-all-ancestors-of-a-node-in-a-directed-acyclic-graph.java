class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        ArrayList<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            ans.add(new ArrayList<>());
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
        }
        for(int i=0;i<n;i++){
            helper(graph, ans, i, i, new boolean[n]);
        }
        for(int i=0;i<n;i++){
            Collections.sort(ans.get(i));
        }
        return ans;
    }
    private void helper(ArrayList<Integer>[] graph, List<List<Integer>> ans, int par, int curr, boolean[] vis){
        vis[curr] = true;
        for (int dest : graph[curr]) {
            if (!vis[dest]) {
                ans.get(dest).add(par);
                helper(graph, ans, par, dest, vis);
            }
        }

    }
}
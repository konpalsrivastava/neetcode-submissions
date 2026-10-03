class Solution {
    public void dfs(int node, List<List<Integer>> adj,boolean[] vis,int n){
        vis[node]=true;
        for(int neighbour: adj.get(node)){
            if(!vis[neighbour]){
                dfs(neighbour,adj,vis,n);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
               count++;
               dfs(i,adj,vis,n);
        }
        }
        return count;
    }
}

class Solution {
    private void dfs(List<List<Integer>> adj , int node , boolean[] vis){
        if(vis[node]){
            return ;
        }
        vis[node]=true;
        for(int neighbor : adj.get(node)){
            dfs(adj,neighbor,vis);
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        dfs(adj,0,vis);
        for(boolean v:vis){
            if(!v){
                return false;
            }
        }
        return true;
    }
}

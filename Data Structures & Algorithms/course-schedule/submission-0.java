class Solution {
    //this dfs is finding cycle
    public boolean dfs(int node,List<List<Integer>> adj,boolean[] vis,boolean[] pathvis){
        vis[node] = true;
        pathvis[node] = true;
        for(int neighbour: adj.get(node)){

            if(!vis[neighbour]){
                if(dfs(neighbour,adj,vis,pathvis)){
                    return true;
                }
            }
            else if(pathvis[neighbour]) return true;
        }
        pathvis[node]=false; //backtrack
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }
        boolean[] vis=new boolean[numCourses];
        boolean[] pathvis=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,pathvis)) return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean dfs(int node,int[] vis,int[] pathvis,Stack<Integer> st,List<List<Integer>> adj){
        vis[node]=1;
        pathvis[node]=1;
        for(int neighbour: adj.get(node)){
            if(vis[neighbour]==0){
                if(dfs(neighbour,vis,pathvis,st,adj)){
                    return true;
                }
            }
            else if(pathvis[neighbour]==1){
                return true;
            }
        }
        pathvis[node]=0;
        st.push(node);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            int u=edge[0];
            int v=edge[1];

            adj.get(v).add(u);
        }
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[numCourses];
        int[] pathvis = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfs(i,vis,pathvis,st,adj)){
                    return new int[0];
                }
            }
        }
        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ans[i]=st.pop();
        }
        return ans;

    }
}

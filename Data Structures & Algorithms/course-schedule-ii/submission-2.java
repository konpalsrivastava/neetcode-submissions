class Solution {
    public boolean dfs(int node,boolean[] vis,boolean[] pathvis,Stack<Integer> st,List<List<Integer>> adj){
        vis[node]=true;
        pathvis[node]=true;
        for(int neighbour: adj.get(node)){
            if(!vis[neighbour]){
                if(dfs(neighbour,vis,pathvis,st,adj)){
                    return true;
                }
            }
            else if(pathvis[neighbour]){
                return true;
            }
        }
        pathvis[node]=false;
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
        boolean[] vis = new boolean[numCourses];
        boolean[] pathvis = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
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

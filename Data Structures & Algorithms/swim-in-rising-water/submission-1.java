class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int ans=0;
        pq.offer(new int[]{grid[0][0],0,0});
        boolean[][] visited = new boolean[n][n];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int h=curr[0];
            int u=curr[1];
            int v=curr[2];
            if(visited[u][v]){
                continue;
            }
            visited[u][v]=true;
            ans=Math.max(ans,h);
            if(u==n-1 && v==n-1){
                return ans;
            }
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
            for(int k=0;k<4;k++){
                int rn = u+dr[k];
                int cn = v+dc[k];
                if(rn>=0 && rn<n && cn>=0 && cn<n && !visited[rn][cn]){
                    pq.offer(new int[]{grid[rn][cn],rn,cn});
                }
            }
        }
        return -1;
    }
}
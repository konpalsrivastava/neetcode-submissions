class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh =0;
        int time =0;
        Queue<int[]> q =new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] nodes = q.poll();
                int r = nodes[0];
                int c = nodes[1];
                int[] dr = {-1,1,0,0};
                int[] dc = {0,0,-1,1};
                for(int k=0;k<4;k++){
                    int rn = r + dr[k];
                    int cn = c + dc[k];
                    if(rn>=0 &&  rn<grid.length && cn>=0 && cn<grid[0].length && grid[rn][cn]==1){
                        q.offer(new int[]{rn,cn});
                        grid[rn][cn]=2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh>0){
            return -1;
        }
        return time;
    }
}

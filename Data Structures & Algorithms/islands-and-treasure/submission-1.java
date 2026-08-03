class Solution {
    int INF =Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!q.isEmpty()){
            int lev=q.size();
            for(int i=0;i<lev;i++){
                int[] node=q.poll();
                int r=node[0];
                int c=node[1];
                for(int k=0;k<4;k++){
                    int rn = r+dr[k];
                    int cn = c+dc[k];
                    if(rn>=0 && rn<grid.length && cn>=0 && cn<grid[0].length && grid[rn][cn]==INF){
                        q.offer(new int[]{rn,cn});
                        grid[rn][cn]=grid[r][c]+1;
                    }
                }
            }
        }
    }
}

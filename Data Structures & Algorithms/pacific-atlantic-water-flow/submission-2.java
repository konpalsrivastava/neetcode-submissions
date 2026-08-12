class Solution {
    public void dfs(int[][] heights,int r,int c,boolean[][] vis){
        vis[r][c]=true;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int k=0;k<4;k++){
            int rn=r+dr[k];
            int cn=c+dc[k];
            if(rn>=0 && rn<heights.length && cn>=0 && cn<heights[0].length && !vis[rn][cn] && heights[rn][cn]>=heights[r][c]){
                dfs(heights,rn,cn,vis);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int j=0;j<n;j++){
            dfs(heights,0,j,pacific);
        }
        for(int i=0;i<m;i++){
            dfs(heights,i,0,pacific);
        }
        for(int j=0;j<n;j++){
            dfs(heights,m-1,j,atlantic);
        }
        for(int i=0;i<m;i++){
            dfs(heights,i,n-1,atlantic);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}

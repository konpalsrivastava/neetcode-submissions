class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] mincost = new int[n];
        for(int i=0;i<n;i++){
            mincost[i]=Integer.MAX_VALUE;
        }
        mincost[0]=0;
        int total=0;
        for(int i=0;i<n;i++){
            int curr=-1;
            for(int j=0;j<n;j++){
                if(!visited[j] && (curr==-1||mincost[j]<mincost[curr])){
                    curr=j;
                }
            }
            visited[curr]=true;
            total+=mincost[curr];
            for(int rem=0;rem<n;rem++){
                if(!visited[rem]){
                int dist = Math.abs(points[curr][0]-points[rem][0]) + Math.abs(points[curr][1]-points[rem][1]);
                mincost[rem]=Math.min(dist,mincost[rem]);
            }
            }
        }
        return total;
    }
}

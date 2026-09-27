class Solution {
    class pair{
        int dist;
        int node;
        pair(int dist,int node){
            this.dist=dist;
            this.node=node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int ti=time[2];

            adj.get(u).add(new pair(ti,v));
        }
        int[] distance = new int[n+1];
        for(int i=0;i<=n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[k]=0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new pair(0,k));
        while(!pq.isEmpty()){
            pair curr= pq.poll();
            int dist = curr.dist;
            int node = curr.node;

            for(pair it:adj.get(node)){
                int adjnode=it.node;
                int edw=it.dist;

                if(dist+edw<distance[adjnode]){
                    distance[adjnode]=dist+edw;
                    pq.add(new pair(distance[adjnode],adjnode));

                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(distance[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans= Math.max(ans,distance[i]);
        }
        return ans;
    }
}

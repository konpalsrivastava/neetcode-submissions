class Solution {
    class pair{
        int node;
        int cost;
        int stops;
        pair(int node,int cost,int stops){
            this.node=node;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       List<List<pair>> adj = new ArrayList<>();
       for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
       }
       for(int[] f:flights){
        adj.get(f[0]).add(new pair(f[1],f[2],0));
       }
       int[] dist = new int[n];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[src] = 0;
       Queue<pair> q = new LinkedList<>();
       q.offer(new pair(src,0,0));
       while(!q.isEmpty()){
        pair curr = q.poll();
        int nnode = curr.node;
        int c = curr.cost;
        int s = curr.stops;

        if(s>k){
            continue;
        }

        for(pair itr:adj.get(nnode)){
            int adjnode = itr.node;
            int wt = itr.cost;

            if(c+wt<dist[adjnode]){
                dist[adjnode] = c+ wt;
                q.offer(new pair(adjnode,c+wt,s+1));
            }
        }
       }
       if(dist[dst]==Integer.MAX_VALUE){
        return -1;
       }
       return dist[dst];
    }
}

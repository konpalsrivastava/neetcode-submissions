class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
       for(int s:stones){
        maxheap.offer(s);
       } 
       while(maxheap.size()>1){
        int a = maxheap.poll();
        int b = maxheap.poll();
        if(a!=b){
            maxheap.offer(a-b);
        }
       }
       if(maxheap.isEmpty()){
        return 0;
       }
       return maxheap.peek();
    }
}

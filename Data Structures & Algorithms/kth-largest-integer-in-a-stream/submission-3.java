class KthLargest {
    int k;
    PriorityQueue<Integer> minheap;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        minheap = new PriorityQueue<>();
        for(int num:nums){
            minheap.add(num);
            if(minheap.size()>k){
                minheap.poll();
            }
        }   
    }
    
    public int add(int val) {
        minheap.add(val);
        if(minheap.size()>k){
            minheap.poll();
        }
        return minheap.peek();
    }
}

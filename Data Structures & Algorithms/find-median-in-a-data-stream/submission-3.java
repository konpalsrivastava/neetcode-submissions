class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder() {
        maxheap = new PriorityQueue<>((a,b)->b-a);
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
       if(maxheap.isEmpty()||num<=maxheap.peek()){
        maxheap.add(num);
       }
       else{
        minheap.add(num);
       }
       if(maxheap.size()>minheap.size()+1){
        minheap.add(maxheap.poll());
       }
       if(minheap.size()>maxheap.size()){
        maxheap.add(minheap.poll());
       }
    }
    
    public double findMedian() {
        if(minheap.size()==maxheap.size()){
            return (minheap.peek() + (double)maxheap.peek())/2.0;
        }
        return maxheap.peek();
    }
}

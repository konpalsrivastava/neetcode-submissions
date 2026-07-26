class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        } 
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            minheap.offer(new int[]{entry.getKey(),entry.getValue()});
            if(minheap.size()>k){
                minheap.poll();
            }
        }
            int j=0;
            while(minheap.size()>0){
                result[j] = minheap.poll()[0];
                j++; 
            }
            return result;
        }
    }

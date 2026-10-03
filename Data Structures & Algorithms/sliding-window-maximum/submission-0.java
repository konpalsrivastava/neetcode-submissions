class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int left=0;
        int right=0;
        while(right<nums.length){
            pq.offer(nums[right]);
            if(right-left+1==k){
                ans.add(pq.peek());
                pq.remove(nums[left]);
                left++;
            }
            right++;
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int prev1=0;
        int prev2=0;
        for(int i=0;i<n-1;i++){
            int current=Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=current;
        }
        int max1=prev1;
        prev1=0;
        prev2=0;
        for(int i=1;i<n;i++){
            int current=Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=current;
        }
        int max2=prev1;
        return Math.max(max1,max2);
    }
}

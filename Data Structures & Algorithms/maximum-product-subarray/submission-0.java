class Solution {
    public int maxProduct(int[] nums) {
        int currmax=nums[0];
        int currmin=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int num=nums[i];
            int tempmax=Math.max(num,Math.max(currmax*num,currmin*num));
            int tempmin=Math.min(num,Math.min(currmax*num,currmin*num));
            currmax=tempmax;
            currmin=tempmin;
            ans=Math.max(currmax,ans);
        }
        return ans;
    }
}

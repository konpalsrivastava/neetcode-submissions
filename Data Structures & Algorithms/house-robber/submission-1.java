class Solution {
    public int helper(int[] nums,int[] dp,int i){
        if(i==0){
            return nums[i];
        }
        if(i<0) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        int pick = nums[i] + helper(nums,dp,i-2);
        int notpick = helper(nums,dp,i-1);
        dp[i] = Math.max(pick,notpick);
        return dp[i];
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,dp,nums.length-1);
    }
}

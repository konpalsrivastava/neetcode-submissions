class Solution {
    public int solve(int[] nums,int i,int prev,int[][] dp){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int not=solve(nums,i+1,prev,dp);
        int pick=0;
        if(prev==-1||nums[i]>nums[prev]){
            pick = 1+solve(nums,i+1,i,dp);
        }
        dp[i][prev+1]=Math.max(not,pick);
        return dp[i][prev+1];
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,-1,dp);
    }
}

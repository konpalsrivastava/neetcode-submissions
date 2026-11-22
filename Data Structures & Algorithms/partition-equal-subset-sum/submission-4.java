class Solution {
    public boolean solve(int[] nums,int i, int target,int[][] dp){
        if(target==0){
            return true;
        }
        if(i==0){
            return nums[i]==target;
        }
        if(dp[i][target]!=-1){
            return dp[i][target]==1;
        }
        boolean not = solve(nums,i-1,target,dp);
        boolean yes = false;
        if(nums[i]<=target){
            yes = solve(nums,i-1,target-nums[i],dp);
        }
        if(yes||not){
            dp[i][target]=1;
        }
        else{
            dp[i][target]=0;
        }
        return dp[i][target]==1;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        int[][] dp = new int[nums.length][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,nums.length-1,target,dp);
    }
}

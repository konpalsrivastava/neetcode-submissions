class Solution {
    public int solve(int[] dp , int i , int[] cost){
        if(i<0){
            return 0;
        }
        if(i==0||i==1){
            return cost[i];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int one = solve(dp,i-1,cost);
        int two = solve(dp,i-2,cost);
        
        dp[i] = cost[i] + Math.min(one,two);
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(dp,n-1,cost),solve(dp,n-2,cost));
    }
}

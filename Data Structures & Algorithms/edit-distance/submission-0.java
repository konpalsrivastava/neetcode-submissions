class Solution {
    public int solve(int i,int j,int[][] dp,String word1,String word2){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j] = solve(i-1,j-1,dp,word1,word2);
        }
        int replace = 1+solve(i-1,j-1,dp,word1,word2);
        int insert = 1+solve(i,j-1,dp,word1,word2);
        int del = 1+solve(i-1,j,dp,word1,word2);
        dp[i][j]=Math.min(replace,Math.min(insert,del));
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int n= word1.length();
        int m= word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(n-1,m-1,dp,word1,word2);
    }
}

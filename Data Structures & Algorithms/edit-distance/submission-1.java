class Solution {
    public int solver(int i,int j,String word1,String word2,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            return solver(i-1,j-1,word1,word2,dp);
        }
        int replace = 1+solver(i-1,j-1,word1,word2,dp);
        int insert = 1+solver(i,j-1,word1,word2,dp);
        int del = 1+solver(i-1,j,word1,word2,dp);
        dp[i][j]=Math.min(replace,Math.min(insert,del));
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solver(n-1,m-1,word1,word2,dp);

    }
}

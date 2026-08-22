class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        helper(ans,board,0,n);
        return ans;
    }
    public void helper(List<List<String>> ans,char[][] board,int row,int n){
        if(row==n){
            List<String> sub = new ArrayList<>();
            for(char[] r:board){
                sub.add(new String(r));
            }
            ans.add(sub);
            return ;
        }
        for(int col=0;col<n;col++){
            if(isSafe(board,n,row,col)){
                board[row][col]='Q';
                helper(ans,board,row+1,n);
                board[row][col]='.';
            }
        }
    }
    private boolean isSafe(char[][] board,int n,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
                if(board[i][j]=='Q'){
                    return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
                if(board[i][j]=='Q'){
                    return false;
            }
        }
        return true;
    }
}

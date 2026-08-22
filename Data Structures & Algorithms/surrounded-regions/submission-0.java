class Solution {
    public void dfs(int r,int c,char[][] board){
        if(r>=board.length||r<0||c>=board[0].length||c<0||board[r][c]!='O'){
            return ;
        }
        board[r][c]='S';
        dfs(r-1,c,board);
        dfs(r+1,c,board);
        dfs(r,c+1,board);
        dfs(r,c-1,board);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){ //upper column
                dfs(i,0,board);
            }
            if(board[i][n-1]=='O'){ //lower column
                dfs(i,n-1,board);
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){  //left boundary
            dfs(0,j,board);
            }
            if(board[m-1][j]=='O'){
                //right boundary
                dfs(m-1,j,board);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='S'){
                    board[i][j]='O';
                }
            }
        }
    }
}

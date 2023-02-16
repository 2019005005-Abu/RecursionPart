class Solution{
    public boolean isSafe(char[][] board,int row,int col,int number) {
        for(int i=0;i<board.length;i++){
            if(board[i][col]== (char)(number+'0')){
                return false;
            }
            if(board[row][i]==(char)(number+'0')){
             return false;
            }
        }
        //grid
        int sr=(row/3)*3;
        int sc=(row/3)*3;
        for(int i=sr;i<sr+3;i++){
           for(int j=sc;j<sc+3;j++){
            if(board[i][j]== (char)(number+'0')){
                return false;
            }
           } 
        }
        return false;
    }
    public boolean helper(char[][] board,int row,int col){
    
    if(row==board.length){
        return true;
    }
        int n_row=0;
        int  n_col=0;
        if(col !=board.length-1){
            n_row=row;
            n_col=col-1;
        }else{
            n_row=n_row+1;
            n_col=0;
        }

     if(board[row][col] !='.'){
        if(helper(board, n_row, n_col)){
            return true;
        }else{
            for(int i=1;i<=9;i++){
                if(isSafe(board,row,col,i)){
                 board[row][col]=(char)(i+'0');
                 if(helper(board, n_row, n_col)){
                    return true;
                 }else{
                    board[row][col]='.';
                 }
                 
                }
            }
        }
     }
     return false;
    }

    public  void solveSuduku(char[][] board) {
         helper(board,0,0);
    }
}
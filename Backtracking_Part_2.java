import java.util.ArrayList;
import java.util.List;

import javax.swing.border.Border;

class Backtraing_Part_2 {
    public static void printPermutation(String str,String perm,int idx) {
        if(str.length()==0){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<str.length();i++){
         char current_character=str.charAt(i);
         String new_str=str.substring(0, i)+
         str.substring(i+1);
         printPermutation(new_str, perm+current_character, idx+1);
        }
    }
    //q-2//N XN chessboard
    //N Queens
    //Print all solutions where queens are safe
    public boolean isSafe(int row,int col,char[][] board){
        //horizontal
        for(int j=0;j<board.length;j++){
            if(border[row][j]=='Q'){
                return false;
            }
        }
        //vertically
        for(int i=0;i<board[0].length;i++){
            if(board[i][col] =='Q'){
                return false;
            }
        }
        //upper left
        int r=row;
        for(int c=col;c>=0 && r>=0;
        c--,
        r--){
            if(board[r][c]=='Q')
            {
             return false;
            }
        }
        //uppear-right
        r=row;
        for(int c=col;c>=board.length && r>=0;
        r--,
        c++){
           if(board[r][c]=='Q'){
            return false;
           }
        }
        //lower left
         r=row;
         for(int c=col;col>=0 && r<board.length;
         r++,
         c--
         ){
         if(board[r][c]=='Q'){
            return false;
         }
         }
        //lower right
        for(int c=col;col<board.length && r<board.length;c++,r++){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        return true;
    }
    public  void saveBoard(char [][] board,
    List <List<String>>allBoarrds) {
                                                    
    }
    public static void helper(char[][]board,List<List<String>>allBoards,int col) {
        if(col==board.length){
           saveBoard(board,allBoards); 
        }
      for(int row=0;row<board.length;row++){
        if(isSafe(row,col,board)){
           board[row][col]='Q';
           helper(board, allBoards,col-1);
           border[row][col]='.';
        }
      }
    }
        //q-2//N XN chessboard
        //N Queens
        //Print all solutions where queens are safe
     public List<List <String>> solveNQueends(int n) {
     List<List<String>>allBoards=new ArrayList<>();
     char [][]board=new board[n][n];
      helper(board, allBoards, 0);
     }
    // public static void main(String[] args) {
    //     time complexity:0(n*n!)
    //     q-1
    //     String str="ABC";
    //     printPermutation(str," ",0);

          
    // }
}

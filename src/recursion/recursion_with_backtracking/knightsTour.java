//*******Knights Tour 
//Question
//1. You are given a number n, the size of a chess board.
//2. You are given a row and a column, as a starting point for a knight piece.
//3. You are required to generate the all moves of a knight starting in (row, col) such that 
//knight visits all cells of the board exactly once.
//4. Complete the body of printKnightsTour function - without changing signature - 
//to calculate and print all configurations of the chess board representing the route
//of knight through the chess board. Use sample input and output to get more idea.
//Note -> When moving from (r, c) to the possible 8 options give first precedence to 
//(r - 2, c + 1) and move in clockwise manner to explore other options.
//Note -> The online judge can't force you to write the function recursively 
//but that is what the spirit of question is. Write recursive and not iterative logic.
//The purpose of the question is to aid learning recursion and not test you.
//Input Format
//A number n
//A number row
//A number col
//Output Format
//All configurations of the chess board representing route of knights through the chess board starting in (row, col)
//Use displayBoard function to print one configuration of the board.
//Constraints
//n = 5
//0 <= row < n
//0 <= col < n
//Sample Input
//5
//2
//0
//Sample Output
//25 2 13 8 23 
//12 7 24 3 14 
//1 18 15 22 9 
//6 11 20 17 4 
//19 16 5 10 21 
//
//19 2 13 8 21 
//12 7 20 3 14 
//1 18 15 22 9 
//6 11 24 17 4 
//25 16 5 10 23 
//
//25 2 13 8 19 
//12 7 18 3 14 
//1 24 15 20 9 
//6 11 22 17 4 
//23 16 5 10 21 
//
//19 2 13 8 25 
//12 7 18 3 14 
//1 20 15 24 9 
//6 11 22 17 4 
//21 16 5 10 23 
//
//21 2 17 8 19 
//12 7 20 3 16 
//1 22 13 18 9 
//6 11 24 15 4 
//23 14 5 10 25 
//
//23 2 17 8 25 
//12 7 24 3 16 
//1 22 13 18 9 
//6 11 20 15 4 
//21 14 5 10 19 
//
//25 2 17 8 23 
//12 7 24 3 16 
//1 18 13 22 9 
//6 11 20 15 4 
//19 14 5 10 21 
//
//19 2 17 8 21 
//12 7 20 3 16 
//1 18 13 22 9 
//6 11 24 15 4 
//25 14 5 10 23 
//
//25 2 15 8 19 
//16 7 18 3 14 
//1 24 11 20 9 
//6 17 22 13 4 
//23 12 5 10 21 
//
//19 2 15 8 25 
//16 7 18 3 14 
//1 20 11 24 9 
//6 17 22 13 4 
//21 12 5 10 23 
//
//21 2 15 8 19 
//16 7 20 3 14 
//1 22 11 18 9 
//6 17 24 13 4 
//23 12 5 10 25 

package recursion.recursion_with_backtracking;
import java.util.*;
import java.io.*;
public class knightsTour {
	 static Scanner scn = new Scanner(System.in);
	    public static void main(String[] args) throws Exception {
	        int n=scn.nextInt();
	        int[][]chess=new int[n][n];
	        for(int[]arr:chess) Arrays.fill(arr,-1);
	        int sr=scn.nextInt();
	        int sc=scn.nextInt();
	        int[][]dir={{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	        printKnightsTour(chess,sr,sc,dir,1,chess.length*chess.length);
	        
	    }

	    public static void printKnightsTour(int[][] chess, int sr, int sc,int[][]dir,int move,int tnc) {
	        if(move==tnc){
	            chess[sr][sc]=move;
	            displayBoard(chess);
	            chess[sr][sc]=-1;
	            return;
	        }
	        chess[sr][sc]=move;
	        for(int d=0;d<dir.length;d++){
	            int r=sr+dir[d][0];
	            int c=sc+dir[d][1];
	            if(r>=0&&c>=0&&r<chess.length&&c<chess.length&&chess[r][c]==-1)
	                printKnightsTour(chess,r,c,dir,move+1,tnc);
	        }
	        chess[sr][sc]=-1;
	    }
	    

	    public static void displayBoard(int[][] chess) {
	        for (int i = 0; i < chess.length; i++) {
	            for (int j = 0; j < chess[0].length; j++) {
	                System.out.print(chess[i][j] + " ");
	            }
	            System.out.println();
	        }

	        System.out.println();
	    }
}


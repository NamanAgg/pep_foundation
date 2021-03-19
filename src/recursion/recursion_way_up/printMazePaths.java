//*****Print Maze Paths 
//Question
//1. You are given a number n and a number m representing number of rows and columns in a maze.
//2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
//3. Complete the body of printMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
//Input Format
//A number n
//A number m
//Output Format
//Print paths (one path in each line) in order hinted by Sample output
//Constraints
//0 <= n <= 10
//0 <= m <= 10
//Sample Input
//2
//2
//Sample Output
//hv
//vh
package recursion.recursion_way_up;
import java.util.*;
public class printMazePaths {
	  static Scanner scn=new Scanner(System.in);
	    public static void main(String[] args) throws Exception {
	        int n=scn.nextInt();
	        int m=scn.nextInt();
	        printMazePaths(0,0,n-1,m-1,"");
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        if(sr==dr&&sc==dc){
	            System.out.println(psf);
	        }
	         if(sc+1<=dc)
	        printMazePaths(sr,sc+1,dr,dc,psf+"h");
	        if(sr+1<=dr)
	        printMazePaths(sr+1,sc,dr,dc,psf+"v");
	      
	        
	    }
}

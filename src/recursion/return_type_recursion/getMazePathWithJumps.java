//******Get Maze Path With Jumps
//Question
//1. You are given a number n and a number m representing number of rows and columns in a maze.
//2. You are standing in the top-left corner and have to reach the bottom-right corner. 
//3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
//4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
//Input Format
//A number n
//A number m
//Output Format
//Contents of the arraylist containing paths as shown in sample output
//Constraints
//0 <= n <= 10
//0 <= m <= 10
//Sample Input
//2
//2
//Sample Output
//[h1v1, v1h1, d1]
package recursion.return_type_recursion;
import java.util.*;
public class getMazePathWithJumps {
	  static Scanner scn=new Scanner(System.in);
	    public static void main(String[] args) throws Exception {
	    int n=scn.nextInt();
	    int m=scn.nextInt();
	    System.out.println(getMazePaths(0,0,n-1,m-1));
	    }
	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
	        if(sr==dr&&sc==dc){
	            ArrayList<String>base=new ArrayList<>();
	            base.add("");
	            return base;
	        }
	        ArrayList<String>myAns=new ArrayList<>();
	        for(int jump=1;jump+sc<=dc;jump++){
	            ArrayList<String> Horizontal=getMazePaths(sr,sc+jump,dr,dc);
	            for(String s : Horizontal)
	                myAns.add("h"+jump+s);
	        }
	        
	        for(int jump=1;jump+sr<=dr;jump++){
	            ArrayList<String> Vertical=getMazePaths(sr+jump,sc,dr,dc);
	            for(String s : Vertical)
	                myAns.add("v"+jump+s);
	        }
	        
	        for(int jump=1;jump+sc<=dc&&jump+sr<=dr;jump++){
	            ArrayList<String> Diagonal=getMazePaths(sr+jump,sc+jump,dr,dc);
	            for(String s : Diagonal)
	                myAns.add("d"+jump+s);
	        }
	        
	        return myAns;
	    }

}

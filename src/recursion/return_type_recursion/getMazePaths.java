//******Get Maze Paths 
//Question
//1. You are given a number n and a number m representing number of rows and columns in a maze.
//2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
//3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
//Input Format
//A number n
//A number m
//Output Format
//Contents of the arraylist containing paths as shown in sample output
//Constraints
//0 <= n <= 10
//0 <= m <= 10
//Sample Input
//3
//3
//Sample Output
//[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
package recursion.return_type_recursion;
import java.io.*;
import java.util.*;
public class getMazePaths {
	
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
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns=new ArrayList<>();
        if(sc+1<=dc){
            ArrayList<String>Horizontal=getMazePaths(sr,sc+1,dr,dc);
            for(String s:Horizontal){
                myAns.add("h"+s);
            }
        }
        
        if(sr+1<=dr){
            ArrayList<String>Vertical=getMazePaths(sr+1,sc,dr,dc);
            for(String s:Vertical){
                myAns.add("v"+s);
            }
        }
        return myAns;

    }
}

//*******Get Stair Paths
//Question
//1. You are given a number n representing number of stairs in a staircase.
//2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
//3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
//Input Format
//A number n
//Output Format
//Contents of the arraylist containing paths as shown in sample output
//Constraints
//0 <= n <= 10
//Sample Input
//3
//Sample Output
//[111, 12, 21, 3]
package recursion.return_type_recursion;
import java.io.*;
import java.util.*;
public class getStairPaths {
	  static Scanner scn=new Scanner(System.in);
	    public static void main(String[] args) throws Exception {
	        int n=scn.nextInt();
	        System.out.println(getStairPaths(n,0));
	    }

	    public static ArrayList < String > getStairPaths(int n,int pos) {
	        if(pos==n){
	            ArrayList<String>base=new ArrayList<>();
	            base.add("");
	            return base;
	        }
	        ArrayList<String>myAns=new ArrayList<>();
	        for(int i=1;i+pos<=n&&i<=3;i++){
	            ArrayList<String>recAns=getStairPaths(n,pos+i);
	            for(String s: recAns)
	                myAns.add(String.valueOf(i)+s);
	        }
	        return myAns;
	    }
}

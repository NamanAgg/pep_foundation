//*******Print Stair Paths
//Question
//1. You are given a number n representing number of stairs in a staircase.
//2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
//3. Complete the body of printStairPaths function - without changing signature - to print the list of all paths that can be used to climb the staircase up.
//Input Format
//A number n
//Output Format
//Print paths (one path in each line) in order hinted by Sample output
//Constraints
//0 <= n <= 10
//Sample Input
//3
//Sample Output
//111
//12
//21
//3
package recursion.recursion_way_up;
import java.io.*;
import java.util.*;
public class printStairPaths {
    static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n=scn.nextInt();
        printStairPaths(n,"");
    }

    public static void printStairPaths(int n, String path) {
        if(n==0){
            System.out.println(path);
            return;
        }
        for(int i=1;n-i>=0&&i<=3;i++)
            printStairPaths(n-i,path+i);

    }
}

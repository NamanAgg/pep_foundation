//*******Flood Fill
//Question
//1. You are given a number n, representing the number of rows.
//2. You are given a number m, representing the number of columns.
//3. You are given n*m numbers, representing elements of 2d array a. The numbers can be 1 or 0 only.
//4. You are standing in the top-left corner and have to reach the bottom-right corner. 
//Only four moves are allowed 't' (1-step up), 'l' (1-step left), 'd' (1-step down) 'r' (1-step right). You can only move to cells which have 0 value in them. You can't move out of the boundaries or in the cells which have value 1 in them (1 means obstacle)
//5. Complete the body of floodfill function - without changing signature - to print all paths that can be used to move from top-left to bottom-right.
//Note1 -> Please check the sample input and output for details
//Note2 -> If all four moves are available make moves in the order 't', 'l', 'd' and 'r'
//Input Format
//A number n
//A number m
//e11
//e12..
//e21
//e22..
//.. n * m number of elements
//Output Format
//trrrdlt
//tlldrt
//.. and so on
//Constraints
//1 <= n <= 10
//1 <= m <= 10
//e1, e2, .. n * m elements belongs to set (0, 1)
//Sample Input
//3 3
//0 0 0
//1 0 1
//0 0 0
//Sample Output
//rddr
package recursion.recursion_with_backtracking;
import java.io.*;
import java.util.*;
public class floodFill {
    static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][]maze=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                maze[i][j]=scn.nextInt();
        int[][]dir={{-1,0},{0,-1},{1,0},{0,1}}; 
        String[]dirS={"u","l","d","r"};
        floodfill(maze,0,0,n-1,m-1,dir,dirS,"");
                
    }

    public static void floodfill(int[][] maze, int sr, int sc,int er, int ec,int[][]dir,String[] dirS, String ans) {
    if(sr==er&&sc==ec){
        System.out.println(ans);
        return;
    }
    
    maze[sr][sc]=1;
    int n=maze.length;
    int m=maze[0].length;
    for(int d=0;d<dir.length;d++){
        int r=sr+dir[d][0];
        int c=sc+dir[d][1];
        if(r>=0&&c>=0&&r<n&&c<m&&maze[r][c]==0){
            floodfill(maze,r,c,er,ec,dir,dirS,ans+dirS[d]);
//            System.out.println(dirS[d]+"*");
//            System.out.println(ans+dirS[d]+"*******");
        }
            
    }
    maze[sr][sc]=0;
    }
}

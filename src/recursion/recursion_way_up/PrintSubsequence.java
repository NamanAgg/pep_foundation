//**********Print Subsequence 
//Question
//1. You are given a string str.
//2. Complete the body of printSS function - without changing signature - 
//to calculate and print all subsequences of str.
//Use sample input and output to take idea about subsequences.
//Input Format
//A string str
//Output Format
//Subsequences of str in order hinted by Sample output
//Constraints
//0 <= str.length <= 7
//Sample Input
//yvTA
//Sample Output
//yvTA
//yvT
//yvA
//yv
//yTA
//yT
//yA
//y
//vTA
//vT
//vA
//v
//TA
//T
//A

package recursion.recursion_way_up;
import java.util.*;
import java.io.*;
public class PrintSubsequence {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=scn.next();
		printSS(str,0,"");
	}
	public static void printSS(String str,int idx,String ans) {
		if(idx==str.length())
		{
			System.out.println(ans);
			return;
		}
		printSS(str,idx+1,ans+str.charAt(idx));
		printSS(str,idx+1,ans);
		
		
	}

}

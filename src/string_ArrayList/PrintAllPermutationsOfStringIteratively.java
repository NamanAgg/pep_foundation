//Print All Permutations Of A String Iteratively
//1. You are given a string. 
//2. You have to print all permutations of the given string iteratively.
//Input Format
//A String
//Output Format
//All permutations of the given string(one in a line). 
//Constraints
//1 <= length of string <= 15
//Sample Input
//abc
//Sample Output
//abc
//bac
//cab
//acb
//bca
//cba
package string_ArrayList;
import java.io.*;
import java.util.*;

public class PrintAllPermutationsOfStringIteratively {
	public static void solution(String str) {
        // write your code here
		
		int fact=getFactorial(str.length());
		for(int i=0;i<fact;i++) {
			StringBuilder sb=new StringBuilder(str);
			int temp=i;
			for(int divisor=str.length();divisor>=1;divisor--) {
				int x=temp/divisor;
				int y=temp%divisor;
				System.out.print(sb.charAt(y));
				sb.deleteCharAt(y);
				temp=x;
			}
			System.out.println();
		}

    }
	public static int getFactorial(int n) {
		int val=1;
		for(int i=2;i<=n;i++) 
			val*=i;		
		return val;
	}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }
}

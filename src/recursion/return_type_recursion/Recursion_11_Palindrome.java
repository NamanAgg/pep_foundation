//*****Pep_Java_7Recursion_11Palindrome
//Take N more inputs and store that in an array.
//1.It reads a number N.
//2.Take Another N numbers as input and store them in an Array.
//Write a recursive function which tests if the array is a palindrome and returns a Boolean value.
//print the value returned.
//Example(To be used only for expected output):
//Input:
//4
//1 2 2 1
//Output:
//true
//Constraints
//1<= N <= 10 ^ 9
//1<= A[i] <=10 ^ 9
package recursion.return_type_recursion;
import java.util.*;
import java.io.*;
public class Recursion_11_Palindrome {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=scn.nextInt();
		int[]arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=scn.nextInt();
		System.out.println(isPalindrome(arr,0,n-1));
	}
	
	public static boolean isPalindrome(int[]arr,int front,int rear) {
		if(front>rear)
			return true;
		if(arr[front]!=arr[rear])
			return false;
		boolean res=isPalindrome(arr,front+1,rear-1);
		return res;
	}
//
//	public static boolean isFibonacci(int[]arr,int n,int s1,int s2) {
//		if(n==arr.length)
//			return true;
//		boolean res=isPalindrome(arr,n+1,s2,s1+s2);
//		if(n==0&&arr[n]!=n)
//			return false;
//		if(arr[n]!=s1+s2)
//			return false;
//		
//		return res;
//		
//	}
}

package string_ArrayList;
//*********Print All Palindromic Substrings
//1. You are given a string. 
//2. You have to print all palindromic substrings of the given string.
//Input Format
//A String
//Output Format
//All palindromic substrings(one in a line).
//First, all palindromic substrings starting from first character of string will be printed, then from second character and so on.
//Constraints
//1 <= length of string <= 500
//Sample Input
//abcc
//Sample Output
//a
//b
//c
//cc
//c

import java.util.*;

public class printAllpalindromicSubString {
	 public static void solution(String str) {
	        //write your code here
	        for(int i=0;i<str.length();i++){
	            for(int len=1;i+len<=str.length();len++)
	            {
	            	String st=str.substring(i,i+len);
	            	if(isPalindrome(st))
	            		System.out.println(st);
	            }
	        }

	    }
	    public static boolean isPalindrome(String str){
	        int i=0,j=str.length()-1;
	        while(i<j) {
	        	if(str.charAt(i++)!=str.charAt(j--))
	        		return false;
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        String str = s.next();
	        solution(str);
	    }

}

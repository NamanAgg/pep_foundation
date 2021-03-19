//***********String Compression
//1. You are given a string. 
//2. You have to compress the given string in the following two ways - 
//   First compression -> The string should be compressed such that consecutive duplicates of characters are replaced with a single character.
//   For "aaabbccdee", the compressed string will be "abcde".
//   Second compression -> The string should be compressed such that consecutive duplicates of characters are replaced with the character and followed by the number of consecutive duplicates.
//   For "aaabbccdee", the compressed string will be "a3b2c2de2".
//Input Format
//A String
//Output Format
//Two strings representing first compressed string and second compressed string respectively.
//Constraints
//1 <= length of string <= 1000
//Sample Input
//wwwwaaadexxxxxx
//Sample Output
//wadex
//w4a3dex6

package string_ArrayList;

import java.util.*;

public class StringCompression {
    public static String compression1(String str) {
        // write your code here
    	int prev=0;
    	int curr=1;
    	String ans="";
    	while(prev<str.length()) {
    		if(curr<str.length()&&str.charAt(prev)==str.charAt(curr))
    			prev++;
   
    		else 
    		{
    			//System.out.print(str.charAt(prev));
    			ans=ans.concat(str.substring(prev, prev+1));
    			prev=curr;
    		}
    		curr++;
    	}
    
        return ans;
    }

    public static String compression2(String str) {
        // write your code here
    	int prev=0;
    	int curr=1;
    	String ans="";
    	int count=1;
    	while(prev<str.length()) {
    		if(curr<str.length()&&str.charAt(prev)==str.charAt(curr))
    		{
    			prev++;
    			count++;
    		}
   
    		else 
    		{
    			//System.out.print(str.charAt(prev));
    			if(count>1)
    				ans=ans.concat(str.substring(prev, prev+1))+count;
    			else
    				ans=ans.concat(str.substring(prev, prev+1));
    			prev=curr;
    			count=1;	
    		}
    		curr++;
    	}
    
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }

}

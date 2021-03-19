//**********Toggle Case
//1. You are given a string that contains only lowercase and uppercase alphabets. 
//2. You have to toggle the case of every character of the given string.
//Input Format
//A String
//Output Format
//A String
//Constraints
//1 <= length of string <= 1000
//Sample Input
//pepCODinG
//Sample Output
//PEPcodINg

package string_ArrayList;
import java.io.*;
import java.util.*;

public class ToggleCase {
	public static String toggleCase(String str) {
        //write your code here
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++) {
			int z=str.charAt(i);
			if(z>=97&&z<=122) 
				z-=32;
			else 
				z+=32;
			sb.append((char)z);
		}
		
	
        return sb.toString();
	}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }
}

//Print Kpc 
//Question
//1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
//2. The following list is the key to characters map
//    0 -> .;
//   1 -> abc
//   2 -> def
//   3 -> ghi
//   4 -> jkl
//   5 -> mno
//   6 -> pqrs
//   7 -> tu
//   8 -> vwx
//   9 -> yz
                      
//Input Format
//A string str
//Output Format
//Words that can be produced by pressed keys indictated by str in order hinted by Sample output
//Constraints
//0 <= str.length <= 10
//str contains numbers only
//Sample Input
//78
//Sample Output
//tv
//tw
//tx
//uv
//uw
//ux
package recursion.recursion_way_up;
import java.util.*;
import java.io.*;
public class PrintKPC {
	  static Scanner scn=new Scanner(System.in);
	    public static void main(String[] args) throws Exception {
	    String str=scn.next();
	    printKPC(str,0,"");
	    }
	    static String opts[]={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	    
	    public static void printKPC(String str,int idx,String ans) {
	        if(idx==str.length())
	        {
	            System.out.println(ans);
	            return;
	        }
	        int num=str.charAt(idx)-'0';
	        for(int i=0;i<opts[num].length();i++)
	        	printKPC(str,idx+1,ans+opts[num].charAt(i));
	            
	    }
}

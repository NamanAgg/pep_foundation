//********Get Subsequence
//Question
//1. You are given a string str.
//2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
//Use sample input and output to take idea about subsequences.
//
//Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
//Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
//Input Format
//A string str
//Output Format
//Contents of the arraylist containing subsequences as shown in sample output
//Constraints
//0 <= str.length <= 20
//Sample Input
//abc
//Sample Output
//[, c, b, bc, a, ac, ab, abc]
package recursion.return_type_recursion;
import java.io.*;
import java.util.*;

public class GetSubsequence {
	public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
    	String str=scn.next();
    	System.out.println(gss(str));
    	
    }

    public static ArrayList < String > gss(String str) {
        if(str.length()<=0)
        {
        	ArrayList<String> ls= new ArrayList<>();
        	ls.add("");
        	//System.out.println(ls);
        	return ls;
        }
        char myChar=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String> recLS= gss(ros);
        ArrayList<String> myLS= new ArrayList<>(recLS);
 
        	for(int j=0;j<recLS.size();j++)
        		myLS.add(myChar+recLS.get(j));
        	
        
        return myLS;
    }
}

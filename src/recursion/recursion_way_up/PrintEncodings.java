//*******Print Encodings 
//Question
//1. You are given a string str of digits. (will never start with a 0)
//2. You are required to encode the str as per following rules
//    1 -> a
//    2 -> b
//    3 -> c
//    ..
//    25 -> y
//    26 -> z
//3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
//Use the input-output below to get more understanding on what is required
//123 -> abc, aw, lc
//993 -> iic
//013 -> Invalid input. A string starting with 0 will not be passed.
//103 -> jc
//303 -> No output possible. But such a string maybe passed. In this case print nothing.
//Input Format
//A string str
//Output Format
//Permutations of str in order hinted by Sample output
//Constraints
//0 <= str.length <= 10
//Sample Input
//655196
//Sample Output
//feeaif
//feesf
package recursion.recursion_way_up;
import java.io.*;
import java.util.*;
public class PrintEncodings {
	static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
    	String str=scn.next();
    	printEncodings(str,0,"");
    	//System.out.println(printEncodings2(str,0));//this one is for return type recursion
    }

    public static void printEncodings(String str,int idx,String ans) {
    	if(idx==str.length())
    	{
    		System.out.println(ans);
    		return;
    	}
    	int num=str.charAt(idx)-'0';
    	if(num==0)
    		return;
    	char ch=(char)(num+96);
    	printEncodings(str,idx+1,ans+ch);
    	if(num<3&&idx+1<str.length())
    	{
    		num=num*10+(str.charAt(idx+1)-'0');
    		ch=(char)(num+96);
    		printEncodings(str,idx+2,ans+ch);
    	}
    }
    
    
    //The below code is for return type recursion
    public static ArrayList<String> printEncodings2(String str,int idx){
    	if(idx==str.length())
    	{
    		ArrayList<String> ls=new ArrayList<>();
    		ls.add("");
    		return ls;
    	}
    	int num=str.charAt(idx)-'0';
    	if(num==0) {
    		ArrayList<String> ls=new ArrayList<>();
    		return ls;
    	}
    	char ch=(char)(num+96);
    	ArrayList<String> myLs=new ArrayList<>();
    	ArrayList<String> recLs=printEncodings2(str,idx+1);
    	for(String s:recLs)
    		myLs.add(ch+s);
    	if(num<3&&idx+1<str.length())
    	{
    		num=num*10+(str.charAt(idx+1)-'0');
    		ch=(char)(num+96);
    		recLs=printEncodings2(str,idx+2);
    		for(String s:recLs)
        		myLs.add(ch+s);
    	}
    	return myLs;
    	
    }

}

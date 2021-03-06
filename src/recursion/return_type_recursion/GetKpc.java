//*******Get Kpc 
//Question
//1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
//2. The following list is the key to characters map :
//    0 -> .;
//    1 -> abc
//    2 -> def
//    3 -> ghi
//    4 -> jkl
//    5 -> mno
//    6 -> pqrs
//    7 -> tu
//    8 -> vwx
//    9 -> yz
//3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
//Use sample input and output to take idea about output.
//**Input Format
//A string str
//**Output Format
//Contents of the arraylist containing words as shown in sample output
//**Constraints
//0 <= str.length <= 10
//str contains numbers only
//**Sample Input
//78
//**Sample Output
//[tv, tw, tx, uv, uw, ux]
package recursion.return_type_recursion;
import java.util.*;
import java.io.*;
public class GetKpc {
	public static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		
		System.out.println(getKPC(scn.next(),0));
    }
	static String[]codes= {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"}; 
    public static ArrayList < String > getKPC(String str,int idx) {
    	 if(idx==str.length())
         {
         	ArrayList<String> ls= new ArrayList<>();
         	ls.add("");
         	return ls;
         }
    	 char ch=str.charAt(idx);
    	 int currNum=ch-'0';
    	 ArrayList<String> recLS= getKPC(str,idx+1);
         ArrayList<String> myLS= new ArrayList<>();
         for(int i=0;i<codes[currNum].length();i++) {
        	 for(String s:recLS) {
        		 myLS.add(codes[currNum].charAt(i)+s);
        	 }
         }
         return myLS;
    	 
    }
    
}

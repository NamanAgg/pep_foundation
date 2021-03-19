package recursion.return_type_recursion;
import java.util.*;
import java.io.*;

public class hw_11Jan {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s=scn.next();
		//System.out.println(SumOfDigitInString(s,0));
		
//		String s=scn.next();
//		int n=scn.nextInt();
//		long num=NumberToString(s,s.length()-1);
//		System.out.println(num/n);
		
//		String s1=scn.next();
//		String s2=scn.next();
//		System.out.println(StringOneTwoAreReverse(s1,s2,0));
		
//		String s=scn.next();
//		System.out.println(isPalindrome(s,0,s.length()-1));
		
//		String s=scn.next();
//		int n=scn.nextInt();
//		String res=SeparateDuplicates(s,0);
//		System.out.println(res.charAt(n));
//		SeparateDuplicates2(s,0);
		
//		String s=scn.next();
//		int n=scn.nextInt();
//		String res=RemoveAdjacentsDuplicates(s,0);
//		System.out.println(res.charAt(n));
//		RemoveAdjacentsDuplicates2(s,0);
		
//	    String str=scn.next();
//        int i=scn.nextInt();
//        String s="hi";
//       System.out.println(countHi(str,0,s));
//        String res=removeHi(str,0,s);
//        //System.out.println(res);
//        System.out.println(res.charAt(i));
//        removeHi2(str,0,s,"");
		
//		String str=scn.next();
//		char ch= scn.next().charAt(0);
//		int  i=scn.nextInt();
//		String res=MoveCharacters(str,0,ch);
//		System.out.println(res.charAt(i));
//		//System.out.println(res);
//		MoveCharacters2(str,0,ch,"",0);
		
//		  String str=scn.next();
//	        int i=scn.nextInt();
//	        String res=replaceHiWithPep(str,0,"hi","pep");
//	        System.out.println(res);
//	        System.out.println(res.charAt(i));
//	        replaceHiWithPep2(str,0,"hi","pep","");
		
		
		
		
	}
	
	public static int SumOfDigitInString(String s,int idx) {
		if(idx==s.length())
			return 0;
		int num=s.charAt(idx)-'0';
		return num+SumOfDigitInString(s,idx+1);
	}
	
	public static long NumberToString(String s,int idx) {
		if(idx<0) return 0;
		
		long num=s.charAt(idx)-'0';
		long res=NumberToString(s,idx-1);
		res=res*10+num;
		return res;
	}
	
	public static boolean StringOneTwoAreReverse(String s1,String s2,int idx) {
		if(s1.length()!=s2.length()) return false;
		if(idx==s1.length()) return true;
		boolean res=StringOneTwoAreReverse(s1,s2,idx+1);
		return s1.charAt(idx)==s2.charAt(s2.length()-1-idx)?res:false;
	}
	
	public static boolean isPalindrome(String str,int front,int rear) {
		if(front>rear)
			return true;						
		char ch1=Character.toLowerCase(str.charAt(front));
		char ch2=Character.toLowerCase(str.charAt(rear));
		if(ch1!=ch2)
			return false;
		return isPalindrome(str,front+1,rear-1); 
	}
	
	public static String SeparateDuplicates(String s, int idx) {
		if(idx==s.length()) return ""; //base case
		String res=SeparateDuplicates(s,idx+1);       //faith 
		if(idx!=0 && s.charAt(idx)==s.charAt(idx-1)) { //work
			return "*"+s.charAt(idx)+res;			   //work
		}
		return s.charAt(idx)+res;						//return	
	}
	public static void SeparateDuplicates2(String s, int idx) {
		if(idx==s.length()) return ; 
		     
		if(idx!=0 && s.charAt(idx)==s.charAt(idx-1)) 
			System.out.print('*');							   
		System.out.print(s.charAt(idx));
		SeparateDuplicates2(s,idx+1);				
	}

	public static String RemoveAdjacentsDuplicates(String s, int idx) {
        if(idx==s.length()) return ""; 
        String res=RemoveAdjacentsDuplicates(s,idx+1);        
        if(idx!=0 && s.charAt(idx)==s.charAt(idx-1)) { 
            return res;               
        }
        return s.charAt(idx)+res;                          
    }
    public static void RemoveAdjacentsDuplicates2(String s, int idx) {
        if(idx==s.length()) return ; 
             
        if(idx!=0 && s.charAt(idx)==s.charAt(idx-1)) 
        {
            
        }   
        else
        	System.out.print(s.charAt(idx));
        RemoveAdjacentsDuplicates2(s,idx+1);                                                    
    }
    
    public static String MoveCharacters(String s,int idx,char ch) {
    	if(idx==s.length())
    		return "";
    	String res=MoveCharacters(s,idx+1,ch);
    	if(s.charAt(idx)==ch)
    		return res+ch;
    	else 
    		return s.charAt(idx)+res;
    }
    public static void MoveCharacters2(String s,int idx,char ch,String res,int count) {
    	if(idx==s.length()) {
    		String lastStr="";
    		for(int i=0;i<count;i++)
    			lastStr+=ch;
    		System.out.println(res+lastStr);
    		return;
    	}
    	if(s.charAt(idx)==ch)
    		MoveCharacters2(s,idx+1,ch,res,count+1);
    	else
    		MoveCharacters2(s,idx+1,ch,res+s.charAt(idx),count);
    }
    
    public static int countHi(String str,int idx,String s){
        if(idx>=str.length()-1)
            return 0;
        int count=0;
        String temp=""+str.charAt(idx)+str.charAt(idx+1);
        if(temp.equals(s))
                count=countHi(str,idx+2,s)+1;
        else
            count=countHi(str,idx+1,s);
        return count;
    }
    public static String removeHi(String str,int idx, String s){
        if(idx>=str.length()-1)
            return "";
        //String res="";
        String temp=""+str.charAt(idx)+str.charAt(idx+1);
        return temp.equals(s)?removeHi(str,idx+2,s):str.charAt(idx)+removeHi(str,idx+1,s);    
    }
    public static void removeHi2(String str,int idx,String s,String ans){
        if(idx>=str.length()-1){
            if(idx==str.length())
                System.out.println(ans);
            else
                System.out.println(ans+str.charAt(str.length()-1));
            return;
        }
        
        String temp=""+str.charAt(idx)+str.charAt(idx+1);
        if(temp.equals(s))
                removeHi2(str,idx+2,s,ans);
        else
            removeHi2(str,idx+1,s,str.charAt(idx)+ans);
        
    }
    
    public static String replaceHiWithPep(String str,int idx,String s1,String s2){
    	//**THIS COMMENTED CODE IS WITHOUT idx
    	//if(str.length()<=1) return str;
        //String temp=str.substring(0,2);
        //String ros=str.substring(2);
        //return temp.equals(s1)?   s2+replaceHiWithPep(ros,s1,s2):temp.charAt(0)+replaceHiWithPep(temp.charAt(1)+ros,s1,s2);
            
          if(idx>=str.length()-1){
              if(idx==str.length()-1) return ""+str.charAt(str.length()-1);
              else return "";
          }
          String temp=""+str.charAt(idx)+str.charAt(idx+1);
             return temp.equals(s1)?s2+replaceHiWithPep(str,idx+2,s1,s2):str.charAt(idx)+replaceHiWithPep(str,idx+1,s1,s2);
    }
    public static void replaceHiWithPep2(String str,int idx,String s1,String s2,String ans){
    //**THIS COMMENTED CODE IS WITHOUT idx
    //    if(str.length()<=1){
    //      System.out.println(str+ans);
    //        return;
    //    }
    //    String temp=str.substring(0,2);
    //    String ros=str.substring(2);
    //    if(temp.equals(s1))
    //        replaceHiWithPep2(ros,s1,s2,ans+s2);
    //    else
    //        replaceHiWithPep2(temp.charAt(1)+ros,s1,s2,ans+temp.charAt(0));
         if(idx>=str.length()-1){
            if(idx==str.length())
                System.out.println(ans);
            else
                System.out.println(ans+str.charAt(str.length()-1));
            return;
        }
        String temp=""+str.charAt(idx)+str.charAt(idx+1);
        if(temp.equals(s1))
            replaceHiWithPep2(str,idx+2,s1,s2,ans+s2);
        else
            replaceHiWithPep2(str,idx+1,s1,s2,ans+str.charAt(idx));
    }
    
    
    
}

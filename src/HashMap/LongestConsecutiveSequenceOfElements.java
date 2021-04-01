//***************Longest Consecutive Sequence Of Elements
//1. You are given a number n, representing the size of array a.
//2. You are given n numbers, representing elements of array a.
//3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).
//Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.
//Input Format
//A number n
//n1
//n2
//.. n number of elements
//Output Format
//Elements of longest sequence of consecutive elements of array in separate lines (ignoring duplicates)
//Constraints
//1 <= n <= 30
//0 <= n1, n2, .. n elements <= 15
//Sample Input
//17
//12
//5
//1
//2
//10
//2
//13
//7
//11
//8
//9
//11
//8
//9
//5
//6
//11
//Sample Output
//5
//6
//7
//8
//9
//10
//11
package HashMap;
import java.util.*;
import java.io.*;
public class LongestConsecutiveSequenceOfElements {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
	    // write your code here
	    int n=scn.nextInt();
	    int[]arr=new int[n];
	    for(int i=0;i<n;i++)
	        arr[i]=scn.nextInt();
	    LCSoE(arr);    
	 }
	 
	 public static void LCSoE(int[]arr){
	     HashMap<Integer,Integer>map=new HashMap<>();
	     for(int key:arr)
	        map.put(key,0);
	        
	    int sp=0;
	    int maxLen=0;
	    for(int ele:arr){
	        if(map.containsKey(ele)){
	            map.remove(ele);
	            int le=ele-1;
	            int re=ele+1;
	            
	            while(map.containsKey(le)){
	                map.remove(le);
	                le-=1;
	            }
	            
	            while(map.containsKey(re)){
	                map.remove(re);
	                re+=1;
	            }
	            
	            int len=re-le-1;
	            if(len>maxLen){
	                maxLen=len;
	                sp=le+1;
	            }
	        }
	    }    
	    
	    for(int i=0;i<maxLen;i++)
	        System.out.println(sp+i);
	 }


}

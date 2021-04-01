//**************Get Common Elements - 2
//1. You are given a number n1, representing the size of array a1.
//2. You are given n1 numbers, representing elements of array a1.
//3. You are given a number n2, representing the size of array a2.
//4. You are given n2 numbers, representing elements of array a2.
//5. You are required to find the intersection of a1 and a2. To get an idea check the example below:
//if a1 -> 1 1 2 2 2 3 5
//and a2 -> 1 1 1 2 2 4 5
//intersection is -> 1 1 2 2 5
//Note -> Don't assume the arrays to be sorted. Check out the question video.
//Input Format
//A number n1
//n1 number of elements line separated
//A number n2
//n2 number of elements line separated
//Output Format
//All relevant elements of intersection in separate lines
//The elements of intersection should be printed in order of their occurence in a2.
//Constraints
//1 <= n1, n2 <= 100
//0 <= a1[i], a2[i] < 10
//Time complexity should be O(n)
//Sample Input
//7
//1
//1
//2
//2
//2
//3
//5
//7
//1
//1
//1
//2
//2
//4
//5
//Sample Output
//1
//1
//2
//2
//5
package HashMap;
import java.util.*;
import java.io.*;
public class getCommonElements2 {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
	    // write your code here
	     int n1=scn.nextInt();
		    int[]arr1=new int[n1];
		    for(int i=0;i<n1;i++){
		        arr1[i]=scn.nextInt();
		    }
		    int n2=scn.nextInt();
		    int[]arr2=new int[n2];
		    for(int i=0;i<n2;i++){
		        arr2[i]=scn.nextInt();
		    }
		    
		    getCommonElements2(arr1,arr2);
	 }
	 
	public static void getCommonElements2(int[]arr1,int[]arr2){
	     HashMap<Integer,Integer>map=new HashMap<>();
	     
	     for(int key:arr1){
	         map.put(key,map.getOrDefault(key,0)+1);
	     }
	     
	     for(int key:arr2){
	         if(map.containsKey(key)){
	            System.out.println(key);
	            int val=map.get(key);
	            if(val==1) map.remove(key);
	            else map.put(key,val-1);
	           }
	     }
	 }


}

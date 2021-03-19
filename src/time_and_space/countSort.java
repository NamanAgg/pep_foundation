//****Count Sort
//Question
//1. You are given an array(arr) of integers.
//2. You have to sort the given array in increasing order using count sort.
//Input Format
//An Integer n 
//arr1
//arr2..
//n integers
//Output Format
//Check the sample output and question video.
//Constraints
//1 <= N <= 10000
//-10^8 <= arr[i] <= 10^8
//Sample Input
//5
//7 
//-2 
//4 
//1 
//3
//Sample Output
//-2
//1
//3
//4
//7
package time_and_space;
import java.util.*;
import java.io.*;
public class countSort {

	static Scanner scn=new Scanner(System.in);
	public static void countSort(int[] arr, int min, int max) {
        //write your code here
        int[] freqArr=new int[max-min+1];
        for(int a:arr)
            freqArr[a-min]++;
            
           int itr=0; 
        for(int i=0;i<freqArr.length;i++){
            int freq=freqArr[i];
            while(freq-->0){
                arr[itr++]=i+min;
            }
        }    

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }
}

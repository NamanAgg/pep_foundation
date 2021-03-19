//here we are given a sorted array and a data element,we have to find if the data is present 
//in array then we have to return the data itself or if it isnt present then we have to return the
//element closest to data.
package time_and_space;
import java.util.*;
import java.io.*;
public class closestBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		
		int n=scn.nextInt();
		int[]arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=scn.nextInt();
		int data=scn.nextInt();
		System.out.println(findClosest(arr,data));
	}
	public static int findClosest(int[]arr,int data) {
		int si=0;
		int fi=arr.length-1;
		if(data<arr[si])
			return arr[si];
		else if(data>arr[fi])
			return arr[fi];
		
		while(si<=fi) {
			 int mid=(si+fi)/2;
			if(arr[mid]==data)
				return arr[mid];
			else if(arr[mid]>data)
				fi=mid-1;
			else
				si=mid+1;
		}
		return (arr[si]-data<=data-arr[fi]?arr[si]:arr[fi]);

//		if(Math.abs(data-arr[mid])<Math.abs(Math.min(data-arr[mid+1],data-arr[mid-1]))) {
//			return arr[mid];
//		}
//		else if(Math.abs(data-arr[mid+1])<Math.abs(data-arr[mid-1]))
//			return arr[mid+1];
//		else return arr[mid-1];
	}

}

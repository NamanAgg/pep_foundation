package string_ArrayList;
import java.io.*;
import java.util.*;

public class Easy_pattern {
	public static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=scn.nextInt();
		//easyPattern(n);
		int [][]arr=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				arr[i][j]=scn.nextInt();
		}
		diagonal(arr);

	}
	public static void easyPattern(int n) {
		int count=-1;
		int var=n;
		if(n%2==0)
			var=n+1;
		for(int l=0;l<n;l++) {
			if(l<(var+1)/2) {
				count+=1;
				for(int i=0;i<n;i++)
					System.out.print(count*10+i+1+" ");
			}
			else {
				if(n%2==0&&l==(n+1)/2) {
					count-=1;
				}
				count-=1;
				for(int i=0;i<n;i++)
					System.out.print(count*10+i+1+n+" ");
			}
				
			System.out.println();
		}
	}
	
	public static void diagonal(int[][]arr) {
		int r=arr.length-1;
		int c=-1;
		for(int i=0;i<arr.length*2;i++) {
			if(i>=arr.length) {
				if(i%2==0) {
					r+=1;
					c+=1;
				}
				else {
					r-=1;
					c-=1;
				}
			}
			if(i%2==0) {
				c+=1;
				while(r<arr.length&&c<arr.length&&c>=0&&r>=0) {
					System.out.println(arr[r][c]);
					c+=1;
					r+=1;
				}
			}
			else {
				r-=1;
				while(r<arr.length&&c<arr.length&&c>=0&&r>=0) {
					System.out.println(arr[r][c]);
					r-=1;
					c-=1;
				}
				
				
			}
		}
	}

}

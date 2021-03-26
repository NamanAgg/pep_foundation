package StacksAndQueues;

import java.util.*;
import java.io.*;

public class NextGreaterElementToTheRight {
	  public static void display(int[] a){
		    StringBuilder sb = new StringBuilder();

		    for(int val: a){
		      sb.append(val + "\n");
		    }
		    System.out.println(sb);
		  }

		public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    int n = Integer.parseInt(br.readLine());
		    int[] a = new int[n];
		    for(int i = 0; i < n; i++){
		       a[i] = Integer.parseInt(br.readLine());
		    }

		    int[] nge = solve(a);
		    display(nge);
		 }

		 public static int[] solve(int[] arr){
		   // solve
		   int[]ans=new int[arr.length];
		   Stack<Integer>stack=new Stack<>();
		   for(int i=0;i<arr.length;i++){
		       if(stack.isEmpty()||arr[stack.peek()]>=arr[i])  stack.push(i);
		       else{
		           while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]){
		               ans[stack.pop()]=arr[i];
		           }
		           stack.push(i);
		       }
		   }
		   while(!stack.isEmpty()){
		       ans[stack.pop()]=-1;
		   }
		   return ans;
		 }

}

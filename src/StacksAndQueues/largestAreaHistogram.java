//Largest Area Histogram
//1. You are given a number n, representing the size of array a.
//2. You are given n numbers, representing the height of bars in a bar chart.
//3. You are required to find and print the area of largest rectangle in the histogram.
//e.g.
//for the array [6 2 5 4 5 1 6] -> 12
//A number representing area of largest rectangle in histogram
//Constraints
//0 <= n < 20
//0 <= a[i] <= 10
//Sample Input
//7
//6
//2
//5
//4
//5
//1
//6
//Sample Output
//12
package StacksAndQueues;
import java.util.*;
import java.io.*;
public class largestAreaHistogram {
	 public static int[] NSOR(int[] arr) {
	        int n = arr.length;
	        LinkedList<Integer> st = new LinkedList<>();
	        int[] ans = new int[n];
	        Arrays.fill(ans, n);

	        for (int i = 0; i < n; i++) {
	            while (st.size() != 0 && arr[st.getFirst()] > arr[i]) {
	                ans[st.removeFirst()] = i;
	            }

	            st.addFirst(i);
	        }
	        return ans;
	    }

	    public static int[] NSOL(int[] arr) {
	        int n = arr.length;
	        LinkedList<Integer> st = new LinkedList<>();
	        int[] ans = new int[n];
	        Arrays.fill(ans, -1);
	        for (int i = n-1; i >= 0; i--) {
	            while (st.size() != 0 && arr[st.getFirst()] > arr[i]) {
	                ans[st.removeFirst()] = i;
	            }

	            st.addFirst(i);
	        }
	        return ans;
	    }
	    
	    public static int largestArea(int[]arr) {
	    	int[] nsol= NSOL(arr);
	    	int[]nsor = NSOR(arr);
	    	int max=0;
	    	for(int i=0;i<arr.length;i++) {
	    		int currArea=arr[i]*(nsor[i]-nsol[i]-1);
	    		max=Math.max(max,currArea);
	    	}
	    	
	    	return max;
	    }
	    
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        int n = Integer.parseInt(br.readLine());
	        int[] a = new int[n];
	        for(int i = 0; i < n; i++){
	           a[i] = Integer.parseInt(br.readLine());
	        }
	        
	        System.out.println(largestArea(a));
	     }
}

//***********All Indices Of Array 
//Question
//1. You are given a number n, representing the count of elements.
//2. You are given n numbers.
//3. You are given a number x. 
//4. You are required to find the all indices at which x occurs in array a.
//5. Return an array of appropriate size which contains all indices at which x occurs in array a.
//Input Format
//A number n
//n1
//n2
//.. n number of elements
//A number x
//Output Format
//Return the array of indices from the allIndices function. Display is managed for you.
//Constraints
//1 <= n <= 10^4
//0 <= n1, n2, .. n elements <= 10 ^ 3
//0 <= x <= 10 ^ 3
//Sample Input
//6
//15
//11
//40
//4
//4
//9
//4
//Sample Output
//3
//4
//*******Solution or approach of the question*************
//here in this when we go up in recursion we will count the number of places 
//where the data is present. and then the base case is hit we will make the array of that count size
//and return that empty array of size. and then when we revisit each element again we will check again
//if the arr[idx]==data and if it does then we will put element in the array that is 
//returned(lets consider res) and we will do res[count-1]=idx;
package recursion;
import java.io.*;
import java.util.*;
public class AllIndicesOfArray {
	public static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(br.readLine());
		int n=scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
           // arr[i] = Integer.parseInt(br.readLine());
            arr[i] = scn.nextInt();
        
        }
        //int x = Integer.parseInt(br.readLine());
        int x=scn.nextInt();
        int[] iarr = allIndices(arr, x, 0, 0);

        if (iarr.length == 0) {
            System.out.println();
            return;
        }

        for (int i = 0; i < iarr.length; i++) {
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int data, int idx, int count) {
        // write ur code here
    	if(idx==arr.length) {
    		int []res=new int[count];
    		System.out.println(count);
    		return res;
    	}
    	if(arr[idx]==data)
    		count++;
    	int []res=allIndices(arr,data,idx+1,count);
    	if(arr[idx]==data)
    		res[count-1]=idx;
    	
    	return res;
    	
    }

}

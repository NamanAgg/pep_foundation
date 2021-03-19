//******Pep_Java_7Recursion_13InverseArray
//1.Take an input N, the size of array.
//2.Take N more inputs and store that in an array.
//3.Take One More Input I which I'm going to use for verification that you
//returned a array or not.
//Write a Recursive function which Inverse the array.
//print the Inversed array.
//print the value of I index of the reversed array.
//Example(To be used only for expected output):
//Input:
//4
//1 2 3 0
//2
//Output:
//3 0 1 2
//1
//Input Format
//Integer representing N
//Integer representing N numbers.
//Constraints
//1<= N <= 10 ^ 9
//1<= A[i] <=10 ^ 9
//Output Format
//print the Inversed array.
//print the value of I index of the reversed array.
//Sample Input 0
//4
//1 2 3 0
//2
//Sample Output 0
//3 0 1 2
//1
package recursion.return_type_recursion;
import java.util.*;
public class InverseOfArray {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=scn.nextInt();
		int []arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		int idx=scn.nextInt();
		inverseArray(arr,0);
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println(arr[idx]);
	}
	public static void inverseArray(int[]arr,int idx){
		if(idx==arr.length)
			return;
		int val=arr[idx];//this is storing step. very important in this ques
		inverseArray(arr,idx+1);//this is faith or assumption step
		arr[val]=idx; //this is work step for a single step.
	}

}

package LEVEL_UP.advanceRecursion;
import java.util.*;
import java.io.*;
public class KSubsetWithEqualSum {

	public static ArrayList<ArrayList<Integer>> kSubSetEqualSum(int[]arr,int k){
		ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
		
		int sum=0;
		
		for(int ele:arr) 
			sum+=ele;
		
		if(sum % k !=0|| arr.length<k)
			return ans;
		
		for(int i=0;i<k;i++)
			ans.add(new ArrayList<Integer>());
		
		int[]sumArr=new int[k];
		
		kSubSetSum(arr,0,sumArr,ans);
		return ans;
	}
	
	public static void kSubSetSum(int[]arr,int idx,int[]sumArr,ArrayList<ArrayList<Integer>> ans) {
		if(idx==arr.length) {
			
			int sum=sumArr[0];
			for(int ele:sumArr)
				if(sum!=ele) 
					return;
				
			
			for(ArrayList<Integer> list: ans) { 
					System.out.print(list);
			}
			System.out.println();
			return;
		}

		for(int i=0;i<sumArr.length;i++) {
			ans.get(i).add(arr[idx]);
			sumArr[i]+=arr[idx];
			kSubSetSum(arr,idx+1,sumArr,ans);
			sumArr[i]-=arr[idx];
			ans.get(i).remove(ans.get(i).size()-1);
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			//sum += arr[i];
		}
		int k = scn.nextInt();
		kSubSetEqualSum(arr,k);
		
	}
}

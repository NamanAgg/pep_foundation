package recursion.recursion_with_backtracking;
import java.util.*;
import java.io.*;
public class twoSetsQuesImp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		
		int[]arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=scn.nextInt();
		System.out.println(twoSet(arr,0,"","",0,0));
		//now when we run the above statement we can see that the output will have
		//mirror image answers too.So as to prevent it what we can do is that 
		//fix the first element in set a only and start from idx=1 
		//it will make it compulsory to have first element in set a only thus preventing it to 
		//go to set b.So the call for that is given below
		System.out.println(twoSet(arr,1,""+arr[0]+" ","",arr[0],0));
	}
	
	public static int twoSet(int[]arr,int idx,String a,String b,int sum1,int sum2) {
		if(idx==arr.length) {
			if(sum1==sum2) {
				System.out.println(a+"= "+b);
				return 1;
			}
			else
				return 0;	
		}
		int count=0;
		count+=twoSet(arr,idx+1,a+arr[idx]+" ",b,sum1+arr[idx],sum2);
		count+=twoSet(arr,idx+1,a,b+arr[idx]+" ",sum1,sum2+arr[idx]);
		return count;
	
	}
	
		
	
	
	
}

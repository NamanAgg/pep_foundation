package string_ArrayList;
import java.util.*;
import java.io.*;

public class Field_Trip {
	public static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=scn.nextInt();
		ArrayList<Integer>arr=new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr.add(scn.nextInt());
		}
		System.out.println(fieldTrip(arr));
	}
	
	public static boolean fieldTrip(ArrayList<Integer> arr) {
		Collections.sort(arr);
		for(int i=0;i<arr.size();i++) {
			int pos=bSearch(arr,i);
			if(pos>=0) {
				arr.remove(pos);
			}
			else {
				return false;
			}
		}
		return true;
		
	}
	public static int bSearch(ArrayList<Integer> arr,int start) {
		
		int l=start+1;
		int r=arr.size()-1;
		while(l<=r) {
			int mid=l + (r - l) / 2;
			
			if(arr.get(start)==arr.get(mid)) {
				return mid;
			}
			else if(arr.get(mid)>arr.get(start)) {
				r=mid-1;
			}
			else {
				l=mid+1;
			}
			
		}
		return -1;
	}

}

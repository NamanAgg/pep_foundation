package HashMapAndHeap;
import java.util.*;
import java.io.*;
public class mergeKsortedLists {

	public static ArrayList<Integer> mergeKsortedArrayLists(ArrayList<ArrayList<Integer>> lists){
		ArrayList<Integer> rv=new ArrayList<>();
		//{ele, index, index of lists(so as to know which ArrayList element belong to)
		PriorityQueue<int[]> pq=new PriorityQueue<>();
		
		for(int i=0;i< lists.size();i++)
			pq.add(new int[] { lists.get(i).get(0), 0, i});
		
		while(pq.size() !=0) {
			int[]ar= pq.remove();
			rv.add(ar[0]);
			
			int idx=ar[1];
			int listIdx=ar[2];
			int length= lists.get(listIdx).size();
			
			if(idx+1<length) {
				ar[1]++;
				ar[0]=lists.get(listIdx).get(idx+1);
				pq.add(ar);
			}
		}
		return rv;
	}
	
//	public static ArrayList<ArrayList<Integer>> UsingMergeSort(ArrayList<ArrayList<Integer>> list){
//		if(list.length()==1)
//	}
}

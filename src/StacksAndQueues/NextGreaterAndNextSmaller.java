package StacksAndQueues;

import java.util.*;
import java.io.*;
public class NextGreaterAndNextSmaller {
	 // NG : Next Greater
    // NS : Next Smaller
    // OR : on Right
    // OL : on Left
    public static int[] NGOR(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && arr[st.getFirst()] < arr[i]) {
                ans[st.removeFirst()] = arr[i];
            }

            st.addFirst(i);
        }
        return ans;
    }

    public static int[] NGOL(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = n-1; i >= 0; i--) {
            while (st.size() != 0 && arr[st.getFirst()] < arr[i]) {
                ans[st.removeFirst()] = arr[i];
            }

            st.addFirst(i);
        }
        return ans;
    }

    public static int[] NSOR(int[] arr) {
        int n = arr.length;
        LinkedList<Integer> st = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && arr[st.getFirst()] > arr[i]) {
                ans[st.removeFirst()] = arr[i];
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
                ans[st.removeFirst()] = arr[i];
            }

            st.addFirst(i);
        }
        return ans;
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
         for(String ele:words){
             map.put(ele,map.getOrDefault(ele,0)+1);
         }
         
         PriorityQueue<String> que=new PriorityQueue<>((a,b)->{
              if(map.get(a)==map.get(b)){
                  return b.charAt(0)-a.charAt(0);
              }
             return map.get(a)-map.get(b);
         });
         
         for(String ele:map.keySet()){
             que.add(ele);
             if(que.size()>k)
                 que.remove();
         }
         
  LinkedList<String>ans=new LinkedList<>();
//          PriorityQueue<String>pq=new PriorityQueue<>((a,b)->{
//             return a.charAt(0)-b.charAt(0);
//          });
         
//          while(que.size()!=0)
//              pq.add(que.remove());
         
//          while(pq.size()!=0)
//              ans.add(pq.remove());
         
         while(que.size()!=0)
             ans.addFirst(que.remove());
         return ans;
         
     }
    
}
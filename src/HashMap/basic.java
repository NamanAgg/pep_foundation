package HashMap;
import java.util.ArrayList;
import java.util.HashMap;
public class basic {
	public static void basic_01() { 
	  HashMap<String, Integer> map = new HashMap<>();
      map.put("Nepal", 233);
      map.put("UK", 45);
      map.put("Germany", 35);
      map.put("USA", 20);
      map.put("Russia", 18);
      map.put("India", 10);
      map.put("USA", 19);

      // System.out.println(map);
      for (String keys : map.keySet()) {
          System.out.println(keys + " -> " + map.get(keys));
      }

      String key = "USA";
      if (map.containsKey(key))
          System.out.println(map.get(key));
      else
          System.out.println("not Found");

  }

  public static void printFrequency(String str) {
      HashMap<Character, Integer> map = new HashMap<>();
      // for (int i = 0; i < str.length(); i++) {
      // char ch = str.charAt(i);
      // if (map.containsKey(ch))
      // map.put(ch, map.get(ch) + 1);
      // else
      // map.put(ch, 1);
      // }

      for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          map.put(ch, map.getOrDefault(ch, 0) + 1);
      }
  }

  public static void highestFreqChar(String str) {
      HashMap<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          map.put(ch, map.getOrDefault(ch, 0) + 1);
      }
      char ans = ' ';
      int freq = 0;
      for (Character ch : map.keySet()) {
          if (map.get(ch) > freq) {
              freq = map.get(ch);
              ans = ch;
          }
      }

      System.out.println(ans);
  }

  public static void positionOfAllChar(String str) {
	  HashMap<Character,ArrayList<Integer>> map=new HashMap<>();
//	  for (int i = 0; i < str.length(); i++) {
//          char ch = str.charAt(i);
//          if(!map.containsKey(ch))
//        	  map.put(ch, new ArrayList<>());
//          map.get(ch).add(i);
//      }	  
	  for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          map.putIfAbsent(ch, new ArrayList<>());
          map.get(ch).add(i);
      }

	  for (Character keys : map.keySet()) {
          System.out.println(keys + " -> " + map.get(keys));
      }
	  
  }

	 public static void getCommonElements1(int[]arr1,int[]arr2){
	     HashMap<Integer,Boolean>map=new HashMap<>();
	     
	     for(int i=0;i<arr1.length;i++){
	         map.put(arr1[i],true);
	     }
	     
	     for(int i=0;i<arr2.length;i++){
	         if(map.containsKey(arr2[i])){
	             System.out.println(arr2[i]);
	             map.remove(arr2[i]);
	         }
	     }
	 }
	 
  
  public static void getCommonElements2(int[]arr1,int[]arr2){
	     HashMap<Integer,Integer>map=new HashMap<>();
	     
	     for(int key:arr1){
	         map.put(key,map.getOrDefault(key,0)+1);
	     }
	     
	     for(int key:arr2){
	         if(map.containsKey(key)){
	            System.out.println(key);
	            int val=map.get(key);
	            if(val==1) map.remove(key);
	            else map.put(key,val-1);
	           }
	     }
	 }


  public static void main(String[] args) {
      // basic_01();
      //highestFreqChar("abcbbbccbbbbbbbb");
	  positionOfAllChar("abcdddfbgbhhhbffcrcaabqqbwwwwbbffeeebddbeeccbb");
  }

}

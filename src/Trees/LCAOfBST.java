//**************Lca Of Bst
//1. You are given a partially written BST class.
//2. You are required to complete the body of lca function. "lca" function is expected to find the lowest commong ancestor of d1 and d2.
//Input Format
//Input is managed for you
//Output Format
//Output is managed for you
//Constraints
//None
//Sample Input
//21
//50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
//12
//30
//Sample Output
//25
package Trees;
import java.util.*;
import java.io.*;
public class LCAOfBST {
	public static class Node {
	    int data;
	    Node left;
	    Node right;

	    Node(int data, Node left, Node right) {
	      this.data = data;
	      this.left = left;
	      this.right = right;
	    }
	  }

	  public static class Pair {
	    Node node;
	    int state;

	    Pair(Node node, int state) {
	      this.node = node;
	      this.state = state;
	    }
	  }

	  public static Node construct(Integer[] arr) {
	    Node root = new Node(arr[0], null, null);
	    Pair rtp = new Pair(root, 1);

	    Stack<Pair> st = new Stack<>();
	    st.push(rtp);

	    int idx = 0;
	    while (st.size() > 0) {
	      Pair top = st.peek();
	      if (top.state == 1) {
	        idx++;
	        if (arr[idx] != null) {
	          top.node.left = new Node(arr[idx], null, null);
	          Pair lp = new Pair(top.node.left, 1);
	          st.push(lp);
	        } else {
	          top.node.left = null;
	        }

	        top.state++;
	      } else if (top.state == 2) {
	        idx++;
	        if (arr[idx] != null) {
	          top.node.right = new Node(arr[idx], null, null);
	          Pair rp = new Pair(top.node.right, 1);
	          st.push(rp);
	        } else {
	          top.node.right = null;
	        }

	        top.state++;
	      } else {
	        st.pop();
	      }
	    }

	    return root;
	  }

	  public static void display(Node node) {
	    if (node == null) {
	      return;
	    }

	    String str = "";
	    str += node.left == null ? "." : node.left.data + "";
	    str += " <- " + node.data + " -> ";
	    str += node.right == null ? "." : node.right.data + "";
	    System.out.println(str);

	    display(node.left);
	    display(node.right);
	  }

	  public static int lca1(Node node, int d1, int d2) {
	    // write your code here
	    if((node.data==d1) || (node.data==d2) || (node.data>d1&&node.data<d2) || (node.data<d1&&node.data>d2))           return node.data;
	    if(node.data<d1&&node.data<d2) 
	        return lca1(node.right,d1,d2);
	    else return lca1(node.left,d1,d2);
	  }
	  
	  public static Node lca(Node node,int d1,int d2){
	      Node curr=node;
	      
	      while(curr!=null){
	          if(curr.data<d1&&curr.data<d2)
	            curr=curr.right;
	          else if(curr.data>d1&&curr.data>d2)
	            curr=curr.left;
	          else 
	           return (find(curr,d1)&&find(curr,d2))?curr:null; 
	      }
	      return null;
	  }
	  
	  public static boolean find(Node node,int data){
	      if(node==null) return false;
	      if(node.data==data) return true;
	      return node.data<data?find(node.right,data):find(node.left,data);
	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    Integer[] arr = new Integer[n];
	    String[] values = br.readLine().split(" ");
	    for (int i = 0; i < n; i++) {
	      if (values[i].equals("n") == false) {
	        arr[i] = Integer.parseInt(values[i]);
	      } else {
	        arr[i] = null;
	      }
	    }

	    int d1 = Integer.parseInt(br.readLine());
	    int d2 = Integer.parseInt(br.readLine());

	    Node root = construct(arr);
	    // int lca = lca1(root, d1, d2);
	    // System.out.println(lca);
	    Node node=lca(root,d1,d2);
	    System.out.println(node.data);
	  }
}

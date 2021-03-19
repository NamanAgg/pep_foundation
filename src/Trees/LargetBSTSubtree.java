//*************Largest Bst Subtree
//1. You are given a partially written BinaryTree class.
//2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
//3. Input is managed for you. 
//Input Format
//Input is managed for you.
//Output Format
//@
//Constraints
//Time complexity must be O(n)
//Space should not be more than required for recursion (call-stack)
//Sample Input
//15
//50 25 12 n n 37 n n 75 62 n n 87 n n
//Sample Output
//50@7
package Trees;
import java.util.*;
import java.io.*;
public class LargetBSTSubtree {
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
	  
	  	    public static class isBSTSolPair {
		        int maxEle = -(int) 1e8;
		        int minEle = (int) 1e8;
		        boolean isBST = true;

		        boolean isBal = true;
		        int height = -1;

		        int largestBSTSize = 0;
		        Node largestBSTNode = null;

		        int totalNoOfBST = 0;
		    }

		    public static isBSTSolPair allsolution(Node node) {
		        if (node == null) {
		            return new isBSTSolPair();
		        }

		        isBSTSolPair left = allsolution(node.left);
		        isBSTSolPair right = allsolution(node.right);

		        isBSTSolPair ans = new isBSTSolPair();

		        ans.isBST = left.isBST && right.isBST && left.maxEle < node.data && node.data < right.minEle;
		        ans.isBal = left.isBal && right.isBal && Math.abs(left.height - right.height) <= 1;

		        ans.maxEle = Math.max(node.data, right.maxEle);
		        ans.minEle = Math.min(node.data, left.minEle);
		        ans.height = Math.max(left.height, right.height) + 1;

		        ans.totalNoOfBST = left.totalNoOfBST + right.totalNoOfBST + (ans.isBST ? 1 : 0);

		        if (ans.isBST) {
		            ans.largestBSTNode = node;
		            ans.largestBSTSize += left.largestBSTSize + right.largestBSTSize + 1;
		        } else {
		            if (left.largestBSTSize > right.largestBSTSize) {
		                ans.largestBSTNode = left.largestBSTNode;
		                ans.largestBSTSize = left.largestBSTSize;
		            } else {
		                ans.largestBSTNode = right.largestBSTNode;
		                ans.largestBSTSize = right.largestBSTSize;
		            }
		        }

		        return ans;
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

	    Node root = construct(arr);
	    
	    // write your code here
	    
	    isBSTSolPair ans=allsolution(root);
	    System.out.println(ans.largestBSTNode.data+"@"+ans.largestBSTSize);
	  }

}

//********Print Nodes K Distance Away
//1. You are given a partially written BinaryTree class.
//2. You are given a value data and a value k.
//3. You are required to complete the body of printKNodesFar function. The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.
//4. Input is managed for you.
//Input Format
//Input is managed for you
//Output Format
//All nodes which are k distance away in any 
//direction from node with value equal to data, each in a separate line
//Constraints
//None
//Sample Input
//19
//50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
//37
//2
//Sample Output
//12
//50
package Trees;
import java.util.*;
import java.io.*;
public class PrintNodesKDistanceAway {
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

		  public static void printKNodesFar(Node node, int data, int k) {
		    // write your code here
		     ArrayList<Node> path=new ArrayList<>();
				 boolean res=rootToNodePath(node,data,path);
				 if(!res) {
					 return ;
				 }
				 
				 int i=k;
				 Node block=null;
				 for(int j=0;j<path.size();j++) {
					 printAtKDepth(path.get(j),i,block);
					 block=path.get(j);
					 i--;
				 }
				 
		  }
		  
		  	public static boolean rootToNodePath(Node root,int data,ArrayList<Node> ans){
				if(root==null)
					return false;

				boolean res=(data==root.data)||rootToNodePath(root.left,data,ans)||rootToNodePath(root.right,data,ans);
				
				if(res)
					ans.add(root);
					
				return res;
			}
			
			public static void printAtKDepth(Node root,int k,Node block) {
				if(root==null||root==block||k<0)
					return;
				if(k==0) {
					System.out.println(root.data);
					return;
				}
				printAtKDepth(root.left,k-1,block);
				printAtKDepth(root.right,k-1,block);
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

		    int data = Integer.parseInt(br.readLine());
		    int k = Integer.parseInt(br.readLine());

		    Node root = construct(arr);
		    printKNodesFar(root, data, k);
		  }

}

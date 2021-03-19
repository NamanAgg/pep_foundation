package Trees;
import java.util.*;
import java.io.*;
public class BinaryTree {

	public static class Node{
		int data=0;
		Node left=null;
		Node right=null;
	}
	
	public static  void preOrderTraversal(Node root) {
		if(root==null)
			return;
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	public static void inOrderTraversal(Node root) {
		if(root==null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}
	public static void postOrderTraversal(Node root) {
		if(root==null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.data);
	}
	
	//Basic Functions
	
	public static int size(Node root) {
		if(root==null)
			return 0;
		int left=size(root.left);
		int right=size(root.right);
		
		return left+right+1;
		
	}
	public static int height(Node root) {
		if(root==null)
			return -1;
		int left=height(root.left);
		int right=height(root.right);
		
		return Math.max(left, right)+1;
	}
	
	public static int heightInTermsOfNode(Node root) {
		if(root==null)
			return 0;
		int left=heightInTermsOfNode(root.left);
		int right=heightInTermsOfNode(root.right);

		return Math.max(left, right)+1;
	}
	
	public static int maximum(Node root) {
		if(root==null)
			return Integer.MIN_VALUE;
		int left=maximum(root.left);
		int right=maximum(root.right);
		
		return Math.max(Math.max(left, right),root.data);
	}

	public static int minimum(Node root) {
		if(root==null)
			return Integer.MAX_VALUE;
		int left=minimum(root.left);
		int right=minimum(root.right);
		
		return Math.min(Math.min(left, right),root.data);
	}
	
	public static int sum(Node root) {
		if(root==null)
			return 0;
		int left=sum(root.left);
		int right=sum(root.right);
		
		return left+right+root.data;
	}
	
	public static boolean findData(Node root,int data) {
		if(root==null)
			return false;
		if(data==root.data)
			return true;
		
		return findData(root.left,data)||findData(root.right,data);	
	}
	
	public static boolean rootToNodePath(Node root,int data,ArrayList<Node> ans){
		if(root==null)
			return false;

		boolean res=data==root.data||rootToNodePath(root.left,data,ans)||rootToNodePath(root.right,data,ans);
		
		if(res)
			ans.add(root);
		
		return res;
	}
	
	public static void printAtKDepth(Node root,int k,Node block,ArrayList<Integer> ans) {
		if(root==null||root==block||k<0)
			return;
		
		if(k==0) {
			ans.add(root.data);
			return;
		}
		printAtKDepth(root.left,k-1,block,ans);
		printAtKDepth(root.right,k-1,block,ans);
	}
	
	 public ArrayList<Integer> distanceK(Node root, Node target, int K) {
		 ArrayList<Node> path=new ArrayList<>();
		 boolean res=rootToNodePath(root,target.data,path);
		 if(!res) {
			 ArrayList<Integer> base=new ArrayList<>();
			 return base;
		 }
		 
		 ArrayList<Integer> ans=new ArrayList<>();
		 int i=K;
		 Node block=null;
		 for(int j=0;j<path.size();j++) {
			 printAtKDepth(path.get(j),i,block,ans);
			 block=path.get(j);
			 i--;
		 }
		
		 return ans;
		 
	    }
	 
	 public static Node prev = null;

	    public static boolean isBST(Node node) {
	        if (node == null)
	            return true;

	        boolean leftRes = isBST(node.left);
	        if (!leftRes)
	            return false;

	        if (prev != null && prev.data > node.data)
	            return false;
	        prev = node;

	        boolean rightRes = isBST(node.right);
	        if (!rightRes)
	            return false;

	        return true;
	    }

	    public class isBSTSolPair1 {
	        int maxEle = -(int) 1e8;
	        int minEle = (int) 1e8;
	        boolean isBST = true;
	    }

	    public isBSTSolPair1 isBST_(Node node) {
	        if (node == null) {
	            // isBSTSolPair base = new isBSTSolPair();
	            // return base;

	            return new isBSTSolPair1();
	        }

	        isBSTSolPair1 left = isBST_(node.left);
	        isBSTSolPair1 right = isBST_(node.right);

	        isBSTSolPair1 myRes = new isBSTSolPair1();
	        myRes.isBST = false;
	        if (left.isBST && right.isBST && left.maxEle < node.data && node.data < right.minEle) {
	            myRes.isBST = true;
	            myRes.maxEle = Math.max(node.data, right.maxEle);
	            myRes.minEle = Math.min(node.data, left.minEle);
	        }

	        return myRes;
	    }

	    public static class isBalPair {
	        int height = -1;
	        boolean balanceTree = true;
	    }

	    public static isBalPair isBal_(Node node) {
	        if (node == null)
	            return new isBalPair();

	        isBalPair left = isBal_(node.left);
	        if (!left.balanceTree)
	            return left;

	        isBalPair right = isBal_(node.right);
	        if (!right.balanceTree)
	            return right;
	        

	        isBalPair myRes = new isBalPair();
	        myRes.balanceTree = false;
	        if (left.balanceTree && right.balanceTree && Math.abs(left.height - right.height) <= 1) {
	            myRes.balanceTree = true;
	            myRes.height = Math.max(left.height, right.height) + 1;
	        }

	        return myRes;
	    }

	    public static boolean isBal(Node node) {
	        isBalPair ans = isBal_(node);
	        return ans.balanceTree;
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
	
}

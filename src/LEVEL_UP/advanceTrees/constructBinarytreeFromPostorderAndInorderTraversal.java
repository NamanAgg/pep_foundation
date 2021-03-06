//***************Construct Binarytree From Postorder And Inorder Traversal
// 1. You are given a partially written function to solve(Refer question video).
// 2. Task : Construct Binary Tree from PostOrder and InOrder Traversal.
// 3. you will be given two arrays representing a valid PostOrder & InOrder of a Binary Tree.
// Program is required to create a unique Binary Tree.
// Constraints
// 0 <= Number of Nodes <= 10^9
// -10^9 <= value of Node data <= 10^9
// Valid InOrder & PostOrder traversals.
// Sample Input
// 7
// 1 3 2 5 7 6 4
// 1 2 3 4 5 6 7
// Sample Output
// 2 -> 4 <- 6
// 1 -> 2 <- 3
// . -> 1 <- .
// . -> 3 <- .
// 5 -> 6 <- 7
// . -> 5 <- .
// . -> 7 <- .
import java.util.*;
public class constructBinarytreeFromPostorderAndInorderTraversal{
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
     public static TreeNode postOrIn(int[] post, int psi, int pei, int[] in, int isi, int iei) {
        if (isi > iei)
            return null;
        int idx = isi;
        while (in[idx] != post[pei])
            idx++;

        int tel = idx - isi;
        TreeNode root = new TreeNode(post[pei]);

        root.left = postOrIn(post, psi, psi + tel - 1, in, isi, idx - 1);
        root.right = postOrIn(post, psi + tel, pei - 1, in, idx + 1, iei);

        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return postOrIn(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
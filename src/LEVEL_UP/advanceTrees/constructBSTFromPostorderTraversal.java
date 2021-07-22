//**********Construct Bst From Postorder Traversal
// 1. You are given a partially written function to solve(Refer question video).
// 2. Task : Construct Binary Search Tree from given PostOrder Traversal.
// 3. you will be given an array representing a valid PostOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
// Constraints
// 0 <= Number of Nodes <= 10^9
// -10^9 <= value of Node data <= 10^9
// Valid PostOrder traversal.
// Sample Input
// 6
// 1 2 6 7 5 3
// Sample Output
// 2 -> 3 <- 5
// 1 -> 2 <- .
// . -> 1 <- .
// . -> 5 <- 7
// 6 -> 7 <- .
// . -> 6 <- .
import java.util.Scanner;
public class constructBSTFromPostorderTraversal{
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    static int idx = 0;
    public static TreeNode bstFromPostOrder(int[] postOrder, int lr, int rr) {
        if (idx == -1 || postOrder[idx] < lr || postOrder[idx] > rr)
            return null;

        TreeNode node = new TreeNode(postOrder[idx--]);

        node.right = bstFromPostOrder(postOrder, node.val, rr);
        node.left = bstFromPostOrder(postOrder, lr, node.val);

        return node;
    }

    public static TreeNode bstFromPostOrder(int[] postOrder) {
        idx = postOrder.length - 1;
        return bstFromPostOrder(postOrder, -(int) 1e9, (int) 1e9);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostOrder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
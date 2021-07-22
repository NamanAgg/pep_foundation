//*************Construct Bst From Levelorder Traversal
// 1. You are given a partially written function to solve(Refer question video).
// 2. Task : Construct Binary Search Tree from given LevelOrder Traversal.
// 3. you will be given an array representing a valid LevelOrder of a Binary Search Tree.
// Program is required to create a unique Binary Search Tree.
// Constraints
// 0 <= Number of Nodes <= 10^9
// -10^9 <= value of Node data <= 10^9
// Valid LevelOrder traversal.
// Sample Input
// 6
// 3 2 5 1 6 7
// Sample Output
// 2 -> 3 <- 5
// 1 -> 2 <- .
// . -> 1 <- .
// . -> 5 <- 6
// . -> 6 <- 7
// . -> 7 <- .
import java.util.*;
public class constructBSTFromLevelorderTraversal{
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

   public static class bstLPair {
        TreeNode par = null;
        int lr = 0;
        int rr = 0;

        bstLPair(TreeNode par, int lr, int rr) {
            this.par = par;
            this.lr = lr;
            this.rr = rr;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        if (LevelOrder.length == 0)
            return null;
        LinkedList<bstLPair> que = new LinkedList<>();
        TreeNode root = new TreeNode(LevelOrder[0]);
        int idx = 1;

        que.addLast(new bstLPair(root, -(int) 1e9, root.val));
        que.addLast(new bstLPair(root, root.val, (int) 1e9));

        while (idx < LevelOrder.length) {
            bstLPair rp = que.removeFirst();
            int lr = rp.lr, rr = rp.rr;
            if (LevelOrder[idx] < lr || LevelOrder[idx] > rr)
                continue;

            TreeNode node = new TreeNode(LevelOrder[idx++]);
            if (node.val < rp.par.val)
                rp.par.left = node;
            else
                rp.par.right = node;

            que.addLast(new bstLPair(node, rp.lr, node.val));
            que.addLast(new bstLPair(node, node.val, rp.rr));
        }

        return root;
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
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
//*************Root To All Leaf Path In Binary Tree
// 1. Given a Binary Tree, return Root to all leaf path of binary tree
// 2. For more Information watch given video link below.
// Constraints
// 0 <= Number of Nodes <= 10^5
// -1000 <= value of Node data <= 1000
// Sample Input
// 15
// 4
// 2
// 1
// -1
// -1
// 3
// -1
// -1
// 6
// 5
// -1
// -1
// 7
// -1
// -1
// Sample Output
// 4 2 1 
// 4 2 3 
// 4 6 5 
// 4 6 7 
package LEVEL_UP.advanceTrees;
import java.util.*;
public class rootToAllLeafPathInBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> nodeToAllLeafPath(TreeNode root) {
        // write your code here
        ArrayList<Integer> smallAns = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        nodeToAllLeafPath(root, smallAns, res);
        return res;

    }

    public static void nodeToAllLeafPath(TreeNode node, ArrayList<Integer> smallAns,
            ArrayList<ArrayList<Integer>> res) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            ArrayList<Integer> base = new ArrayList<>();
            for (Integer ele : smallAns)
                base.add(ele);

            base.add(node.val);
            res.add(base);
            return;
        }

        smallAns.add(node.val);
        nodeToAllLeafPath(node.left, smallAns, res);
        nodeToAllLeafPath(node.right, smallAns, res);
        smallAns.remove(smallAns.size() - 1);

    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
        Treenode.left = createTree(arr, IDX);
        Treenode.right = createTree(arr, IDX);

        return Treenode;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = nodeToAllLeafPath(root);
        if (ans.size() == 0)
            System.out.println();
        for (ArrayList<Integer> al : ans) {
            for (Integer ele : al)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}

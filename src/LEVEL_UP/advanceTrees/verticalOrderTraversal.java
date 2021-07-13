//*******************Vertical Order Traversal Of A Binarytree
// 1. Given a Binary Tree, print Vertical Order of it. 
// 2. For more Information watch given video link below.
// Constraints
// 0 <= Number of Nodes <= 10^5
// -1000 <= value of Node data <= 1000
// Sample Input
// 15
// 1
// 1
// -1
// 1
// 1
// -1
// 1
// -1
// -1
// 1
// -1
// -1
// 1
// -1
// -1
// Sample Output
// 0 -> 1 1 
// 1 -> 1 1 1 
// 2 -> 1 1 
package LEVEL_UP.advanceTrees;
import java.util.*;
public class verticalOrderTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void widthOfShadow(TreeNode node, int vl, int[] minMax) {
        if (node == null)
            return;
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);
        widthOfShadow(node.left, vl - 1, minMax);
        widthOfShadow(node.right, vl + 1, minMax);
    }

    public static class vPair {
        TreeNode node = null;
        int vl = 0;
        int level = 0;

        vPair(TreeNode node, int vl) {
            this(node, vl, 0);
        }

        vPair(TreeNode node, int vl, int level) {
            this.vl = vl;
            this.node = node;
            this.level = level;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        LinkedList<vPair> que = new LinkedList<>();
        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        int len = minMax[1] - minMax[0] + 1;

        que.addLast(new vPair(root, Math.abs(minMax[0])));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++)
            ans.add(new ArrayList<>());

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                vPair rp = que.removeFirst();
                int vl = rp.vl;
                TreeNode node = rp.node;

                ans.get(vl).add(node.val);

                if (node.left != null)
                    que.addLast(new vPair(node.left, vl - 1));
                if (node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
            }
        }

        return ans;

    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    } 
}

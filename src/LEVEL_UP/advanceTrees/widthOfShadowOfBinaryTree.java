//*****************Width Of Shadow Of Binary Tree
// 1. Given a Binary Tree, return Width Of Shadow Of A Binary Tree. 
// 2. For more detail watch the video.
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
// 3

package LEVEL_UP.advanceTrees;
import java.util.*;
public class widthOfShadowOfBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int width(TreeNode root) {
        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        return minMax[1] - minMax[0] + 1;
    }

    public static void widthOfShadow(TreeNode node, int vl, int[] minMax) {
        if (node == null)
            return;
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);
        widthOfShadow(node.left, vl - 1, minMax);
        widthOfShadow(node.right, vl + 1, minMax);
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

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    } 
}

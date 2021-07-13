//*****************Left View Of A Binarytree
// 1. Given a Binary Tree, print left view of it. 
// 2. Left view of a Binary Tree is set of nodes visible when tree is viewed from left side.
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
// 1
// 1
// 1
// 1
// 1
package LEVEL_UP.advanceTrees;
import java.util.*;
public class leftViewOfABinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> leftView(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        ArrayList<Integer> ans = new ArrayList<>();
        while (que.size() != 0) {

            int size = que.size();
            ans.add(que.getFirst().val);
            while (size-- > 0) {
                TreeNode rnode = que.removeFirst();

                if (rnode.left != null)
                    que.addLast(rnode.left);
                if (rnode.right != null)
                    que.addLast(rnode.right);
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

        ArrayList<Integer> ans = leftView(root);
        for (Integer i : ans)
            System.out.println(i);
    }

    public static void main(String[] args) {
        solve();
    }
}

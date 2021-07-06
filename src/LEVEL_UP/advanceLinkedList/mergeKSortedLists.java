//*************Merge K Sorted Linkedlist
// You are given an array of k linked-lists, each linked-list is sorted in increasing order.
// Merge all the linkedlists into one sorted linkedlist and return it.
// Input Format
// 3 sorted linkedlist :
// {
//     0->0->0->null,
//     0->0->1->1->1->2->2->4->null,
//     0->0->0->0->5->5->6->null
// }
// Output Format
// after merging them : 
// 0->0->0->0->0->0->0->0->0->1->1->1->2->2->4->5->5->6->null

// Constraints
// 0 <= k <= 10^5
// 0 <= size of linkedlist <= 1000
// Sample Input
// 3
// 3
// 0 0 0 
// 8
// 0 0 1 1 1 2 2 4 
// 7
// 0 0 0 0 5 5 6 
// Sample Output
// 0 0 0 0 0 0 0 0 0 1 1 1 2 2 4 5 5 6 
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class mergeKSortedLists {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, c1 = l1, c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;

        return dummy.next;
    }

    public static ListNode mergeKList(ListNode[] lists, int si, int ei) {
        if (si == ei)
            return lists[si];
        int mid = (si + ei) / 2;
        ListNode leftMergedList = mergeKList(lists, si, mid);
        ListNode rightMergedList = mergeKList(lists, mid + 1, ei);

        return mergeTwoLists(leftMergedList, rightMergedList);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeKList(lists, 0, lists.length - 1);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    } 
}

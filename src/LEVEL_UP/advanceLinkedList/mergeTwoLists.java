//********8Merge Two Sorted Linkedlist
// 1. Merge two sorted linkedlists and return head of a sorted linkedlist.
// The list should be made by splicing together the nodes of the first two lists
// 2. Both list are sorted in increasing order.
// Input Format
// 1->2->6->7->15->24->null
// -1->0->6->17->25->null
// Output Format
// -1->0->1->2->6->6->7->15->17->24->25->null
// Constraints
// 0 <= size of linkedlist <= 10^6
// Sample Input
// 2
// 1 5 
// 4
// 1 3 6 10 
// Sample Output
// 1 1 3 5 6 10 
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class mergeTwoLists {
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
        ListNode h1 = createList(n);
        int m = scn.nextInt();
        ListNode h2 = createList(m);

        ListNode head = mergeTwoLists(h1, h2);
        printList(head);
    }
}

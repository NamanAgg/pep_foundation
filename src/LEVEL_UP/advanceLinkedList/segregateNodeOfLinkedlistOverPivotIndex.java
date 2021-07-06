//**************Segregate Node Of Linkedlist Over Pivot Index
// 1. Given a singly linklist, Segregate Node of LinkedList over pivot index and return starting node of linkedlist.
// 2. pivot will be any random index in range of 0 to length Of Linkedlist
// 3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.
// Input Format
// 1->5->2->9->5->14->11->1->10->10->1->3->null
// 11
// Output Format
// 1->2->1->1->3->5->9->5->14->11->10->10->null 
// Constraints
// -10^6 <= size Of LinkedList <= 10^6
// 0 <= pivot Index <= 10^6
// Sample Input
// 12
// 1 5 2 9 5 14 11 1 10 10 1 3 
// 7
// Sample Output
// 1 1 1 5 2 9 5 14 11 10 10 3 
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class segregateNodeOfLinkedlistOverPivotIndex {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate(ListNode head, int pivotIdx) {
        if (head == null || head.next == null)
            return head;

        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode sp = small, lp = large, curr = head;

        ListNode pivotNode = head;
        while (pivotIdx-- > 0)
            pivotNode = pivotNode.next;

        while (curr != null) {
            if (curr != pivotNode && curr.val <= pivotNode.val) {
                sp.next = curr;
                sp = sp.next;
            } else if (curr != pivotNode) {
                lp.next = curr;
                lp = lp.next;
            }
            curr = curr.next;
        }

        sp.next = pivotNode;
        pivotNode.next = large.next;
        lp.next = null;

        head = small.next;
        return head;
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
        int idx = scn.nextInt();
        h1 = segregate(h1, idx);
        printList(h1);
    }
}

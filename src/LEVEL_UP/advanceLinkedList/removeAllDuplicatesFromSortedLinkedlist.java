//************Remove All Duplicates From Sorted Linkedlist
// 1. You are give a single sorted linkedlist of numbers. 
// 2. remove all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the remaning linked list.
// Input Format
// 1->1->1->4->5->6->6->7->8->9->9->9->null
// Output Format
// 4->5->7->8->null
// Constraints
// 0 <= N <= 10^6
// Sample Input
// 12
// 1 1 1 4 5 6 6 7 8 9 9 9
// Sample Output
// 4 5 7 8 
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class removeAllDuplicatesFromSortedLinkedlist {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = head.next, prev = dummy;
        prev.next = head;

        while (curr != null) {
            boolean isLoopRun = false;
            while (curr != null && curr.val == prev.next.val) {
                ListNode forw = curr.next;
                curr.next = null;
                curr = forw;
                isLoopRun = true;
            }

            if (isLoopRun) {
                prev.next = curr;
            } else {
                prev = prev.next;
                prev.next = curr;
            }

            if (curr != null)
                curr = curr.next;
        }

        return dummy.next;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }
}

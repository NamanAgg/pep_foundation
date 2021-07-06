//************Segregate Node Of Linkedlist Over Last Index.
// 1. Given a singly linklist, Segregate Node of LinkedList over lastindex and return pivot node of linkedlist.
// 2. pivot is always be last index of linkedlist.
// 3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.
// Input Format
// 1->5->2->9->5->14->11->1->10->10->1->3->null
// Output Format
// 3->5->9->5->14->11->10->10->null 
// Constraints
// -10^6 <= size Of LinkedList <= 10^6
// Sample Input
// 12
// 1 5 2 9 5 14 11 1 10 10 1 3 
// Sample Output
// 3 5 9 5 14 11 10 10 
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class segregateNodeOfLinkedlistOverLastIndex {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode sp = small, lp = large, curr = head;

        ListNode pivotNode = head;
        while (pivotNode.next != null)
            pivotNode = pivotNode.next;

        while (curr != null) {
            if (curr.val <= pivotNode.val) {
                sp.next = curr;
                sp = sp.next;
            } else {
                lp.next = curr;
                lp = lp.next;
            }
            curr = curr.next;
        }

        sp.next = large.next;
        lp.next = null;

        return sp;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    } 
}

//******************Reverse Node Of Linkedlist In K Group
// 1. Given a singly linklist, reverse the nodes of a linked list k at a time and return its modified linkedlist.
// 2. If number of nodes in multiple of k then it will reverse otherwise it will add inn the end of linkedlist without any change.
// Input Format
// 1->5->2->9->5->14->11->1->10->10->1->3->null
// 2
// Output Format
// 11->14->5->9->2->5->1->10->10->1->3->null
// Constraints
// 1 <= size Of LinkedList <= 10^6
// 0 <= k <= 10^6
// Sample Input
// 12
// 1 5 2 9 5 14 11 1 10 10 1 3 
// 7
// Sample Output
// 11 14 5 9 2 5 1 1 10 10 1 3 
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class reverseNodeInALinkedListInKGroup{
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode tt = null;
    static ListNode th = null;

    public static void addFirst(ListNode node) {
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static int length(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;

        int len = length(head);

        ListNode oh = null;
        ListNode ot = null;
        ListNode curr = head;

        while (curr != null && len >= k) {
            int tempK = k;
            while (tempK-- > 0) {
                ListNode forw = curr.next;

                curr.next = null;
                addFirst(curr);

                curr = forw;
            }

            len -= k;
            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }

            th = null;
            tt = null;
        }

        ot.next = curr;
        return oh;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}
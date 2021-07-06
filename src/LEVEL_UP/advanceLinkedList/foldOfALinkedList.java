//********Fold Of Linkedlist
// Given a singly linkedlist : l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln 
// reorder it : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... 
// Input Format
// 1->2->3->4->5->6->7->null
// Output Format
// 1->7->2->6->3->5->4->null
// Constraints
// 0 <= N <= 10^6
// Sample Input
// 10
// 5
// 1
// 4
// 6
// 9
// 9
// 6
// 4
// 1
// 5
// Sample Output
// 5 5 1 1 4 4 6 6 9 9 
package LEVEL_UP.advanceLinkedList;
import java.util.*;
class foldOfALinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode forw = curr.next; // backup

            curr.next = prev; // link

            prev = curr; // move
            curr = forw;
        }

        return prev;
    }

    public static void fold(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;

        nhead = reverse(nhead);

        ListNode c1 = head, c2 = nhead;
        while (c2 != null) {
            ListNode f1 = c1.next, f2 = c2.next; // backup

            c1.next = c2; // link
            c2.next = f1;

            c1 = f1; // move
            c2 = f2;
        }
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}
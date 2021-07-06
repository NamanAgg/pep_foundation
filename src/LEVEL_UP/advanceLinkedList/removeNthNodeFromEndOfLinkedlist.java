//****************Remove Nth Node From End Of Linkedlist
// Given a singly linklist, remove the nth node from the end of the list and return its head.
// Input Format
// 1->7->2->6->3->5->4->null
// 2
// Output Format
// 1->7->2->6->3->4->null

// Constraints
// 1 <= size Of LinkedList <= 10^6
// 1 <= n <= 10^6
// Sample Input
// 9
// 18 1 16 11 15 7 9 16 4 
// 1
// Sample Output
// 18 1 16 11 15 7 9 16 
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class removeNthNodeFromEndOfLinkedlist {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0)
            return head;

        ListNode slow = head, fast = head;
        while (n-- > 0) {
            fast = fast.next;
            if (fast == null && n > 0)
                return head;
        }

        if (fast == null) {
            ListNode rnode = slow;
            head = rnode.next;
            rnode.next = null;
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode rnode = slow.next;
        slow.next = rnode.next;
        rnode.next = null;

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

        int m = scn.nextInt();
        h1 = removeNthFromEnd(h1, m);
        printList(h1);
    }
}

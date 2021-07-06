//*****************Subtract Two Linkedlist
// 1. You are give two single linkedlist of digits. 
// 2. The most significant digit comes first and each of their nodes contain a single digit. Subtract the two numbers and return it as a linked list.
// 3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// Input Format
// 1->2->3->4->5->6->7->null
// 7->8->9->null
// Output Format
// 1->2->3->3->7->7->8->null
// Constraints
// 0 <= N <= 10^6
// Sample Input
// 6
// 6 1 3 2 4 0 
// 2
// 3 5 
// Sample Output
// 6 1 3 2 0 5 

package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class subtractTwoLinkedList {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode forw = curr.next;

            curr.next = prev;

            prev = curr;
            curr = forw;
        }

        return prev;
    }

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode c1 = l1, c2 = l2, prev = dummy;
        int borrow = 0;
        while (c1 != null || c2 != null) {
            int diff = borrow + (c1 != null ? c1.val : 0) - (c2 != null ? c2.val : 0);
            if (diff < 0) {
                diff += 10;
                borrow = -1;
            } else
                borrow = 0;

            prev.next = new ListNode(diff);
            prev = prev.next;

            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        ListNode head = dummy.next;
        head = reverse(head);

        while (head != null && head.val == 0) // 1000000000 - 99999999 = 1, 999 - 999 = 0
            head = head.next;

        l1 = reverse(l1);
        l2 = reverse(l2);

        return head;
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
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = subtractTwoNumbers(head1, head2);
        printList(ans);
    }
}

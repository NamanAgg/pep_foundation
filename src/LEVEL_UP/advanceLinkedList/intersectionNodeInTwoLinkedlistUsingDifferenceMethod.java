//********************Intersection Node In Two Linkedlist Using Difference Method
// 1. Given the heads of two singly linked-lists headA and headB
// 2. Return the node at which the two lists intersect. 
// 3. If the two linked lists have no intersection, return null.

// Constraints
// 0 <= N <= 10^6
// Sample Input
// 4
// 14 12 8 7 
// 2
// 4
// 7 2 6 5 
// Sample Output
// 8
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class intersectionNodeInTwoLinkedlistUsingDifferenceMethod {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int length(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        return len;
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        ListNode biggerList = lenA > lenB ? headA : headB;
        ListNode smallerList = lenB < lenA ? headB : headA;

        int diff = Math.abs(lenA - lenB);
        while (diff-- > 0)
            biggerList = biggerList.next;

        while (biggerList != smallerList) {
            biggerList = biggerList.next;
            smallerList = smallerList.next;
        }

        return biggerList;
    }

    // Input_code===================================================

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

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}

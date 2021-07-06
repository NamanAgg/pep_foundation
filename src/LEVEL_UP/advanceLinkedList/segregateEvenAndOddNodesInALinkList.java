//**********Segregate Even And Odd Nodes In A Link List
// Given a singly linklist, modify the list such that all the even numbers appear before all the odd numbers in the modified list.
// The order of appearance of numbers within each segregation should be same as that in the original list.
// Input Format
// 1->7->2->6->3->5->4->null
// Output Format
// 2->6->4->1->7->3->5->null
// Constraints
// 0 <= N <= 10^6
// Sample Input
// 4
// 0
// 6
// 7
// 5
// Sample Output
// 0 6 7 5 

package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class segregateEvenAndOddNodesInALinkList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        ListNode ep = even, op = odd, curr = head;

        while (curr != null) {
            if (curr.val % 2 != 0) {
                op.next = curr;
                op = op.next;
            } else {
                ep.next = curr;
                ep = ep.next;
            }
            curr = curr.next;
        }

        ep.next = odd.next;
        op.next = null;
        head = even.next;

        // even.next = odd.next = null;
        return head;
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

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

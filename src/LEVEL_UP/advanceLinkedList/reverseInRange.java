//******************8Reverse In Range
// 1. Given a singly linklist, Reverse a linkedlist from position starting position to end position.
// 2. Do it in one-pass. without using any extra space.
// 3. Indexing start from numeric 1.
// Input Format
// 8->8->14->1->10->12->null 
// 3
// 5
// Output Format
// 8->8->10->1->14->12->null
// Constraints
// 1 <= size Of LinkedList <= 10^6
// 1 <= starting Position, ending Position <= 10^6
// Sample Input
// 6
// 8 8 14 1 10 12 
// 3
// 5
// Sample Output
// 8 8 10 1 14 12 
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class reverseInRange {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode th = null, tt = null;

    public static void addFirstNode(ListNode node) {
        if (th == null)
            th = tt = node;
        else {
            node.next = th;
            th = node;
        }
    }

    public static ListNode reverseInRange(ListNode head, int m, int n) {
        if (head.next == null || m == n)
            return head;
        int i = 1;
        ListNode curr = head, prev = null;
        while (curr != null) {
            while (i >= m && i <= n) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
                i++;
            }

            if (i > n) {
                if (prev == null) {
                    tt.next = curr;
                    return th;
                } else {
                    prev.next = th;
                    tt.next = curr;
                    return head;
                }
            }

            prev = curr;
            curr = curr.next;
            i++;
        }

        return null;
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    } 
}

//********Multiply Two Linkedlist
// 1. You are given two single linkedlist of digits. 
// 2. The most significant digit comes first and each of their nodes contain a single digit. 
// Multiply the two numbers and return it as a linked list.
// 3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// Input Format
// 1->2->3->4->5->null
// 7->8->9->null
// Output Format
// 9->7->4->0->2->0->6->null
// Constraints
// 0 <= N <= 10^6
// Sample Input
// 6
// 6 1 3 2 4 0 
// 2
// 3 5 
// Sample Output
// 2 1 4 6 3 4 0 0 
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class multiplyTwoLL {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int data = 0;
        Node next = null;

        Node(int val) {
            this.data = val;
        }
    }

    public static Node temphead;

    public static int reverse(Node head) {
        Node prev = null;
        Node curr = head;
        int len = 0;
        Node ahead = null;
        while (curr != null) {
            len++;
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }

        head = prev;
        temphead = head;
        return len;
    }

    public static Node makeEmptyList(int length) {
        Node head = null;
        Node traverse = null;

        while (length > 0) {

            Node temp = new Node(0);

            if (head == null) {
                head = temp;
                traverse = temp;
            } else {
                traverse.next = temp;
                traverse = traverse.next;

            }
            length--;
        }

        return head;
    }

    public static Node multiplyLL(Node head1, Node head2) {

        int m = reverse(head1);
        head1 = temphead;
        int n = reverse(head2);
        head2 = temphead;

        Node result = makeEmptyList(m + n);

        Node secondPtr = head2, resultPtr1 = result, resultPtr2, firstPtr;

        while (secondPtr != null) {
            int carry = 0;

            resultPtr2 = resultPtr1;

            firstPtr = head1;

            while (firstPtr != null) {

                int mul = firstPtr.data * secondPtr.data + carry;

                resultPtr2.data += mul % 10;

                carry = mul / 10 + resultPtr2.data / 10;
                resultPtr2.data = resultPtr2.data % 10;

                firstPtr = firstPtr.next;
                resultPtr2 = resultPtr2.next;
            }

            if (carry > 0) {
                resultPtr2.data += carry;
            }

            resultPtr1 = resultPtr1.next;
            secondPtr = secondPtr.next;

        }

        reverse(result);
        result = temphead;

        while (result.next != null && result.data == 0) {
            Node temp = result;
            result = result.next;

        }

        return result;

    }
    // InFput_code===================================================

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static Node makeList(int n) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (n-- > 0) {
            prev.next = new Node(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node head1 = makeList(scn.nextInt());
        Node head2 = makeList(scn.nextInt());

        Node ans = multiplyLL(head1, head2);
        printList(ans);
    }

}

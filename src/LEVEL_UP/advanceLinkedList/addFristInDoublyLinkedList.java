//**********Add First In Doubly Linkedlist
// 1. You are given a partially written DoublyLinkedList class.
// 2. You are required to complete the body of addFirst function. This function is supposed to add an element to the front of LinkedList. You are required to update head, tail and size as required.
// 3. Input and Output is managed for you. Just update the code in addFirst function.

// Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
//         force you but the intention is to teach a concept. Play in spirit of the question.
// Constraints
// 0 <= N <= 10^6
// Sample Input
// addFirst 10
// addFirst 20
// addFirst 30
// stop
// Sample Output
// [30, 20, 10]
package LEVEL_UP.advanceLinkedList;
import java.util.*;
public class addFristInDoublyLinkedList {
    
    public static class DoublyLinkedList {
        private class Node {
            int data = 0;
            Node prev = null;
            Node next = null;

            Node(int data) {
                this.data = data;
            }

        }

        private Node head = null;
        private Node tail = null;
        private int size = 0;

        private void addFirstNode(Node node) {
            if (this.size == 0)
                this.head = this.tail = node;
            else {
                node.next = this.head;
                this.head.prev = node;

                this.head = node;
            }
            this.size++;
        }

        public void addFirst(int data) {
            Node node = new Node(data);
            addFirstNode(node);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node curr = this.head;
            sb.append("[");
            while (curr != null) {
                sb.append(curr.data);
                if (curr.next != null)
                    sb.append(", ");
                curr = curr.next;
            }
            sb.append("]");

            return sb.toString();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        String str = scn.nextLine();
        while (!str.equals("stop")) {
            String[] s = str.split(" ");
            if (s[0].equals("addFirst"))
                dll.addFirst(Integer.parseInt(s[1]));

            str = scn.nextLine();
        }
        System.out.println(dll);
    }
}

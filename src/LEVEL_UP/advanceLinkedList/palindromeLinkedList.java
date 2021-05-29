//****************Palindrome Linkedlist
//Given a singly linked list of Integers, determine it is a palindrome or not.
//Input Format
//1->2->3->4->3->2->1->null
//1->2->3->4->2->1->null
//Output Format
//true
//false
//Constraints
//0 <= N <= 10^6
//Sample Input
//10
//5
//1
//4
//6
//9
//9
//6
//4
//1
//5
//Sample Output
//true
package LEVEL_UP.advanceLinkedList;
import java.util.*;
import java.io.*;
public class palindromeLinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    } 

    public static ListNode reverse(ListNode head) {
      if(head==null||head.next==null) return head;
      
      ListNode prev=null;
      ListNode curr=head;
      while(curr!=null){
          ListNode fwd=curr.next;
          curr.next=prev;
          prev=curr;
          curr=fwd;
      }
        return prev;
    }
    
    public static ListNode midNode(ListNode head) {
        if(head==null||head.next==null) return head;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null&&fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        
    }    
    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        
        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;

        nhead = reverse(nhead);

        ListNode c1 = head, c2 = nhead;

        boolean res = true;
        while (c2 != null) {
            if (c1.val != c2.val) {
                res = false;
                break;
            }

            c1 = c1.next;
            c2 = c2.next;
        }

        nhead = reverse(nhead);
        mid.next = nhead;

        return res;
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

        System.out.println(isPalindrome(dummy.next));
    }	
}

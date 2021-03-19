package linkedlistClass;

import linkedlistClass.mergeSortLinkedList.LinkedList;
import linkedlistClass.mergeSortLinkedList.Node;

public class questions {
	Node head=null;
	Node tail=null;
	public int mid(){
	      // write your code here
	      
	      Node fast=this.head;
	      Node slow=this.head;
	      while(fast.next!=null&&fast.next.next!=null){
	          slow=slow.next;
	          fast=fast.next.next;
	      }
	      return slow.data;
	    }
	 
	   public void reversePI(){
		      // write your code here
		      Node curr=this.head;
		      Node prev=null;
		      while(curr!=null){
		          Node fwd=curr.next;  //backup
		          
		          curr.next=prev;  //link
		          
		          prev=curr;  //move
		          curr=fwd;
		      }
		      tail=head;
		      head=prev;
		    }
	   private void reversePRHelper(Node node){
		      // write your code here
		      if(node.next==null){
		         Node temp=head;
		         head=tail;
		         tail=temp;
		         return;
		      }
		      reversePRHelper(node.next);
		      Node temp=node.next;
		      temp.next=node;
		      node.next=null;
		    }

		    public void reversePR(){
		      // write your code here
		      reversePRHelper(this.head);
		      tail.next=null;
		    }
		    
		    public static  LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
			      LinkedList ml = new LinkedList();

			      Node one = l1.head;
			      Node two = l2.head;
			      while (one != null && two != null) {
			        if (one.data < two.data) {
			          ml.addLast(one.data);
			          one = one.next;
			        } else {
			          ml.addLast(two.data);
			          two = two.next;
			        }
			      }

			      while (one != null) {
			        ml.addLast(one.data);
			        one = one.next;
			      }

			      while (two != null) {
			        ml.addLast(two.data);
			        two = two.next;
			      }

			      return ml;
			    }

			    public static  LinkedList mergeSort(Node head, Node tail){
				      // write your code here
				      if(head.next==null){
				          LinkedList list=new LinkedList();
				          list.addLast(head.data);
				          return list;
				      }
				      Node mid=mid(head);
				      Node head1=head;
				      Node tail1=mid;
				      Node head2=mid.next;
				      Node tail2=tail;
				      
				      mid.next=null;
				      
				      LinkedList recAns1=mergeSort(head1,tail1);
				      LinkedList recAns2=mergeSort(head2,tail2);
				      
				      return mergeTwoSortedLists(recAns1,recAns2);	      
				    }
			    
			    public static Node mid(Node head) {
				      Node f = head;
				      Node s = head;

				      while (f.next != null && f.next.next != null) {
				        f = f.next.next;
				        s = s.next;
				      }

				      return s;
				    }
			    
}

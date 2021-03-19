package linkedlistClass;

public class llClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		linkedlist list=new linkedlist();
		list.addFirst(5);
		list.display();
//		list.addLast(10);
//		list.display();
		list.addFirst(15);
		list.display();
//		list.addLast(20);
//		list.display();
		list.removeFirst();
		//System.out.println(list.getFirst());
		list.display();
	}

}

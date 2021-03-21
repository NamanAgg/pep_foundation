package StacksAndQueues.Adapters;
import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueue_pop {
	Queue<Integer> que = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();

    public int size() {
        return que.size();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    private void transferToAnotherQueue() {
    	while(que.size()!=0) {
    		temp.add(que.remove());
    	}
    	
    	que=temp;
    	temp=new LinkedList<>();
    }

    // O(n)
    public void push(int data) {
       temp.add(data);
       transferToAnotherQueue();
    }

    // O(1)
    public int peek() {
        return que.peek();
    }

    // O(1)
    public int pop() {
        return que.remove();
       
    }
}

package StacksAndQueues.Adapters;
import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueue_push {
    Queue<Integer> que = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();
     private int peekVal=0;

    public int size() {
        return que.size();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    private void transferToAnotherQueue() {
    	while(que.size()>1) {
    		temp.add(que.remove());
    	}
    }

    // O(1)
    public void push(int data) {
    	this.peekVal=data;
    	que.add(data);
    }

    // O(1)
    public int peek() {
    	return peekVal;
    }

    // O(n)
    public int pop() {
    	transferToAnotherQueue();
    	int popVal=que.remove();
    	while(temp.size()!=0) {
    		this.push(temp.remove());
    	}
    	return popVal;
    }
}

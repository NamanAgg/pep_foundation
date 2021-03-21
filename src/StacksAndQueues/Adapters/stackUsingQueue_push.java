package StacksAndQueues.Adapters;
import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueue_push {
    Queue<Integer> que = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();
     private int peekVal=0;

    public int size() {
        return this.que.size();
    }

    public boolean isEmpty() {
        return this.que.isEmpty();
    }

    private void transferToAnotherQueue() {
    	while(this.que.size()>1) {
    		this.temp.add(que.remove());
    	}
    }

    // O(1)
    public void push(int data) {
    	this.peekVal=data;
    	this.que.add(data);
    }

    // O(1)
    public int peek() {
    	return this.peekVal;
    }

    // O(n)
    public int pop() {
    	transferToAnotherQueue();
    	int popVal=this.que.remove();
    	while(this.temp.size()!=0) {
    		this.push(this.temp.remove());
    	}
    	return popVal;
    }
}

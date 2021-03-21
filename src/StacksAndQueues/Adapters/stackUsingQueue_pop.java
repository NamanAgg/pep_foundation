package StacksAndQueues.Adapters;
import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueue_pop {
	Queue<Integer> que = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();

    public int size() {
        return this.que.size();
    }

    public boolean isEmpty() {
        return this.que.isEmpty();
    }

    private void transferToAnotherQueue() {
    	while(this.que.size()!=0) {
    		this.temp.add(this.que.remove());
    	}
    	
    	this.que=this.temp;
    	this.temp=new LinkedList<>();
    }

    // O(n)
    public void push(int data) {
       this.temp.add(data);
       this.transferToAnotherQueue();
    }

    // O(1)
    public int peek() {
        return this.que.peek();
    }
    
    
    

    // O(1)
    public int pop() {
        return this.que.remove();
       
    }
}

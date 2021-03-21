package StacksAndQueues.Adapters;

public class client {
	 public static void main(String[] args) {
	      //  queueUsingStack_pop que = new queueUsingStack_pop();
		 //stackUsingQueue_push st=new stackUsingQueue_push();
		 stackUsingQueue_pop st=new stackUsingQueue_pop();
	        for (int i = 1; i <= 10; i++) {
	            //que.add(i * 10);
	        	st.push(i*10);
	        }

//	        while (que.size() != 0) {
//	            System.out.println(que.remove());
//	        }
	        
	        while(st.size()!=0) {
	        	System.out.println(st.pop());
	        }
	    }
}

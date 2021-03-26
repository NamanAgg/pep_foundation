//****************Balanced Brackets
//1. You are given a string exp representing an expression.
//2. You are required to check if the expression is balanced i.e. 
//   closing brackets and opening brackets match up well.
//e.g.
//[(a + b) + {(c + d) * (e / f)}] -> true
//[(a + b) + {(c + d) * (e / f)]} -> false
//[(a + b) + {(c + d) * (e / f)} -> false
//([(a + b) + {(c + d) * (e / f)}] -> false
//Input Format
//A string str
//Output Format
//true or false
//Constraints
//0 <= str.length <= 100
//Sample Input
//[(a + b) + {(c + d) * (e / f)}]
//Sample Output
//true
package StacksAndQueues;
import java.util.*;
import java.io.*;
public class isBalancedBrackets {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=scn.nextLine();
		System.out.println(isBalanced(str));
	}
	
	public static boolean isBalanced(String str) {
	    Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (st.size() == 0)
                    return false; // more closing brackets
                else if (ch == ')' && st.peek() != '(')
                    return false;
                else if (ch == '}' && st.peek() != '{')
                    return false;
                else if (ch == ']' && st.peek() != '[')
                    return false;
                else
                    st.pop();
            }
        }

        return st.size() == 0;
		
	}

}

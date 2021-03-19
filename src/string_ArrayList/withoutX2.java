package string_ArrayList;
//Given a string, if one or both of the first 2 chars is 'x', return the string without those 'x' chars, 
//and otherwise return the string unchanged. This is a little harder than it looks.
//
//withoutX2("xHi") = "Hi"
//withoutX2("Hxi") = "Hi"
//withoutX2("Hi") = "Hi"
import java.util.*;
public class withoutX2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String str=s.next();
		
		System.out.println(WithoutX2(str));
		
	}
	public static  String WithoutX2(String str) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++) {
			if(i<2&&str.charAt(i)=='x') {
				
			}
			else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

}

//***********All Palindromic Partitions
// 1. You are given a string of length n.
// 2. You have to partition the given string in such a way that every partition is a palindrome.
// Input Format
// A String of length n
// Output Format
// Check the sample ouput and question video.

// Constraints
// 1 <= length of string <= 15
// Sample Input
// pep
// Sample Output
// (p) (e) (p) 
// (pep) 
package LEVEL_UP.advanceRecursion;
import java.util.*;
public class allPalindromicPartitions {
    public static boolean isPlaindrome(String str) {
        int si = 0, ei = str.length() - 1;
        while (si <= ei) {
            if (str.charAt(si++) != str.charAt(ei--))
                return false;
        }

        return true;
    }

    public static void allPalindromicPartitions(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String smallStr = str.substring(0, i + 1);
            if (isPlaindrome(smallStr)) {
                allPalindromicPartitions(str.substring(i + 1), asf + "(" + smallStr + ") ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        allPalindromicPartitions(str, "");
    }
}

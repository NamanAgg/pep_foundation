//***************Largest Number Possible After At Most K Swaps
// 1. You are given a string which represents digits of a number.
// 2. You have to create the maximum number by performing at-most k swap operations on its digits.
// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A string S and a number K
// Output Format
// A number
// Constraints
// 1 <= length of S <= 30
// 1 <= K <= 10
// Sample Input
// 1234567
// 4
// Sample Output
// 7654321
package LEVEL_UP.advanceRecursion;
import java.io.*;
import java.util.*;
public class largestNumberPossibleAfterAtMostKSwaps {
    static String max;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        max = str;
        findMaximum(str, k);
        System.out.println(max);
    }

    public static void findMaximum(String str, int k) {
        if (k == 0) {
            return;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) < str.charAt(j)) {
                    str = swap(str, i, j);

                    if (Integer.parseInt(str) > Integer.parseInt(max)) {
                        max = str;
                    }

                    findMaximum(str, k - 1);
                    str = swap(str, i, j);
                }
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);

        String left = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String right = str.substring(j + 1);

        return left + jth + middle + ith + right;
    }    
}

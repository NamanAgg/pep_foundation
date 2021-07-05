//**************Abbreviation Using Backtracking
// 1. You are given a word.
// 2. You have to generate all abbrevations of that word.

// Input Format
// A string representing a word
// Output Format
// Check the sample ouput and question video.
// Constraints
// 1 <= length of string <= 32
// Sample Input
// pep
package LEVEL_UP.advanceRecursion;
import java.util.*;
public class abbreviationUsingBacktracking {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        abbreviation(str, "", 0, 0);
    }

    public static void abbreviation(String str, String asf, int idx, int count) {
        if (idx == str.length()) {
            if (count > 0) {
                asf += count;
            }
            System.out.println(asf);
            return;
        }
        abbreviation(str, asf + (count > 0 ? count : "") + str.charAt(idx), idx + 1, 0); // including
        abbreviation(str, asf, idx + 1, count + 1); // not including
    }
}

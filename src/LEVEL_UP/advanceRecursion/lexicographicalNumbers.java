//*************Lexicographical Numbers
// 1. You are given a number.
// 2. You have to print all the numbers from 1 to n in lexicographical order.
// Input Format
// A number
// Output Format
// Check the sample output and question video
// Constraints
// 1 <= n <= 50000
// Sample Input
// 14
// Sample Output
// 1
// 10
// 11
// 12
// 13
// 14
// 2
package LEVEL_UP.advanceRecursion;
import java.util.*;
public class lexicographicalNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i < 10; i++) {
            dfs(i, n);
        }
    }

    public static void dfs(int cur, int n) {
        if (cur > n) {
            return;
        } else {
            System.out.println(cur);
            for (int i = 0; i < 10; i++) {
                dfs(10 * cur + i, n);
            }
        }
    }
}

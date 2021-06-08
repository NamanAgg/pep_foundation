//****************Friends Pairing
// 1. You are given a number n, representing the number of friends.
// 2. Each friend can stay single or pair up with any of it's friends.
// 3. You are required to print the number of ways in which these friends can stay single or pair up.
// E.g.
// 1 person can stay single or pair up in 1 way.
// 2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.
// 3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.
// Input Format
// A number n
// Output Format
// A number representing the number of ways in which n friends can stay single or pair up.
// Constraints
// 0 <= n <= 20
// Sample Input
// 4
// Sample Output
// 10
package DP;
import java.util.*;
import java.io.*;
public class friendsPairing {
        public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n + 1];

        System.out.println(friendsPairing_dp(n, dp));
        // System.out.println(frindsPairing_Opti(n));

    }

    public static int friendsPairing_dp(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            int single = dp[n - 1];// friendsPairing_memo(n - 1, dp);
            int pairup = dp[n - 2] * (n - 1);// friendsPairing_memo(n - 2, dp) * (n - 1);

            dp[n] = single + pairup;
        }
        return dp[N];
    }

    public static int frindsPairing_Opti(int n) {
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = b + a * (i - 1);
            a = b;
            b = sum;
        }

        return b;
    }
    
}

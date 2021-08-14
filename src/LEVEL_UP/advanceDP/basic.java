
//package LEVEL_UP.advanceDP;
// 1. Faith
// 2. Recursive Tree 
// 3. Recursion Code 
// 4. Convert Recursion code into memoization 
// 5. Observation 
// 6. Tabulation 
// 7. Optimization
import java.util.Arrays;
import java.util.LinkedList;

public class basic {
    public static void display(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] arr) {
        for (int[] ar : arr) {
            display(ar);
        }
        System.out.println();
    }

    // F(n) = F(n - 1) + F(n - 2)
    public static int fibo_memo(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = n;
        }

        if (dp[n] != 0)
            return dp[n];

        int ans = fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
        return dp[n] = ans;
    }

    public static int fibo_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];// fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
            dp[n] = ans;
        }

        return dp[N];
    }

    public static int fibo_opti(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void fibo_Set() {
        int n = 5;
        int[] dp = new int[n + 1];
        // System.out.println(fibo_memo(n, dp));
        // System.out.println(fibo_tabu(n, dp));
        System.out.println(fibo_opti(n));

        display(dp);
    }

    public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] dir, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += mazePath_memo(r, c, er, ec, dir, dp);
            }
        }

        return dp[sr][sc] = count;
    }

    public static int mazePath_DP(int SR, int SC, int er, int ec, int[][] dir, int[][] dp) {

        for (int sr = er; sr >= 0; sr--) {
            for (int sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                        count += dp[r][c];// mazePath_memo(r, c, er, ec, dir, dp);
                    }
                }

                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    public static void mazePath_Set() {
        int n = 4;
        int[][] dp = new int[n][n];
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
        // System.out.println(mazePath_memo(0, 0, n-1, n-1, dir, dp));
        System.out.println(mazePath_DP(0, 0, n - 1, n - 1, dir, dp));
        display2D(dp);

    }

    public static int mazePathJump_memo(int sr, int sc, int er, int ec, int[][] dir, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= er; rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];
                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    count += mazePathJump_memo(r, c, er, ec, dir, dp);
                } else
                    break;
            }
        }

        return dp[sr][sc] = count;
    }

    public static int mazePathJump_DP(int SR, int SC, int er, int ec, int[][] dir, int[][] dp) {

        for (int sr = er; sr >= 0; sr--) {
            for (int sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    for (int rad = 1; rad <= Math.max(er, ec); rad++) {
                        int r = sr + rad * dir[d][0];
                        int c = sc + rad * dir[d][1];
                        if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                            count += dp[r][c];// mazePathJump_memo(r, c, er, ec, dir, dp);
                        } else
                            break;
                    }
                }

                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    public static int maxGold() {
        int n = 4, m = 4;
        int[][] M = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
        return maxGold(n, m, M);
    }

    public static int maxGold(int n, int m, int arr[][]) {
        int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
        int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        // int maxGold = 0;
        // for (int i = 0; i < n; i++) {
        // maxGold = Math.max(maxGold, goldMine_memo(arr, i, 0, dp, dir));
        // }
        // return maxGold;
        return goldMine_dp(arr, n - 1, m - 1, dp, dir);

    }

    public static int goldMine_memo(int[][] arr, int r, int c, int[][] dp, int[][] dir) {
        if (c == arr[0].length - 1) {
            return dp[r][c] = arr[r][c];
        }

        if (dp[r][c] != -1)
            return dp[r][c];

        int maxGold = 0;
        for (int d = 0; d < dir.length; d++) {
            int x = r + dir[d][0];
            int y = c + dir[d][1];

            if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length)
                maxGold = Math.max(maxGold, goldMine_memo(arr, x, y, dp, dir) + arr[r][c]);
        }

        return dp[r][c] = maxGold;
    }

    public static int goldMine_dp(int[][] arr, int R, int C, int[][] dp, int[][] dir) {
        for (int c = C; c >= 0; c--) {
            for (int r = R; r >= 0; r--) {
                if (c == arr[0].length - 1) {
                    dp[r][c] = arr[r][c];
                    continue;
                }

                int maxGold = 0;
                for (int d = 0; d < dir.length; d++) {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];

                    if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length)
                        maxGold = Math.max(maxGold, dp[x][y] + arr[r][c]);
                }
                dp[r][c] = maxGold;
            }
        }

        int maxGold = 0;
        for (int i = 0; i <= R; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }
        return maxGold;
    }

    public static int getMaximumGold(int[][] grid) {

        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int res = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] != 0)
                    res = Math.max(res, dfs(i, j, grid, vis, dir));

        return res;
    }

    public static int dfs(int sr, int sc, int[][] grid, boolean[][] vis, int[][] dir) {
        if (grid[sr][sc] == 0)
            return 0;

        vis[sr][sc] = true;
        int res = 0;
        for (int i = 0; i < dir.length; i++) {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];

            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && !vis[r][c] && grid[r][c] != 0)
                res = Math.max(res, dfs(r, c, grid, vis, dir));
        }
        res += grid[sr][sc];
        vis[sr][sc] = false;
        return res;
    }

    // 746

    public int minCost_memo(int n, int[] cost, int[] dp) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }

        if (dp[n] != 0)
            return dp[n];

        int minCost = Math.min(minCost_memo(n - 1, cost, dp), minCost_memo(n - 2, cost, dp));

        return dp[n] = minCost + (n == cost.length ? 0 : cost[n]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        return minCost_memo(n, cost, dp);
    }

    // board Path
    public static int boardPath_memo(int sp, int ep, int[] dp) {
        if (sp == ep) {
            return dp[sp] = 1;
        }
        if (dp[sp] != 0)
            return dp[sp];

        int count = 0;
        for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++) {
            count += boardPath_memo(sp + dice, ep, dp);
        }

        return dp[sp] = count;
    }

    public static int boardPath_tabu(int SP, int ep, int[] dp) {
        for (int sp = ep; sp >= SP; sp--) {
            if (sp == ep) {
                dp[sp] = 1;
                continue;
            }

            int count = 0;
            for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++) {
                count += dp[sp + dice];// boardPath_memo(sp + dice, ep, dp);
            }
            dp[sp] = count;
        }

        return dp[SP];
    }

    public int boradPath_Opti(int n) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addLast(1);
        ll.addLast(1);
        for (int i = 2; i <= n; i++) {
            if (ll.size() <= 6)
                ll.addLast(ll.getLast() * 2);
            else
                ll.addLast(ll.getLast() * 2 - ll.removeFirst());
        }

        return ll.getLast();
    }

    public static void board_path() {
        int sp = 0, ep = 20;
        int[] dp = new int[ep + 1];
        System.out.println(boardPath_tabu(sp, ep, dp));
        display(dp);
    }

    public int numDecodings_memo(String s, int n, int[] dp) {
        if (n == 0) {
            return dp[n] = 1;
        }

        if (dp[n - 1] != -1)
            return dp[n];

        int count = 0;
        if (s.charAt(n - 1) > '0')
            count += numDecodings_memo(s, n - 1, dp);

        if (n > 1) {
            int num = (s.charAt(n - 2) - '0') * 10 + (s.charAt(n - 1) - '0');
            if (num <= 26 && num >= 10)
                count += numDecodings_memo(s, n - 2, dp);
        }

        return dp[n] = count;
    }

    public int numDecodings_memo2(String s, int idx, int[] dp) {
        if (idx == s.length()) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];

        if (s.charAt(idx) == '0') {
            return dp[idx] = 0;
        }

        int count = 0;
        count += numDecodings_memo2(s, idx + 1, dp);

        if (idx < s.length() - 1) {
            int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
            if (num <= 26)
                count += numDecodings_memo2(s, idx + 2, dp);
        }

        return dp[idx] = count;
    }

    public int numDecodings_tabu(String s, int IDX, int[] dp) {
        for (int idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }

            if (s.charAt(idx) == '0') {
                dp[idx] = 0;
                continue;
            }

            int count = 0;
            count += dp[idx + 1];

            if (idx < s.length() - 1) {
                int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
                if (num <= 26)
                    count += dp[idx + 2];
            }

            dp[idx] = count;
        }

        return dp[IDX];
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // int ans = numDecodings_memo(s,n,dp);
        int ans = numDecodings_memo2(s, 0, dp);

        for (int ele : dp)
            System.out.print(ele + " ");
        return ans;
    }

    // ============================================================
    public long numDecodingsStar(String s, int idx, long[] dp) {
        if (idx == s.length()) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];

        if (s.charAt(idx) == '0') {
            return dp[idx] = 0;
        }

        long count = 0;
        int mod = (int) 1e9 + 7;
        char ch1 = s.charAt(idx);
        if (ch1 == '*') {
            count = (count + 9 * numDecodingsStar(s, idx + 1, dp)) % mod;

            if (idx < s.length() - 1) {
                if (s.charAt(idx + 1) == '*')
                    count = (count + 15 * numDecodingsStar(s, idx + 2, dp)) % mod;
                else if (s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '6')
                    count = (count + 2 * numDecodingsStar(s, idx + 2, dp)) % mod;
                else if (s.charAt(idx + 1) >= '7')
                    count = (count + numDecodingsStar(s, idx + 2, dp)) % mod;
            }
        } else {
            count = (count + numDecodingsStar(s, idx + 1, dp)) % mod;

            if (idx < s.length() - 1) {
                if (s.charAt(idx + 1) != '*') {
                    int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
                    if (num <= 26)
                        count = (count + 1 * numDecodingsStar(s, idx + 2, dp)) % mod;
                } else {
                    if (ch1 == '1')
                        count = (count + 9 * numDecodingsStar(s, idx + 2, dp)) % mod;
                    else if (ch1 == '2')
                        count = (count + 6 * numDecodingsStar(s, idx + 2, dp)) % mod;
                }
            }
        }

        return dp[idx] = count;
    }

    public long numDecodingsStar_tabu(String s, int IDX, long[] dp) {
        for (int idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }

            if (s.charAt(idx) == '0') {
                dp[idx] = 0;
                continue;
            }

            long count = 0;
            int mod = (int) 1e9 + 7;
            char ch1 = s.charAt(idx);
            if (ch1 == '*') {
                count = (count + 9 * dp[idx + 1]) % mod;

                if (idx < s.length() - 1) {
                    if (s.charAt(idx + 1) == '*')
                        count = (count + 15 * dp[idx + 2]) % mod;
                    else if (s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '6')
                        count = (count + 2 * dp[idx + 2]) % mod;
                    else if (s.charAt(idx + 1) >= '7')
                        count = (count + dp[idx + 2]) % mod;
                }
            } else {
                count = (count + dp[idx + 1]) % mod;

                if (idx < s.length() - 1) {
                    if (s.charAt(idx + 1) != '*') {
                        int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
                        if (num <= 26)
                            count = (count + 1 * dp[idx + 2]) % mod;
                    } else {
                        if (ch1 == '1')
                            count = (count + 9 * dp[idx + 2]) % mod;
                        else if (ch1 == '2')
                            count = (count + 6 * dp[idx + 2]) % mod;
                    }
                }
            }

            dp[idx] = count;
        }

        return dp[IDX];
    }

    public int numDecodingsStar(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        long ans = numDecodingsStar_tabu(s, 0, dp);

        // for (int ele : dp)
        // System.out.print(ele + " ");
        return (int) ans;
    }

    // https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1

    public static long friendsPairing(int n, long[] dp) {
        if (n <= 1) {
            return dp[n] = 1;
        }
        if (dp[n] != 0)
            return dp[n];

        int mod = (int) 1e9 + 7;
        long single = friendsPairing(n - 1, dp);
        long pairup = friendsPairing(n - 2, dp) * (n - 1);

        return dp[n] = (single + pairup % mod) % mod;
    }

    public static long friendsPairing_tabu(int N, long[] dp) {
        int mod = (int) 1e9 + 7;
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            long single = dp[n - 1];
            long pairup = dp[n - 2] * (n - 1);

            dp[n] = (single + pairup % mod) % mod;
        }

        return dp[N];
    }

    public long countFriendsPairings(int n) {
        long[] dp = new long[n + 1];
        return friendsPairing_tabu(n, dp);
    }

    // https://www.geeksforgeeks.org/count-the-number-of-ways-to-divide-n-in-k-groups-incrementally/

    public static int divideInKGroup(int n, int k, int[][] dp) {
        if (k == 1 || n == k) {
            return dp[n][k] = 1;
        }

        if (dp[n][k] != -1)
            return dp[n][k];

        int selfSet = divideInKGroup(n - 1, k - 1, dp);
        int partOfAnotherSet = divideInKGroup(n - 1, k, dp) * k;

        return dp[n][k] = selfSet + partOfAnotherSet;
    }

    public static int divideInKGroup_tabu(int N, int K, int[][] dp) {
        for (int k = 0; k <= K; k++)
            for (int n = 0; n <= N; n++) {
                if (k == 1 || n == k) {
                    dp[n][k] = 1;
                    continue;
                }
                int selfSet = dp[n - 1][k - 1];
                int partOfAnotherSet = dp[n - 1][k] * k;

                dp[n][k] = selfSet + partOfAnotherSet;
            }

            return dp[N][K];
    }

    public static void divideInKgroup() {
        int n = 5, k = 3;
        int[][] dp = new int[n + 1][k + 1];
        System.out.println(divideInKGroup(n, k, dp));

    }

    public static void main(String[] args) {
        // fibo_Set();
        // mazePath_Set();
        // maxGold();
        // int[][] grid = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
        // System.out.println(getMaximumGold(grid));
        divideInKgroup();
    }

}

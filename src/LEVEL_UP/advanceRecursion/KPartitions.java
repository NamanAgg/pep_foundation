//*********K-partitions
// 1. You are given two integers n and k, where n represents number of elements and k represents 
//      number of subsets.
// 2. You have to partition n elements in k subsets and print all such configurations.
// Note -> Check out the question video and write the recursive code as it is intended without 
//         changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A number n
// A number k
// Output Format
// Check the sample ouput and question video.
//Constraints
// 1 <= n <= 10
// 1 <= k <= 10
// Sample Input
// 3
// 2
// Sample Output
// 1. [1, 2] [3] 
// 2. [1, 3] [2] 
// 3. [1] [2, 3] 

package LEVEL_UP.advanceRecursion;
import java.io.*;
import java.util.*;
public class KPartitions {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(1, n, k, 0, ans);

    }

    static int counter = 1;

    public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
        if (i == n + 1) {
            if (rssf == k) {
                System.out.print(counter + ". ");
                counter++;
                for (ArrayList<Integer> a : ans) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j).size() == 0) {
                ans.get(j).add(i);
                solution(i + 1, n, k, rssf + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            } else {
                ans.get(j).add(i);
                solution(i + 1, n, k, rssf, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            }
        }

    }

}
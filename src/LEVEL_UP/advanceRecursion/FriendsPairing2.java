//*********Friends Pairing - 2
// 1. You are given an integer n, which represents n friends numbered from 1 to n.
// 2. Each one can remain single or can pair up with some other friend.
// 3. You have to print all the configurations in which friends can remain single or can be paired up.
// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A number n
// Output Format
// Check the sample ouput and question video.
// Constraints
// 1 <= n <= 10
// Sample Input
// 3
// Sample Output
// 1.(1) (2) (3) 
// 2.(1) (2,3) 
// 3.(1,2) (3) 
// 4.(1,3) (2) 
package LEVEL_UP.advanceRecursion;
import java.util.Scanner;
public class FriendsPairing2 {
    static int counter = 1;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] used = new boolean[n + 1];
        friendsPairing(n, used, "");
    }

    public static int friendsPairing(int totalFriends, boolean[] vis, String asf) {
        if (totalFriends == 0) {
            System.out.println(counter++ + "." + asf);
            return 1;
        }

        int firstUnusedFriend = 0;
        for (int i = 1; i < vis.length; i++) {
            if (!vis[i]) {
                firstUnusedFriend = i;
                break;
            }
        }

        int count = 0;
        vis[firstUnusedFriend] = true;

        count += friendsPairing(totalFriends - 1, vis, asf + "(" + firstUnusedFriend + ") "); // single

        for (int i = firstUnusedFriend + 1; i < vis.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                count += friendsPairing(totalFriends - 2, vis, asf + "(" + firstUnusedFriend + "," + i + ") "); // pairup
                vis[i] = false;
            }

        }

        vis[firstUnusedFriend] = false;

        return count;
    }
  
}

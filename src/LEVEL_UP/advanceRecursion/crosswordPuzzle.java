//**********Crossword Puzzle
// 1. You are given a 10*10 2-D array(arr) containing only '+' and '-' characters, which represents a 
//     crossword puzzle. 
// 2. You are also given n number of words which need to be filled into the crossword.
// 3. Cells containing '-' are to be filled with the given words.
// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// 10 * 10 grid of characters containing only '+' and '-' 
// A number n
// str1
// str2
// ...n strings
// Output Format
// Check the sample output and question video
//   COMMENTConstraints
// 1 <= n <= 10
// Sample Input
// +-++++++++
// +-++++++++
// +-++++++++
// +-----++++
// +-+++-++++
// +-+++-++++
// +++++-++++
// ++------++
// +++++-++++
// +++++-++++
// 4
// LONDON
// DELHI 
// ICELAND 
// ANKARA
// Sample Output
// +L++++++++
// +O++++++++
// +N++++++++
// +DELHI++++
// +O+++C++++
// +N+++E++++
// +++++L++++
// ++ANKARA++
// +++++N++++
// +++++D++++
package LEVEL_UP.advanceRecursion;
import java.util.*;
public class crosswordPuzzle {
 
    public static boolean isSafeToPlaceH(char[][] box, String word, int r, int c) {

        for (int i = 0; i < word.length(); i++) {
            if (c + i >= box[0].length)
                return false;
            if (box[r][c + i] != '-' && box[r][c + i] != word.charAt(i))
                return false;
        }
        return true;
    }

    public static boolean[] placeH(char[][] box, String word, int r, int c) {
        boolean[] loc = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (box[r][c + i] == '-') {
                box[r][c + i] = word.charAt(i);
                loc[i] = true;
            }
        }
        return loc;
    }

    public static void unPlaceH(char[][] box, String word, int r, int c, boolean[] loc) {
        for (int i = 0; i < word.length(); i++) {
            if (loc[i]) {
                box[r][c + i] = '-';
            }
        }
    }

    public static boolean isSafeToPlaceV(char[][] box, String word, int r, int c) {
        for (int i = 0; i < word.length(); i++) {
            if (r + i == box.length)
                return false;
            if (box[r + i][c] != '-' && box[r + i][c] != word.charAt(i))
                return false;
        }
        return true;
    }

    public static boolean[] placeV(char[][] box, String word, int r, int c) {
        boolean[] loc = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (box[r + i][c] == '-') {
                box[r + i][c] = word.charAt(i);
                loc[i] = true;
            }
        }
        return loc;
    }

    public static void unPlaceV(char[][] box, String word, int r, int c, boolean[] loc) {
        for (int i = 0; i < word.length(); i++) {
            if (loc[i]) {
                box[r + i][c] = '-';
            }
        }
    }

    public static int crossWord(char[][] box, String[] words, int idx) {
        if (idx == words.length) {
            print(box);
            return 1;
        }

        String word = words[idx];
        int n = box.length, m = box[0].length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == '-' || box[i][j] == word.charAt(0)) {
                    if (isSafeToPlaceH(box, word, i, j)) {
                        boolean[] loc = placeH(box, word, i, j);
                        count += crossWord(box, words, idx + 1);
                        unPlaceH(box, word, i, j, loc);
                    }

                    if (isSafeToPlaceV(box, word, i, j)) {
                        boolean[] loc = placeV(box, word, i, j);
                        count += crossWord(box, words, idx + 1);
                        unPlaceV(box, word, i, j, loc);
                    }

                }

            }
        }

        return count;
    }

    public static void print(char[][] box) {
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                System.out.print(box[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] box = new char[10][10];
        for (int i = 0; i < box.length; i++) {
            String str = scn.next();
            box[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }

        crossWord(box, words, 0);
    }
}

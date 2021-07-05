//***************Word Break - I
// 1. You are given n space separated strings, which represents a dictionary of words.
// 2. You are given another string which represents a sentence.
// 3. You have to print all possible sentences from the string, such that words of the sentence are 
//      present in dictionary.

// Input Format
// A number n 
// n strings representing words
// a string representing a sentence
// Output Format
// Check the sample ouput and question video.

// Constraints
// 1 <= number of words <= 10
// 1 <= length of each word <= 15
// 1 <= length of sentence <= 1000

// Sample Input
// 11
// i like pep coding pepper eating mango man go in pepcoding
// ilikepeppereatingmangoinpepcoding
// Sample Output
// i like pepper eating man go in pep coding 
// i like pepper eating man go in pepcoding 
// i like pepper eating mango in pep coding 
// i like pepper eating mango in pepcoding 
package LEVEL_UP.advanceRecursion;
import java.util.*;
public class wordBreak1 {
    public static int wordBreak(String str, int idx, String ans, int len, HashSet<String> dict) {
        if (idx >= str.length()) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = idx; i <= str.length(); i++) {
            String word = str.substring(idx, i);
            if (word.length() > len)
                break;
            if (dict.contains(word)) {
                count += wordBreak(str, i, ans + word + " ", len, dict);
            }
        }
        return count;
    }

    public static void wordBreak(String str, String ans, HashSet<String> dict) {
        int len = 0;
        for (String s : dict)
            len = Math.max(len, s.length());
        wordBreak(str, 0, ans, len, dict);
    }
}

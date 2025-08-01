// Time Complexity : O(n), n - len of string
// Space Complexity : O(n), n - length of word string, as we store the words separated by space in hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use 2 hashmaps
//      one to store the mapping from char in the pattern string to word
//      and other to store the mapping from word to character in the pattern string
// 2. While iterating through characters in the pattern string, check the hashmap and if there is mismatch in the word
//      in hash map and the current word, return false
// 3. Repeat the same for other hash map

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    private static boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternWordMap = new HashMap<>();
        Map<String, Character> wordCharMap = new HashMap<>();
        String[] words = s.split(" ");

        if(pattern.length() != words.length) {
            return false;
        }

        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            // check patternWord Map
            if(patternWordMap.containsKey(ch)) {
                if(!words[i].equals(patternWordMap.get(ch))) {
                    return false;
                }
            } else {
                patternWordMap.put(ch, words[i]);
            }

            // check wordChar map
            if(wordCharMap.containsKey(words[i])) {
                if(wordCharMap.get(words[i]) != ch) {
                    return false;
                }
            } else {
                wordCharMap.put(words[i], ch);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); //true
        System.out.println(wordPattern("abba", "dog dog dog dog")); //false
        System.out.println(wordPattern("aaa", "dog dog dog dog")); //false
    }
}

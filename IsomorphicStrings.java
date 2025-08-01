// Time Complexity : O(n), n - len of string
// Space Complexity : O(1), since valid ascii chars are finite, size cannot exceed 128
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use hashmap to store the char mapping from s to t
// 2. If there is discrepancy, i.e hashmap value is not equal to the char in t, return false
// 3. Repeat the same for t to s.
// 4. Strings are isomorphic iff t -> s and s -> t returns true

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    private static boolean helper(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            if(charMap.containsKey(sChar)) {
                if(charMap.get(sChar) != t.charAt(i)) {
                    return false;
                }
            } else {
                charMap.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    private static boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("tenn", "abcc")); //true
        System.out.println(isIsomorphic("tenn", "abcd")); //false
    }
}

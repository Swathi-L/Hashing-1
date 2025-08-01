// Time Complexity : O(n * k log k), k -> max. length of a string, n - no. of strings
// Space Complexity : O(k * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use hashmap to store the sorted string as key and the corresponding anagrams in the list
// 2. This is based on the property that all anagrams when sorted will be the same string.

import java.util.*;

public class GroupAnagrams {
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();

        for(String str : strs) {
            char[] strArray =  str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            if(stringListMap.containsKey(sortedStr)) {
                stringListMap.get(sortedStr).add(str);
            } else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                stringListMap.put(sortedStr, strList);
            }
        }
        return new ArrayList<>(stringListMap.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{" "}));
    }
}

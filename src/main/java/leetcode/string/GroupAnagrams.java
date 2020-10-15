package leetcode.string;

import org.junit.Test;

import java.util.*;

/**
 * Created by Cherie on 2020/04/06
 * https://leetcode.com/problems/group-anagrams/
 **/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            ans.computeIfAbsent(Arrays.toString(tmp), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(ans.values());
    }

    @Test
    public void test() {
        System.out.println(groupAnagrams(new String[]{"yup", "yup", "pup"}));
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}

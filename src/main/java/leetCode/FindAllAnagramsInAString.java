package leetCode;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/17
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * todo
 **/
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] sArray = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(sArray);
            if (Arrays.equals(pArray, sArray)) {
                set.add(i);
                boolean flag = false;
                while (i < s.length() - p.length() && s.charAt(i) == s.charAt(i + p.length())) {
                    set.add(i);
                    i++;
                    flag = true;
                }
                while (i < s.length() - p.length() && s.charAt(i) == s.charAt(i + p.length()) && !flag) {
                    i++;
                    flag = true;
                }
                if (flag) {
                    i--;
                }
            }
        }
        return new ArrayList(set);
    }

    public List<Integer> findAnagrams1(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.computeIfAbsent(p.charAt(i), k -> 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> tempMap;
        for (int i = 0; i <= s.length() - p.length(); i++) {
            tempMap = new HashMap<>(map);
            for (int j = i; j < i + p.length(); j++) {
                char temp = s.charAt(j);
                Integer tempCount = tempMap.get(temp);
                if (tempCount == null) {
                    break;
                }
                if (tempCount > 1) {
                    tempMap.put(temp, tempCount - 1);
                } else {
                    tempMap.remove(temp);
                }
            }
            if (tempMap.size() == 0) {
                list.add(i);
            }
        }
        return list;
    }

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(6);
        assertThat(findAnagrams("cbaebabacd", "abc"), equalTo(list));
    }

}

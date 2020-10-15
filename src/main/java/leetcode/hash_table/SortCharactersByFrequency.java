package leetcode.hash_table;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/22
 * https://leetcode.com/problems/sort-characters-by-frequency/
 **/
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = map.computeIfAbsent(s.charAt(i), k -> 0);
            map.put(s.charAt(i), count + 1);
        }

        map = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder sb = new StringBuilder();

        map.forEach((k, v) -> {
            for (Integer i = 0; i < v; i++) sb.append(k);
        });
        return sb.toString();
    }

    @Test
    public void test() {
        assertThat(frequencySort("ttree"), equalTo("tteer"));
        assertThat(frequencySort("aaaabccdde"), equalTo("aaaaccddbe"));
    }
}

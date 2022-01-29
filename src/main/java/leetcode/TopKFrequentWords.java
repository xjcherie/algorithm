package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Cherie on 2021/03/18
 * https://leetcode.com/problems/top-k-frequent-words/
 **/
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.computeIfAbsent(word, i -> 0) + 1);
        }

        HashMap<Integer, List<String>> countMap = new HashMap<>();
        map.forEach((key, value) -> countMap.computeIfAbsent(value, i -> new ArrayList<>()).add(key));
        List<Integer> countList = countMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        List<String> ans = new ArrayList<>();
        for (Integer count : countList) {
            if (k <= 0) {
                return ans;
            }
            List<String> wordList = countMap.get(count);
            Collections.sort(wordList);

            ans.addAll(wordList.subList(0, Math.min(k, wordList.size())));
            k -= wordList.size();
        }

        return ans;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("haha");
        list.add("hahi");
        list.add("aaha");
        list.add("aahai");

        list.sort((String o1, String o2) -> {
            char[] c1 = o1.toCharArray();
            char[] c2 = o2.toCharArray();
            for (int i = 0; i < Math.min(c1.length, c2.length); i++) {
                int res = c1[i] - c2[i];
                if (res != 0) return res;
            }
            return c1.length - c2.length;
        });
        System.out.println(list);
    }

}

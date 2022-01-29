package leetcode;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/longest-word-in-dictionary/
 **/
public class LongestWordInDictionary {

    public String longestWord(String[] words) {
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String word : words) {
            map.computeIfAbsent(word.length(), k -> new HashSet<>()).add(word);
        }

        List<Integer> countList = new ArrayList<>(map.keySet());
        Collections.sort(countList);

        int lastCount = 0;
        List<String> lastList = new ArrayList<>();
        for (Integer count : countList) {
            if (count != lastCount + 1) break;
            lastCount++;

            List<String> subList = new ArrayList<>(map.get(count));
            if (count == 1) {
                lastList = subList;
                continue;
            }

            List<String> newLastList = new ArrayList<>();
            for (String curStr : subList) {
                for (String lastStr : lastList) {
                    if (this.isNext(lastStr, curStr)) {
                        newLastList.add(curStr);
                        break;
                    }
                }
            }
            if (newLastList.size() == 0) {
                break;
            } else {
                lastList = newLastList;
            }
        }
        Collections.sort(lastList);
        return lastList.size() > 0 ? lastList.get(0) : "";
    }

    private boolean isNext(String curStr, String nextStr) {
        char[] c1 = curStr.toCharArray();
        char[] c2 = nextStr.toCharArray();

        int index = 0, length = c1.length;
        for (int i = 0; i < length; i++) {
            if (c1[i] == c2[i + index]) {
                continue;
            }
            if (index == 1) {
                return false;
            }
            index++;
            if (c1[i] != c2[i + index]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(longestWord(new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"}), equalTo("yodn"));
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Arrays.sort(words, (o1, o2) -> Integer.compare(o2.length(), o1.length()));
        System.out.println(Arrays.toString(words));
    }
}

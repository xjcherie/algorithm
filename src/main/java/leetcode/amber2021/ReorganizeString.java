package leetcode.amber2021;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/1/06
 * https://leetcode-cn.com/problems/reorganize-string/
 **/
public class ReorganizeString {

    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] countArray = new int[26];
        Arrays.fill(countArray, 0);

        int length = S.length();

        int maxCount = 0;
        for (int i = 0; i < length; i++) {
            countArray[S.charAt(i) - 'a']++;
            maxCount = Math.max(maxCount, countArray[S.charAt(i) - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }

        char[] resultArray = new char[length];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            int count = countArray[i];
            while (count > 0 && oddIndex < length && count <= halfLength) {
                resultArray[oddIndex] = (char) ('a' + i);
                count--;
                oddIndex = oddIndex + 2;
            }
            while (count > 0) {
                resultArray[evenIndex] = (char) ('a' + i);
                count--;
                evenIndex = evenIndex + 2;
            }
        }
        return new String(resultArray);
    }

    public String reorganizeString1(String S) {
        if (S.length() < 2) {
            return S;
        }

        int length = S.length();
        int[] countArray = new int[26];
        int maxCount = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            countArray[c - 'a']++;
            maxCount = Math.max(countArray[c - 'a'], maxCount);
        }

        if (maxCount > (length + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(((o1, o2) -> countArray[o2 - 'a'] - countArray[o1 - 'a']));
        for (int i = 0; i < 26; i++) {
            if (countArray[i] > 0) {
                queue.offer((char) (i + 'a'));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            char firstChar = queue.poll();
            char secondChar = queue.poll();
            sb.append(firstChar).append(secondChar);

            countArray[firstChar - 'a']--;
            countArray[secondChar - 'a']--;

            if (countArray[firstChar - 'a'] > 0) {
                queue.offer(firstChar);
            }
            if (countArray[secondChar - 'a'] > 0) {
                queue.offer(secondChar);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assertThat(reorganizeString("vvvlo"), equalTo("vlvov"));
        assertThat(reorganizeString("aabb"), equalTo("abab"));
        assertThat(reorganizeString("aaabb"), equalTo("ababa"));
    }

}

package leetcode;

import java.util.Stack;
import java.util.stream.Collector;

/**
 * Created by Cherie on 2021/03/04
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 **/
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String S) {
        if (S.length() <= 1) {
            return S;
        }

        Stack<Character> ansStack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (ansStack.isEmpty()) {
                ansStack.push(c);
                continue;
            }
            if (c == ansStack.peek()) {
                ansStack.pop();
                continue;
            }
            ansStack.push(c);
        }

        return ansStack.stream().collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
//        return ansStack.stream().map(Object::toString).collect(Collectors.joining());
    }

}

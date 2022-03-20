package leetcode.string;

/**
 * Created by Cherie on 2022/03/20
 * https://leetcode.com/problems/length-of-last-word/
 **/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int length = s.length() - 1; length >= 0; length--) {
            if (count == 0 && s.charAt(length) == ' ') {
                continue;
            }
            if (s.charAt(length) == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }

}

package leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/02/16
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 **/
public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        char[][] digitArray = new char[][]{
                {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
                {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
        };
        List<String> list = new ArrayList<>();
        char[] firstDigits = digitArray[Character.getNumericValue(digits.charAt(0))];
        for (char firstDigit : firstDigits) {
            list.add(String.valueOf(firstDigit));
        }
        for (int i = 1; i < digits.toCharArray().length; i++) {
            List<String> subList = new ArrayList<>();
            char[] subDigits = digitArray[Character.getNumericValue(digits.charAt(i))];
            for (String s : list) {
                for (char subDigit : subDigits) {
                    subList.add(s + subDigit);
                }
            }
            list = subList;
        }

        return list;
    }

}

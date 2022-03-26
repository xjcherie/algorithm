package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2022/03/22
 * https://leetcode.com/problems/multiply-strings/
 **/
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        List<StringBuilder> list = new ArrayList<>();
        int maxCount = 0;
        StringBuilder weight = new StringBuilder();


        for (int i = 0; i < num1.length(); i++) {
            int flag = 0;
            StringBuilder sub = new StringBuilder();
            sub.append(weight);
            for (int j = 0; j < num2.length(); j++) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + flag;
                sub.append(sum % 10);
                flag = sum / 10;
            }
            if (flag != 0) {
                sub.append(flag);
            }
            weight.append("0");
            maxCount = Math.max(maxCount, sub.length());
            list.add(sub);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxCount; i++) {
            int index = 0;
            int flag = 0, sum = 0;
            while (index < list.size()) {
                if (list.get(index).length() <= i) {
                    continue;
                }
                sum += list.get(index).charAt(i) - '0' + flag;
                sb.append(sum % 10);
                flag = sum / 10;
            }
        }
        return sb.reverse().toString();
    }

}

package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2022/05/08
 * https://leetcode.com/problems/pascals-triangle/
 **/
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> firstLevel = new ArrayList<>();
        firstLevel.add(1);
        list.add(firstLevel);

        for (int i = 1; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>(i + 1);
            subList.add(1);

            List<Integer> lastList = list.get(i - 1);
            for (int j = 1; j < i; j++) {
                subList.add(lastList.get(j - 1) + lastList.get(j));
            }

            subList.add(1);
            list.add(subList);
        }
        return list;
    }
}

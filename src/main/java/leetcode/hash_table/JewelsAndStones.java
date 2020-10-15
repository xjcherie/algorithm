package leetcode.hash_table;

/**
 * Created by Cherie on 2020/05/02
 * https://leetcode.com/problems/jewels-and-stones/
 **/
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        char cj;
        for (int j = 0; j < J.length(); j++) {
            cj = J.charAt(j);
            for (int s = 0; s < S.length(); s++) {
                if (S.charAt(s) == cj) {
                    sum++;
                }
            }
        }
        return sum;
    }

}

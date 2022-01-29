package leetcode;

import java.util.Arrays;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/assign-cookies/
 **/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;
        int contentCount = 0, sIndex = s.length - 1;

        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = g.length - 1; i >= 0; i--) {
            if (g[i] <= s[sIndex]) {
                contentCount++;
                sIndex--;
            }
            if (sIndex < 0) break;
        }
        return contentCount;
    }
}

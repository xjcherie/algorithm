package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cherie
 * @Date: 2022-08-10
 * <a href="https://leetcode.com/problems/restore-ip-addresses/">93. Restore IP Addresses</a>
 */
public class RestoreIpAddresses {

    private static final int SEG_COUNT = 4;
    private static final int STRING_DATA_LIMIT = 12;
    private final List<String> ans = new ArrayList<>();
    private final String[] segments = new String[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < SEG_COUNT || s.length() > STRING_DATA_LIMIT) {
            return ans;
        }
        this.dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                ans.add(String.join(".", segments));
            }
            return;
        }
        if (s.length() == segStart) {
            return;
        }
        if (s.charAt(segStart) == '0') {
            segments[segId] = "0";
            this.dfs(s, segId + 1, segStart + 1);
        }
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = String.valueOf(addr);
                this.dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}

package leetcode.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/05/15
 * https://leetcode.com/problems/simplify-path/
 **/
public class SimplifyPath {

    private static final char dot = '.';
    private static final char slash = '/';

    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        StringBuilder dotStr = new StringBuilder();
        String slashStr = "/";
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == dot) {
                if (slashStr.length() > 0) {
                    sb.append(slash);
                    slashStr = "";
                }
                dotStr.append(c);
            } else if (c == slash) {
                if (dotStr.length() > 0) {
                    if (dotStr.length() == 1 && sb.length() >= 1 && sb.charAt(sb.length() - 1) == slash) {
                        sb = new StringBuilder(sb.substring(0, sb.length() - 1));
                    } else if (dotStr.length() == 2 && sb.length() >= 1 && sb.charAt(sb.length() - 1) == slash) {
                        sb = new StringBuilder(sb.substring(0, this.getLastSlash(sb)));
                    } else {
                        sb.append(dotStr);
                    }
                    dotStr = new StringBuilder();
                }
                if (slashStr.length() == 0) {
                    slashStr = "/";
                }
            } else {
                if (slashStr.length() > 0) {
                    sb.append(slashStr);
                    slashStr = "";
                }
                if (dotStr.length() > 0) {
                    sb.append(dotStr);
                    dotStr = new StringBuilder();
                }
                sb.append(c);
            }
        }
        if (dotStr.length() > 0) {
            if (dotStr.length() == 1 && sb.length() > 1) {
                sb = new StringBuilder(sb.substring(0, sb.length() - 1));
            } else if (dotStr.length() == 2) {
                sb = new StringBuilder(sb.substring(0, this.getLastSlash(sb)));
            } else {
                sb.append(dotStr);
            }
        }
        if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == dot && sb.charAt(sb.length() - 2) != dot) {
            return sb.substring(0, sb.length() - 1);
        }
        if (sb.length() == 0) {
            sb.append(slash);
        }
        return sb.toString();
    }

    private int getLastSlash(StringBuilder sb) {
        int lastIndex = 0;
        for (int j = sb.length() - 2; j >= 0; j--) {
            if (sb.charAt(j) == slash) {
                lastIndex = j;
                break;
            }
        }
        return lastIndex;
    }

    @Test
    public void test() {
//        assertThat(simplifyPath("/a/./b/../../c/"), equalTo("/c"));
//        assertThat(simplifyPath("/a//b////c/d//././/.."), equalTo("/a/b/c"));
        assertThat(simplifyPath("/..hidden"), equalTo("/..hidden"));
        assertThat(simplifyPath("/hello../world"), equalTo("/hello../world"));
        assertThat(simplifyPath("/../"), equalTo("/"));


    }
}

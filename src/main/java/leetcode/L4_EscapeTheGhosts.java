package leetcode;

/**
 * 二维数组距离的计算
 * https://leetcode.com/problems/escape-the-ghosts/
 */
public class L4_EscapeTheGhosts {
    private static boolean escapeGhosts(int[][] ghosts, int[] target) {
        int length = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if ((Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1])) < length) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        {
            int[][] ghosts = {{1, 0}, {0, 3}};
            int[] target = {0, 1};
            System.out.println(escapeGhosts(ghosts, target));
        }
        {
            int[][] ghosts = {{1, 0}};
            int[] target = {2, 0};
            System.out.println(escapeGhosts(ghosts, target));
        }
        {
            int[][] ghosts = {{1, 9}, {2, -5}, {3, 8}, {9, 8}, {-1, 3}};
            int[] target = {8, -10};
            System.out.println(escapeGhosts(ghosts, target));
        }
        {
            int[][] ghosts = {{5, 0}, {-10, -2}, {0, -5}, {-2, -2}, {-7, 1}};
            int[] target = {7, 7};
            System.out.println(escapeGhosts(ghosts, target));
        }

    }
}
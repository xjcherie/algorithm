package practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Cherie
 * @Date: 2022-05-30
 * 输出 1到n之间 的与 7 有关数字的个数。
 * 一个数与7有关是指这个数是 7 的倍数，或者是包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）
 */
public class SevenGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split(" ");
        int length = array.length;
        int count = 0;
        for (String s : array) {
            count += Integer.parseInt(s);
        }
        int[] ans = new int[length];
        int index = 1;
        while (count > 0) {
            int ansIndex = index % length - 1;
            if (index % 7 == 0) {
                ans[ansIndex]++;
                count--;
            } else {
                String str = String.valueOf(index);
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '7') {
                        ans[ansIndex]++;
                        count--;
                        break;
                    }
                }
            }
            index++;
        }
        System.out.println(Arrays.toString(ans));
    }
}

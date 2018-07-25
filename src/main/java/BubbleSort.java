import java.util.Arrays;

/**
 * create by cherie on 2018/7/15.
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] dataArray = {45, 34, 78, 12, 34, 32, 29, 64};
        int n = dataArray.length, temp;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (dataArray[i] < dataArray[j]) {
                    temp = dataArray[i];
                    dataArray[i] = dataArray[j];
                    dataArray[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(dataArray));

    }

}

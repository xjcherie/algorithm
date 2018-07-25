import java.util.Arrays;

/**
 * create by cherie on 2018/7/21.
 * 桶排序
 */
public class BucketSort {

    private static final int MAX = 10;

    public static void main(String[] args) {
        int[] dataArray = {7, 3, 8, 9, 6, 1, 8, 1, 2};
        bucketSort(dataArray, dataArray.length, MAX);
        System.out.println(Arrays.toString(dataArray));
    }

    private static void bucketSort(int[] dataArray, int n, int max) {
        int[] tempArray = new int[n];
        int[] countArray = new int[max];

        int i;
        for (i = 0; i < n; i++) {
            tempArray[i] = dataArray[i];
        }
        for (i = 0; i < n; i++) {
            countArray[i] = 0;
        }
        for (i = 0; i < n; i++) {
            countArray[dataArray[i]]++;
        }
        for (i = 1; i < max; i++) {
            countArray[i] = countArray[i - 1] + countArray[i];
        }
        for (i = n - 1; i >= 0; i--) {
            dataArray[--countArray[tempArray[i]]] = tempArray[i];
        }
    }
}

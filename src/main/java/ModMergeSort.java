import java.util.Arrays;

/**
 * create by cherie on 2018/7/21.
 * 优化的归并排序
 */
public class ModMergeSort {

    private static final int THRESHOLD = 28;

    public static void main(String[] args) {
        int[] dataArray = {25, 34, 45, 32, 78, 12, 34, 64};
        int[] tempArray = new int[8];
        modMergeSort(dataArray, tempArray, 0, 7);
        System.out.println(Arrays.toString(dataArray));
    }

    private static void modMergeSort(int[] dataArray, int[] tempArray, int left, int right) {
        int middle;
        if (right - left + 1 > THRESHOLD) {
            middle = (left + right) / 2;
            modMergeSort(dataArray, tempArray, left, middle);
            modMergeSort(dataArray, tempArray, middle + 1, right);
            modMerge(dataArray, tempArray, left, right, middle);
        } else {
            MergeSort.mergeSort(dataArray, tempArray, left, right);
        }
    }

    private static void modMerge(int[] dataArray, int[] tempArray, int left, int right, int middle) {
        int i, j, k, index1, index2;
        for (i = left; i <= middle; i++) {
            tempArray[i] = dataArray[i];
        }
        for (j = 1; j < right - middle; j++) {
            tempArray[right - j + 1] = dataArray[j + middle];
        }

        for (index1 = left, index2 = right, k = left; k <= right; k++) {
            if (tempArray[index1] <= tempArray[index2]) {
                dataArray[k] = tempArray[index1++];
            } else {
                dataArray[k] = tempArray[index2--];
            }
        }
    }

}

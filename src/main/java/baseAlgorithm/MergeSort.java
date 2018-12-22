package baseAlgorithm;

/**
 * create by cherie on 2018/7/15.
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] dataArray = {25, 34, 45, 32, 78, 12, 34, 64};
        int[] tempArray = new int[8];
        mergeSort(dataArray, tempArray, 0, 7);
    }

    public static void mergeSort(int[] dataArray, int[] tempArray, int left, int right) {
        int middle;
        if (left < right) {
            middle = (left + right) / 2;
            mergeSort(dataArray, tempArray, left, middle);
            mergeSort(dataArray, tempArray, middle + 1, right);
            merge(dataArray, tempArray, left, right, middle);
        }
    }

    private static void merge(int[] dataArray, int[] tempArray, int left, int right, int middle) {
        int i, j, index1, index2;
        for (j = left; j <= right; j++) {
            tempArray[j] = dataArray[j];
        }
        index1 = left;
        index2 = middle + 1;
        i = left;
        while (index1 <= middle && index2 <= right) {
            if (tempArray[index1] <= tempArray[index2]) {
                dataArray[i++] = tempArray[index1++];
            } else {
                dataArray[i++] = tempArray[index2++];
            }
        }
        while (index1 <= middle) {
            dataArray[i++] = tempArray[index1++];
        }
        while (index2 <= right) {
            dataArray[i++] = tempArray[index2++];
        }
    }
}

package baseSort;

import java.util.Arrays;

/**
 * create by cherie on 2018/7/21.
 * 索引排序
 */
public class IndexSort {

    public static void main(String[] args) {
        int[] dataArray = {29, 25, 34, 64, 34, 12, 32, 45};
        int[] tempArray = new int[8];
        indexSort(dataArray, tempArray, 7);
        System.out.println(Arrays.toString(dataArray));
    }

    private static void indexSort(int[] dataArray, int[] indexArray, int n) {
        int i, j;
        for (i = 0; i < n; i++) {
            indexArray[i] = i;
        }
        for (i = 1; i < n; i++) {
            for (j = i; j > 0; j--) {
                if (dataArray[indexArray[j]] < dataArray[indexArray[j - 1]]) {
                    swap(indexArray, j, j - 1);
                } else {
                    break;
                }
            }
        }
        adjustRecord(dataArray, indexArray, n);
    }

    private static void adjustRecord(int[] dataArray, int[] indexArray, int n) {
        int temp;
        int i, j;
        for (i = 0; i < n; i++) {
            j = i;
            temp = dataArray[i];
            while (indexArray[j] != i) {
                int k = indexArray[j];
                dataArray[j] = dataArray[k];
                indexArray[j] = j;
                j = k;
            }
            dataArray[j] = temp;
            indexArray[j] = j;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

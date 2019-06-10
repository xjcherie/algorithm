package baseSort;

import java.util.Arrays;

/**
 * create by cherie on 24/02/2019.
 * 快速排序
 */
public class QuickSort {

    /**
     * 快速排序
     */
    private static void quickSort(int[] recordArray, int l, int r) {
        if (l >= r) return;

        // 取轴值
        int pivot = (l + r) / 2;

        // 将轴值上的数与最右端的数，交换位置
        int temp = recordArray[pivot];
        recordArray[pivot] = recordArray[r];
        recordArray[r] = temp;

        // 得到已在正确位置的轴值下标
        pivot = partition(recordArray, l, r);

        // 递归循环
        quickSort(recordArray, l, pivot - 1);
        quickSort(recordArray, pivot + 1, r);
    }

    /**
     * 分割比轴值大和小的数，得出轴值正确的位置下标
     */
    private static int partition(int[] recordArray, int l, int r) {
        int temp = recordArray[r];

        while (l != r) {
            while (recordArray[l] <= temp && l < r)
                l++;
            if (l < r) {
                recordArray[r] = recordArray[l];
                r--;
            }
            while (recordArray[r] >= temp && l < r)
                r--;
            if (l < r) {
                recordArray[l] = recordArray[r];
                l++;
            }
        }
        recordArray[l] = temp;
        return l;
    }


    public static void main(String[] args) {
        int[] recordArray = {25, 34, 45, 32, 34, 12, 29, 64};
        quickSort(recordArray, 0, recordArray.length - 1);
        System.out.println(Arrays.toString(recordArray));
    }
}

package Algorithm.sort.merge;

import Algorithm.sort.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: soft
 * Date: 14-9-6
 * Time: 下午2:54
 * To change this template use File | Settings | File Templates.
 *
 * 核心思想：将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
 *
 * 时间复杂度：nlog2n
 *
 * 空间复杂度：每趟排序都需要temArray的额外空间，空间复杂度为n。
 *
 * 稳定，适合大列表
 */
public class MergeSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        mergeSort(array, 0, length-1);
    }

    private void merge(int[] array, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;
        int length = high - low + 1;
        int[] temArray = new int[length];
        int k = 0;
        while (i <= middle && j <= high) {
            if (array[i] < array[j]) {
                temArray[k++] = array[i++];
            } else {
                temArray[k++] = array[j++];
            }
        }

        while (i <= middle) {
            temArray[k++] = array[i++];
        }
        while (j <= high) {
            temArray[k++] = array[j++];
        }

        for (int m = 0; m < length; m++) {
            array[low++] = temArray[m];
        }
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = (low + high)/2;
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            merge(array, low, middle, high);
        }
    }
}

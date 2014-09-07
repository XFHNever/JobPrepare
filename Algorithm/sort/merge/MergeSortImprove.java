package Algorithm.sort.merge;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/9/7.
 *
 * 改进可以省去检查子序列是否结束的判断，提供程序执行效率，但是没有数量级上的提升。
 */
public class MergeSortImprove implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        mergeSort(array, 0, length-1);
    }

    private void merge(int[] array, int low, int middle, int high) {
        int length = high-low+1;
        int[] temArray = new int[length];
        for (int i = low; i <=middle; i++) {
            temArray[i-low] = array[i];
        }

        for (int i = middle+1; i<=high; i++) {
            temArray[high+middle+1-i-low] = array[i];
        }

        int i = 0, j=length-1;
        while (i<= j) {
            if (temArray[i] <= temArray[j]) {
                array[low++] = temArray[i++];
            } else {
                array[low++] = temArray[j--];
            }
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
